package solution2.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import solution2.view.PuzzleView_AnotherSolution;

/**
 *
 * @author Drol
 */
public class PuzzleController_AnotherSolution {

    private PuzzleView_AnotherSolution view;
    private TimeElapsed time;
    private boolean win = false;

    public PuzzleController_AnotherSolution(PuzzleView_AnotherSolution view) {
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
                int[] indexOfCurrentButton = getIndexOfButton(currentButton.getText());
                int[] indexOfEmptyButton = getIndexOfButton("");
                //check that current button is top, left , right, bottom of empty bottom or not
                boolean isTop = (indexOfCurrentButton[0] == indexOfEmptyButton[0])
                        && (indexOfEmptyButton[1] - 1 == indexOfCurrentButton[1]);
                boolean isLeft = (indexOfCurrentButton[0] == indexOfEmptyButton[0] - 1)
                        && (indexOfEmptyButton[1] == indexOfCurrentButton[1]);
                boolean isRight = (indexOfCurrentButton[0] == indexOfEmptyButton[0] + 1)
                        && (indexOfEmptyButton[1] == indexOfCurrentButton[1]);
                boolean isBot = (indexOfCurrentButton[0] == indexOfEmptyButton[0])
                        && (indexOfEmptyButton[1] + 1 == indexOfCurrentButton[1]);
                //check if current button is near empty button or not. if true then swap them
                if (isTop || isBot || isLeft || isRight) {
                    swapButtons(indexOfCurrentButton, indexOfEmptyButton);
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

    /**
     * Get index of button in 2-dimension buttons
     *
     * @param valueOfButton valueOfButton need to get
     * @return position of button in an integer array. first value is
     * Y-position, second value is X-position. return -1 if could not find.
     */
    private int[] getIndexOfButton(String valueOfButton) {
        JButton[][] buttons = view.getButtons();
        int widthSize = buttons.length;
        for (int i = 0; i < widthSize; i++) {
            for (int j = 0; j < widthSize; j++) {
                if (buttons[i][j].getText().equals(valueOfButton)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private void swapButtons(int[] indexOfFirstButton, int[] indexOfSecondButton) {
        JButton button[][] = view.getButtons();
        String textOfFirstButton = button[indexOfFirstButton[0]][indexOfFirstButton[1]].getText();
        String textOfSecondButton = button[indexOfSecondButton[0]][indexOfSecondButton[1]].getText();
        //swap vs empty button
        button[indexOfFirstButton[0]][indexOfFirstButton[1]].setText(textOfSecondButton);
        button[indexOfSecondButton[0]][indexOfSecondButton[1]].setText(textOfFirstButton);
    }

    public void checkWin() {
        JButton[][] buttons = view.getButtons();
        List<JButton> buttonList = new ArrayList<>();
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                buttonList.add(buttons[j][i]);
            }
        }
        //if player win the game then last element of list is empty. we just need to run in to sise -1 to check win
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
                Logger.getLogger(PuzzleController_AnotherSolution.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
