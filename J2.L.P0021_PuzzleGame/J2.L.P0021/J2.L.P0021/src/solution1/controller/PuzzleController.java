/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import solution1.view.PuzzleView;

/**
 *
 * @author Drol
 */
public class PuzzleController {

    private PuzzleView view;
    private TimeElapsed time;
    //keep state player win or not
    private boolean win = false;

    public PuzzleController(PuzzleView view) {
        this.view = view;
        initView();
    }

    private void initView() {
        view.setMoveCount(0);
        view.setTimeElapse(0);
    }

    public void initController() {
        view.addActionjButtonNewGame(e -> actionButtonNewGame());
        view.addWindowListener(new WindowAction());
        view.addActionButtonNumbers(new ActionButtonNumber());
        time = new TimeElapsed();
        time.start();
        checkWin();
    }

    private class WindowAction extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            if (time != null) {
                time.stop();
            }
            int chose = view.displayConfirm("Are you sure want to close ???");
            if (chose == JOptionPane.YES_OPTION) {
                view.quit();
            } else if (win == false) {
                time = new TimeElapsed();
                time.start();
            }
        }
    }

    private void actionButtonNewGame() {
        if (time != null) {
            time.stop();
        }
        String mapSize = view.getGameMapSize().replace(" ", "");
        int widthSize = Integer.parseInt(mapSize.split("x")[0]);
        int chose = view.displayConfirm("Play new game ???");
        if (chose == JOptionPane.YES_OPTION) {
            view.createGameMap(widthSize);
            this.initView();
            win = false;
            view.addActionButtonNumbers(new ActionButtonNumber());
            time = new TimeElapsed();
            time.start();
            checkWin();
        } else if (win == false) {
            time = new TimeElapsed();
            time.start();
        }
    }

    private class ActionButtonNumber implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton currentButton = (JButton) e.getSource();
            //check if current button is empty button or not
            if (currentButton.getText().equals("")) {
                //do nothing
            } else {
                int indexOfCurrentButton = getIndexOfButton(currentButton.getText());
                //check if current button is near empty button or not. if true then swap them
                if (isNearEmptyButton(indexOfCurrentButton)) {
                    swapButtonWithEmptyButton(indexOfCurrentButton);
                    updateMoveCount();
                    checkWin();
                }
            }
        }
    }

    private void updateMoveCount() {
        String moveCount[] = view.getMoveCount().split(" ");
        int newMoveCount = Integer.parseInt(moveCount[2]) + 1;
        view.setMoveCount(newMoveCount);
    }

    private void swapButtonWithEmptyButton(int indexOfCurrentButton) {
        int indexOfEmptyButton = getIndexOfButton("");
        List<JButton> buttonList = view.getButtonList();
        String valueOfCurrenButton = buttonList.get(indexOfCurrentButton).getText();
        buttonList.get(indexOfEmptyButton).setText(valueOfCurrenButton);
        buttonList.get(indexOfCurrentButton).setText("");
    }

    private int getIndexOfButton(String valueOfButton) {
        List<JButton> buttonList = view.getButtonList();
        for (int i = 0; i < buttonList.size(); i++) {
            String buttonText = buttonList.get(i).getText();
            if (buttonText.equals(valueOfButton)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isTopOfEmptyButton(int indexOfCurrentButton) {
        List<JButton> buttonList = view.getButtonList();
        int indexOfEmptyButton = getIndexOfButton("");
        //width size of game map
        int width = (int) Math.sqrt(buttonList.size());
        //index of button on top of empty button
        int indexTopOfEmptyButton = indexOfEmptyButton - width;
        if (indexTopOfEmptyButton >= 0) {
            if (indexOfCurrentButton == indexTopOfEmptyButton) {
                return true;
            }
        }
        return false;
    }

    public boolean isBottomOfEmptyButton(int indexOfCurrentButton) {
        List<JButton> buttonList = view.getButtonList();
        int indexOfEmptyButton = getIndexOfButton("");
        //size of game map
        int size = buttonList.size();
        //width size of game map
        int width = (int) Math.sqrt(size);
        //index of button on top of empty button
        int indexBotOfEmptyButton = indexOfEmptyButton + width;
        if (indexBotOfEmptyButton < size) {
            if (indexOfCurrentButton == indexBotOfEmptyButton) {
                return true;
            }
        }
        return false;
    }

    public boolean isLeftOfEmptyButton(int indexOfCurrentButton) {
        List<JButton> buttonList = view.getButtonList();
        int indexOfEmptyButton = getIndexOfButton("");
        //size of game map
        int size = buttonList.size();
        //width size of game map
        int width = (int) Math.sqrt(size);
        //index of button is left side of empty button
        int indexLeftOfEmptyButton = indexOfEmptyButton - 1;
        if (indexLeftOfEmptyButton >= 0 && indexOfEmptyButton % width != 0) {
            if (indexOfCurrentButton == indexLeftOfEmptyButton) {
                return true;
            }
        }
        return false;
    }

    public boolean isRightOfEmptyButton(int indexOfCurrentButton) {
        List<JButton> buttonList = view.getButtonList();
        int indexOfEmptyButton = getIndexOfButton("");
        //size of game map
        int size = buttonList.size();
        //width size of game map
        int width = (int) Math.sqrt(size);
        //index of button is left side of empty button
        int indexRightOfEmptyButton = indexOfEmptyButton + 1;
        if (indexRightOfEmptyButton < size && indexRightOfEmptyButton % width != 0) {
            if (indexOfCurrentButton == indexRightOfEmptyButton) {
                return true;
            }
        }
        return false;
    }

    public boolean isNearEmptyButton(int indexOfCurrentButton) {
        return isTopOfEmptyButton(indexOfCurrentButton) || isBottomOfEmptyButton(indexOfCurrentButton)
                || isRightOfEmptyButton(indexOfCurrentButton) || isLeftOfEmptyButton(indexOfCurrentButton);
    }

    public void checkWin() {
        List<JButton> buttonList = view.getButtonList();
        for (int i = 0; i < buttonList.size() - 1; i++) {
            if (buttonList.get(i).getText().equals("" + (i + 1))) {
            } else {
                return;
            }
        }
        if (time != null) {
            time.stop();
        }
        win = true;
        view.removeAllActionOfButtonNumbers();
        view.displayNotify("Congratulation!! \nYou win the game.");

    }

    private class TimeElapsed extends Thread {

        @Override
        public void run() {
            try {
                while (true) {
                    String elapse[] = view.getTimeElapse().split(" ");
                    int newTime = Integer.parseInt(elapse[1]) + 1;
                    Thread.sleep(1000);
                    view.setTimeElapse(newTime);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(PuzzleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
