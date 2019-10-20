/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import business.EncodeManage;
import view.EncodeView;

/**
 *
 * @author Drol
 */
public class EncodeController {

    private EncodeView view;
    private EncodeManage model;

    public EncodeController(EncodeView view, EncodeManage model) {
        this.view = view;
        this.model = model;
        initView();
    }

    private void initView() {

    }

    /**
     * Set up action for view
     */
    public void initController() {
        view.addActionListenerBrowseImage(e -> actionForBrowseImage());
        view.addActionListenerHideMessage(e -> actionForHideMessage());
        view.addActionListenerQuit(e -> actionForQuit());
        view.addActionListenerSaveStego(e -> actionForSaveStego());
        view.addWindowListener(new WindowClose());
        view.addMouseActionSecretText(new MouseClickSecretText());
    }

    /**
     * Class for action for click on text field secret text
     */
    private class MouseClickSecretText extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            view.setSecretMessage("");
        }

    }

    /**
     * Action for quit button
     */
    private void actionForQuit() {
        //check if stego image exist or not. if exist then ask user to save it before close
        if (model.isSavedStego() == false) {
            int chose = view.displayConfirm("Do you want to save Stego-image before close.");
            switch (chose) {
                case JOptionPane.OK_OPTION: {
                    actionForSaveStego();
                    break;
                }
                case JOptionPane.CANCEL_OPTION: {
                    return;
                }
                case JOptionPane.NO_OPTION: {
                    break;
                }
            }
        }
        view.exitProgram();
    }

    /**
     * Action for browse image button
     */
    private void actionForBrowseImage() {
        //check if stego image was already saved or not
        if (model.isSavedStego() == false) {
            int chose = view.displayConfirm("Do you want to save Stego-image before browse another image.");
            switch (chose) {
                case JOptionPane.OK_OPTION: {
                    actionForSaveStego();
                    break;
                }
                case JOptionPane.CANCEL_OPTION: {
                    return;
                }
                case JOptionPane.NO_OPTION: {
                    break;
                }
            }
        }
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setMultiSelectionEnabled(false);
        int userChose = fileChooser.showOpenDialog(null);
        switch (userChose) {
            case JFileChooser.APPROVE_OPTION: {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedImage image = ImageIO.read(file);
                    //ImageIO.read() return null if file is not an image or image that not supportted
                    if (image != null) {
                        //
                        model.setOriginalImage(image);
                        view.setOriginalImage(new ImageIcon(image));
                        //
                        model.setStegoImage(null);
                        view.setStegoImage(null);
                        //
                        model.setSavedStego(true);
                        view.setOriginalImagePath(file.getPath());
                        model.setImageExtension(getFileExtension(file.getPath()));
                    } else {
                        view.displayError("File is not an image.");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(EncodeController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case JFileChooser.CANCEL_OPTION: {
                break;
            }
            case JFileChooser.ERROR_OPTION: {
                view.displayError("Get error while chose file");
                break;
            }
        }
    }

    /**
     * Action for hide message button
     */
    private void actionForHideMessage() {
        //check if already have original image or not
        if (model.getOriginalImage() == null) {
            view.displayError("Do not have image");
        } else {
            String message = view.getSecretMessage();
            //check if user input message or not
            if (message.length() == 0) {
                view.displayError("Plese enter secret-message.");
            } else {
                int imageSize = model.getOriginalImage().getWidth() * model.getOriginalImage().getHeight();
                // 001111111 is key mark. we use this to mark that where message begin and end in image (after encode)
                int messageSize = ("001111111" + message + "001111111").length() * 8;
                //check if image size is big enough to encode message
                if (imageSize < messageSize) {
                    view.displayError("Message too long.");
                } else {
                    model.encodeMessage(message);
                    BufferedImage stegoImage = model.getStegoImage();
                    view.setStegoImage(new ImageIcon(stegoImage));
                    model.setSavedStego(false);
                }
            }
        }
    }

    /**
     * Action for save stego-image button
     */
    private void actionForSaveStego() {
        //check if stego image is exist or not
        if (model.getStegoImage() == null) {
            view.displayError("Do not have Stego-image");
        } else {
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setMultiSelectionEnabled(false);
            int userChose = fileChooser.showSaveDialog(null);
            switch (userChose) {
                case JFileChooser.APPROVE_OPTION: {
                    String filePath = fileChooser.getSelectedFile().getPath();
                    String extension = model.getImageExtension();
                    filePath = filePath + "." + extension;
                    File file = new File(filePath);
                    try {
                        BufferedImage stegoImage = model.getStegoImage();
                        ImageIO.write(stegoImage, "png", file);
                        model.setSavedStego(true);
                    } catch (IOException ex) {
                        Logger.getLogger(EncodeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case JFileChooser.CANCEL_OPTION: {
                    break;
                }
                case JFileChooser.ERROR_OPTION: {
                    view.displayError("Get error while save file");
                    break;
                }
            }
        }
    }

    /**
     * Class for action for close window
     */
    private class WindowClose extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            //ask user save stego image befor close program
            if (model.isSavedStego() == false) {
                int chose = view.displayConfirm("Do you want to save Stego-image before close.");
                switch (chose) {
                    case JOptionPane.OK_OPTION: {
                        actionForSaveStego();
                        break;
                    }
                    case JOptionPane.CANCEL_OPTION: {
                        return;
                    }
                    case JOptionPane.NO_OPTION: {
                        break;
                    }
                }
            }
            e.getWindow().dispose();
        }
    }

    /**
     * Get file extension. such as: (abc.png -> png)
     *
     * @param filename file name. include extension.
     * @return
     */
    private String getFileExtension(String filename) {
        String ext = "";
        int mid = filename.lastIndexOf(".");
        if (mid == -1) {
            ext = "";
        } else {
            ext = filename.substring(mid + 1, filename.length());
        }
        return ext;
    }
}
