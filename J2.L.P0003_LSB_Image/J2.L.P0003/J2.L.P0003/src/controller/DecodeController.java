/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import business.DecodeManage;
import view.DecodeView;

/**
 *
 * @author Drol
 */
public class DecodeController {

    private DecodeView view;
    private DecodeManage manage;

    public DecodeController(DecodeView view, DecodeManage manage) {
        this.view = view;
        this.manage = manage;
    }

    //set up action for button in view
    public void initController() {
        view.addActionListenerBrowseImage(e -> browse());
        view.addActionListenerQuit(e -> quit());
        view.addActionListenerShowHiddenMessage(e -> showMessage());
        view.addMouseActionSecretText(new MouseClickSecretText());
    }

    /**
     * Class for action when click in text field Secret text
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
    private void quit() {
        view.exitDecode();
    }

    /**
     * Action for browse button
     */
    private void browse() {
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setMultiSelectionEnabled(false);
        int userChose = fileChooser.showOpenDialog(null);
        //check user chose
        switch (userChose) {
            case JFileChooser.APPROVE_OPTION: {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedImage image = ImageIO.read(file);
                    //ImageIO.read() return null if file is not an image or image that supportted
                    if (image != null) {
                        manage.setStegoImage(image);
                        view.setStegoImagePath(file.getPath());
                        view.setStegoImage(new ImageIcon(image));
                        view.setSecretMessage("<<a secret message>>");
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
     * Action for show message button
     */
    private void showMessage() {
        //check if stego image is exist or not
        if (manage.getStegoImage() == null) {
            view.displayError("Do not have Stego-image");
        } else {
            String message = manage.decodeMessage();
            //check if image have message or not
            if (message.equals("")) {
                view.displayNotify("Do not have message");
            } else {
                view.setSecretMessage(message);
            }
        }
    }

}
