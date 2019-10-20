package solution2.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class PuzzleView_AnotherSolution extends JFrame {

    //size of button
    private final int BUTTON_HEIGHT = 55;
    private final int BUTTON_WIDTH = 55;

    private final int SPACE_BETWEEN_BUTTON = 15;
    //space between panel game and main frame
    private final int HORIZON_GAP = 30;
    private final int VERTICAL_GAP = 10;
    //size of other components
    private final int COMPONENT_HEIGHT = 30;
    private final int COMPONENT_WIDTH = 50;

    public PuzzleView_AnotherSolution() {
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
        comboboxSize.setModel(cbModel);
        labelTimeElapse.setText("Elapsed: 0 sec");
        labelMoveCount.setText("Move count: 0");
        buttonNewGame.setText("New game");
        labelSize.setText("Size:");

        this.add(gameMap);
        this.add(comboboxSize);
        this.add(labelTimeElapse);
        this.add(labelMoveCount);
        this.add(labelSize);
        this.add(buttonNewGame);
    }

    public void createGameMap(int widthSize) {
        setGameMapSize(widthSize);
        gameMap.removeAll();
        buttons = new JButton[widthSize][widthSize];
        List<String> textOfButton = new ArrayList<>();
        //create value of buttons
        for (int i = 0; i < widthSize * widthSize - 1; i++) {
            String text = "" + (i + 1);
            textOfButton.add(text);
        }
        //empty value
        textOfButton.add("");
        //check that game can have solution or not
        do {
            //shuffle value of all buttons
            Collections.shuffle(textOfButton);
        } while (isGameSolvable(textOfButton) == false);
        int index = 0;
        //add text to all button
        for (int i = 0; i < widthSize; i++) {
            for (int j = 0; j < widthSize; j++) {
                String text = textOfButton.get(index++);
                JButton button = new JButton();
                button.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
                button.setText(text);
                buttons[j][i] = button;
            }
        }
        //add button to panel. this panel will show button in form 3x3, 4x4,....
        for (int i = 0; i < widthSize; i++) {
            for (int j = 0; j < widthSize; j++) {
                gameMap.add(buttons[j][i]);
            }
        }
        //set size and position of all components
        gameMap.setLayout(new GridLayout(widthSize, widthSize, SPACE_BETWEEN_BUTTON, SPACE_BETWEEN_BUTTON));
        int panel_width = widthSize * BUTTON_WIDTH + (widthSize - 1) * SPACE_BETWEEN_BUTTON;
        int panel_height = widthSize * BUTTON_HEIGHT + (widthSize - 1) * SPACE_BETWEEN_BUTTON;

        int frame_width = panel_width + 2 * HORIZON_GAP + 5;
        int frame_height = panel_height + 2 * VERTICAL_GAP + 5 * COMPONENT_HEIGHT + 60;
        this.setSize(frame_width, frame_height);

        gameMap.setBounds(HORIZON_GAP, VERTICAL_GAP, panel_width, panel_height);
        labelMoveCount.setBounds(HORIZON_GAP, 2 * VERTICAL_GAP + panel_height, panel_width, COMPONENT_HEIGHT);
        labelTimeElapse.setBounds(HORIZON_GAP, 2 * VERTICAL_GAP + panel_height + COMPONENT_HEIGHT, panel_width, COMPONENT_HEIGHT);
        labelSize.setBounds(HORIZON_GAP, 2 * VERTICAL_GAP + panel_height + 2 * COMPONENT_HEIGHT, 40, COMPONENT_HEIGHT);
        comboboxSize.setBounds(HORIZON_GAP + 40, 2 * VERTICAL_GAP + panel_height + 2 * COMPONENT_HEIGHT, 50, COMPONENT_HEIGHT);
        buttonNewGame.setBounds(HORIZON_GAP, 2 * VERTICAL_GAP + panel_height + 3 * COMPONENT_HEIGHT + 20, 100, COMPONENT_HEIGHT);
    }

    /**
     * Check that game can have solution or not
     *
     * @param textOfButton List all value of game
     * @return true if game have solution and false if not
     */
    private boolean isGameSolvable(List<String> textOfButton) {
        int size = textOfButton.size();
        //assume button A have index b
        //count is number of button have value smaller than A but have index bigger than A
        int count = 0;
        int isGameCanSolve = 0;
        //loop all button
        for (int i = 0; i < size - 1; i++) {
            //if current button is empty then do nothing
            if (textOfButton.get(i).equals("")) {
            } else {
                //integer value of current button
                int a = Integer.parseInt(textOfButton.get(i));
                //loop all button have index bigger than current button
                for (int j = i + 1; j < size; j++) {
                    if (textOfButton.get(j).equals("")) {
                    } else {
                        int b = Integer.parseInt(textOfButton.get(j));
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
            for (int i = 0; i < textOfButton.size(); i++) {
                String buttonText = textOfButton.get(i);
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
        return comboboxSize.getSelectedItem().toString();
    }

    public void setGameMapSize(int widthSize) {
        comboboxSize.setSelectedItem(widthSize + "x" + widthSize);
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
        return labelMoveCount.getText();
    }

    public void addActionButtonNumbers(ActionListener al) {
        int widthSize = buttons.length;
        for (int i = 0; i < widthSize; i++) {
            for (int j = 0; j < widthSize; j++) {
                buttons[i][j].addActionListener(al);
            }
        }
    }

    public void removeAllActionOfButtonNumbers() {
        int widthSize = buttons.length;
        for (int i = 0; i < widthSize; i++) {
            for (int j = 0; j < widthSize; j++) {
                JButton button = buttons[i][j];
                for (ActionListener e : button.getActionListeners()) {
                    button.removeActionListener(e);
                }
            }
        }
    }

    public JPanel getGameMap() {
        return gameMap;
    }

    public void setGameMap(JPanel gameMap) {
        this.gameMap = gameMap;
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    public JLabel getLabelSize() {
        return labelSize;
    }

    public void setLabelSize(JLabel labelSize) {
        this.labelSize = labelSize;
    }

    public void addActionjButtonNewGame(ActionListener al) {
        this.buttonNewGame.addActionListener(al);
    }

    public void setMoveCount(int numberMove) {
        labelMoveCount.setText("Move count: " + numberMove);
    }

    public void setTimeElapse(int secon) {
        labelTimeElapse.setText("Elapse: " + secon + " sec");
    }

    public String getTimeElapse() {
        return labelTimeElapse.getText();
    }

    public JComboBox<String> getComboboxSize() {
        return comboboxSize;
    }

    public void setComboboxSize(JComboBox<String> comboboxSize) {
        this.comboboxSize = comboboxSize;
    }

    public JLabel getLabelTimeElapse() {
        return labelTimeElapse;
    }

    public void setLabelTimeElapse(JLabel labelTimeElapse) {
        this.labelTimeElapse = labelTimeElapse;
    }

    public JLabel getLabelMoveCount() {
        return labelMoveCount;
    }

    public void setLabelMoveCount(JLabel labelMoveCount) {
        this.labelMoveCount = labelMoveCount;
    }

    public JButton getButtonNewGame() {
        return buttonNewGame;
    }

    public void setButtonNewGame(JButton buttonNewGame) {
        this.buttonNewGame = buttonNewGame;
    }

    private JPanel gameMap = new JPanel();
    private JButton buttons[][];
    private JComboBox<String> comboboxSize = new JComboBox<>();
    private JLabel labelTimeElapse = new JLabel();
    private JLabel labelMoveCount = new JLabel();
    private JLabel labelSize = new JLabel();
    private JButton buttonNewGame = new JButton();

}
