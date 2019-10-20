/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution1.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Drol
 */
public class PuzzleView extends JFrame {

    //size of button
    private final int BUTTON_HEIGHT = 55;
    private final int BUTTON_WIDTH = 55;

    private final int SPACE_BETWEEN_BUTTON_HORIZONTAL = 15;
    private final int SPACE_BETWEEN_BUTTON_VERTICAL = 25;
    //space between panel game and main frame
    private final int HORIZON_GAP = 30;
    private final int VERTICAL_GAP = 10;
    //size of other components
    private final int COMPONENT_HEIGHT = 30;
    private final int COMPONENT_WIDTH = 50;
    //
    private final int FREE_SPACE = 60;

    public PuzzleView() {
        initComponents();
    }

    private void initComponents() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("NPG");
        this.setLayout(null);

        DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
        cbModel.addElement("3x3");
        cbModel.addElement("4x4");
        cbModel.addElement("5x5");
        cbModel.addElement("6x6");
        cbModel.addElement("7x7");
        cbModel.addElement("8x8");
        cbModel.addElement("9x9");
        jComboboxSize.setModel(cbModel);
        jLabelTimeElapse.setText("Elapsed: 0 sec");
        jLabelMoveCount.setText("Move count: 0");
        jButtonNewGame.setText("New game");
        jLabelSize.setText("Size:");

        this.add(gameMap);
        this.add(jComboboxSize);
        this.add(jLabelTimeElapse);
        this.add(jLabelMoveCount);
        this.add(jLabelSize);
        this.add(jButtonNewGame);
    }

    public void createGameMap(int widthSize) {
        setGameMapSize(widthSize);
        gameMap.removeAll();
        buttonList = new ArrayList<>();
        //create button and its value
        for (int i = 0; i < widthSize * widthSize - 1; i++) {
            JButton button = new JButton("" + (i + 1));
            button.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            buttonList.add(button);
        }
        //create empty button
        JButton button = new JButton("");
        button.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonList.add(button);
        do {
            //shuffle value of all buttons
            Collections.shuffle(buttonList);
        } while (isGameSolvable() == false);
        //add button to panel. this panel will show button in form 3x3, 4x4,....
        buttonList.forEach(e -> {
            gameMap.add(e);
        });
        //set new position of all components
        gameMap.setLayout(new GridLayout(widthSize, widthSize, SPACE_BETWEEN_BUTTON_HORIZONTAL, SPACE_BETWEEN_BUTTON_VERTICAL));
        int panel_width = widthSize * BUTTON_WIDTH + (widthSize - 1) * SPACE_BETWEEN_BUTTON_HORIZONTAL;
        int panel_height = widthSize * BUTTON_HEIGHT + (widthSize - 1) * SPACE_BETWEEN_BUTTON_VERTICAL;

        int frame_width = panel_width + 2 * HORIZON_GAP;
        int frame_height = panel_height + 3 * VERTICAL_GAP + 5 * COMPONENT_HEIGHT + FREE_SPACE;
        this.setSize(frame_width, frame_height);

        gameMap.setBounds(HORIZON_GAP, VERTICAL_GAP, panel_width, panel_height);
        jLabelMoveCount.setBounds(HORIZON_GAP, 2 * VERTICAL_GAP + panel_height, panel_width, COMPONENT_HEIGHT);
        jLabelTimeElapse.setBounds(HORIZON_GAP, 2 * VERTICAL_GAP + panel_height + COMPONENT_HEIGHT, panel_width, COMPONENT_HEIGHT);
        jLabelSize.setBounds(HORIZON_GAP, 2 * VERTICAL_GAP + panel_height + 2 * COMPONENT_HEIGHT, 40, COMPONENT_HEIGHT);
        jComboboxSize.setBounds(HORIZON_GAP + 40, 2 * VERTICAL_GAP + panel_height + 2 * COMPONENT_HEIGHT, 50, COMPONENT_HEIGHT);
        jButtonNewGame.setBounds(HORIZON_GAP, 2 * VERTICAL_GAP + panel_height + 3 * COMPONENT_HEIGHT + 20, 100, COMPONENT_HEIGHT);

    }

    private boolean isGameSolvable() {
        int size = buttonList.size();
        //assume button A have index b
        //count is number of button have value smaller than A but have index bigger than A
        int count = 0;

        int isGameCanSolve = 0;
        //loop all button
        for (int i = 0; i < size - 1; i++) {
            //if current button is empty then do nothing
            if (buttonList.get(i).getText().equals("")) {
            } else {
                //integer value of current button
                int a = Integer.parseInt(buttonList.get(i).getText());
                //loop all button have index bigger than current button
                for (int j = i + 1; j < size; j++) {
                    if (buttonList.get(j).getText().equals("")) {
                    } else {
                        int b = Integer.parseInt(buttonList.get(j).getText());
                        //compare 2 value to count number of button have value small than current button
                        if (a > b) {
                            count++;
                        }
                    }
                }
                isGameCanSolve += count;
                count = 0;
            }
        }
        int widthSize = (int) Math.sqrt(size);
        /*check if game can solve or not
        if size map is odd then isGameCanSolve must even
        if size map is even then 
        -if isGameCanSolve is even then empty position must even (count from top to bot, firt row is 1)
        -if isGameCanSolve is odd then empty position must odd (count from top to bot, firt row is 1)
         */
        if (size % 2 == 1) {
            return isGameCanSolve % 2 == 0;
        } else {
            for (int i = 0; i < buttonList.size(); i++) {
                String buttonText = buttonList.get(i).getText();
                if (buttonText.equals("")) {
                    if (isGameCanSolve % 2 == 0) {
                        return (i / widthSize + 1) % 2 == 0;
                    } else {
                        return (i / widthSize + 1) % 2 == 1;
                    }
                }
            }
        }
        return false;
    }

    public String getGameMapSize() {
        return jComboboxSize.getSelectedItem().toString();
    }

    public void setGameMapSize(int widthSize) {
        jComboboxSize.setSelectedItem(widthSize + "x" + widthSize);
    }

    public void quit() {
        this.dispose();
    }

    public void displayNotify(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    public int displayConfirm(String txt) {
        return JOptionPane.showConfirmDialog(this, txt, "Quit", JOptionPane.YES_NO_OPTION);
    }

    public void displayError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String getMoveCount() {
        return jLabelMoveCount.getText();
    }

    public void addActionButtonNumbers(ActionListener al) {
        buttonList.forEach((button) -> {
            button.addActionListener(al);
        });
    }

    public void removeAllActionOfButtonNumbers() {
        buttonList.forEach((button) -> {
            for (ActionListener e : button.getActionListeners()) {
                button.removeActionListener(e);
            }
        });
    }

    public List<JButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<JButton> buttonList) {
        this.buttonList = buttonList;
    }

    public void addActionjButtonNewGame(ActionListener al) {
        this.jButtonNewGame.addActionListener(al);
    }

    public void setMoveCount(int numberMove) {
        jLabelMoveCount.setText("Move count: " + numberMove);
    }

    public void setTimeElapse(int secon) {
        jLabelTimeElapse.setText("Elapse: " + secon + " sec");
    }

    public String getTimeElapse() {
        return jLabelTimeElapse.getText();
    }

    public JComboBox<String> getjComboboxSize() {
        return jComboboxSize;
    }

    public void setjComboboxSize(JComboBox<String> jComboboxSize) {
        this.jComboboxSize = jComboboxSize;
    }

    public JLabel getjLabelTimeElapse() {
        return jLabelTimeElapse;
    }

    public void setjLabelTimeElapse(JLabel jLabelTimeElapse) {
        this.jLabelTimeElapse = jLabelTimeElapse;
    }

    public JLabel getjLabelMoveCount() {
        return jLabelMoveCount;
    }

    public void setjLabelMoveCount(JLabel jLabelMoveCount) {
        this.jLabelMoveCount = jLabelMoveCount;
    }

    public JButton getjButtonNewGame() {
        return jButtonNewGame;
    }

    public void setjButtonNewGame(JButton jButtonNewGame) {
        this.jButtonNewGame = jButtonNewGame;
    }

    private JPanel gameMap = new JPanel();
    private List<JButton> buttonList = new ArrayList<>();
    private JComboBox<String> jComboboxSize = new JComboBox<>();
    private JLabel jLabelTimeElapse = new JLabel();
    private JLabel jLabelMoveCount = new JLabel();
    private JLabel jLabelSize = new JLabel();
    private JButton jButtonNewGame = new JButton();

}
