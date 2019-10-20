/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import business.CalcManage;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.Calculator;

/**
 *
 * @author Drol
 */
public class CalcController {

    private Calculator view;
    private CalcManage model;

    public CalcController(Calculator view, CalcManage model) {
        this.view = view;
        this.model = model;
        initView();
    }

    /**
     * Set up the default view
     */
    private void initView() {
        //set the default showing result to Zero
        view.setValueToScreen(0 + "");
    }

    /**
     * Set up action listener for all buttons
     */
    public void initController() {
        //set action listener for number from 0 to 9
        view.addActionForButtonNumber(new ActionListenerOfButtonNumber());
        //button dot
        view.addActionForButtonDot(e -> actionOfButtonDot());
        //set action listener for buttons of memory operator
        view.addActionForMemoryClear((e) -> clearMemory());
        view.addActionForMemoryRecall((e) -> recallMemory());
        view.addActionForMemoryAdd((e) -> actionOfButtonMemoryAdd());
        view.addActionForMemorySubtract((e) -> actionOfButtonMemorySubtract());
        // buttons of normal calculation operator
        view.addActionForOpposition((e) -> actionOfButtonOpposition());
        view.addActionForInversion((e) -> actionOfButtonInversion());
        view.addActionForRoot((e) -> actionOfButtonRoot());
        view.addActionForNormalOperator(new ActionListenerOfNormalOperators());
        view.addActionForPercent((e) -> actionOfButtonPercent());
        //button get result
        view.addActionForSubmit((e) -> actionOfButtonGetResult());
    }

    /**
     * Check if screen of calculator is showing error or not
     *
     * @return true if it is and false if not
     */
    private boolean isScreenShowingError() {
        try {
            String valueInScreen = view.getValueInScreen();
            //if screen showing erro then exception will throw.
            Double.parseDouble(valueInScreen);
        } catch (NumberFormatException ex) {
            System.err.println("Log: " + ex.getMessage());
            return true;
        }
        return false;
    }

    /**
     * save number show in screen calculator.
     */
    private void saveNumber() {
        //if screen is showing error then do nothing
        if (isScreenShowingError() == false) {
            double valueInScreen = Double.parseDouble(view.getValueInScreen());
            model.setNumber(valueInScreen);
        }
    }

    /**
     * Display value to screen of calculator
     *
     * @param value value in double
     */
    private void displayValue(double value) {
        boolean valueIsInteger = (value - (int) value) == 0;
        //check if value is integer or double
        if (valueIsInteger) {
            view.setValueToScreen((int) value + "");
        } else {
            view.setValueToScreen(value + "");
        }
    }

    /**
     * Class for action of buttons number
     */
    class ActionListenerOfButtonNumber implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String valueInScreen = view.getValueInScreen();
            //check if value in screen is 0 then replace it by number else insert number to the right of it
            //such as: 0 -> 1; 1 -> 123
            if (valueInScreen.equals("0") || model.isNewInput()) {
                view.setValueToScreen(button.getText());
            } else {
                view.setValueToScreen(valueInScreen + button.getText());
            }
            saveNumber();
            model.setNewInput(false);
        }
    }

    /**
     * Clear memory of calculator
     */
    private void clearMemory() {
        model.clearMemory();
    }

    /**
     * display result of memory on screen
     */
    private void recallMemory() {
        displayValue(model.getMemory());
        model.setNewInput(true);
        saveNumber();
    }

    /**
     * insert dot "." character
     */
    private void actionOfButtonDot() {
        if (model.isNewInput()) {
            view.setValueToScreen(0 + ".");
            model.setNewInput(false);
        } else {
            String valueInScreen = view.getValueInScreen();
            boolean alreadyExistDot = valueInScreen.contains(".");
            //check if value in screen already contains dot or not
            if (alreadyExistDot) {
                //do nothing
            } else {
                view.setValueToScreen(valueInScreen + ".");
            }
        }
        saveNumber();
    }

    /**
     * action for button memory add
     */
    private void actionOfButtonMemoryAdd() {
        //check if screen is showing error or not
        if (isScreenShowingError() == false) {
            double valueInScreen = Double.parseDouble(view.getValueInScreen());
            model.addToMemory(valueInScreen);
        }
        model.setNewInput(true);
    }

    /**
     * action for button memory subtract
     */
    private void actionOfButtonMemorySubtract() {
        //check if screen is showing error or not
        if (isScreenShowingError() == false) {
            double valueInScreen = Double.parseDouble(view.getValueInScreen());
            model.subtractFromMemory(valueInScreen);
        }
        model.setNewInput(true);
    }

    /**
     * opposite the showing value in screen
     */
    private void actionOfButtonOpposition() {
        //check if screen is showing error or not
        if (isScreenShowingError() == false) {
            double valueInScreen = Double.parseDouble(view.getValueInScreen());
            //if showing value is 0 then do nothing
            if (valueInScreen == 0) {
                return;
            }
            displayValue(model.opposite(valueInScreen));
            saveNumber();
        }
    }

    /**
     * inverse the instant showing result
     */
    private void actionOfButtonInversion() {
        //check if screen is showing error or not
        if (isScreenShowingError() == false) {
            double valueInScreen = Double.parseDouble(view.getValueInScreen());
            //check if already calculating or not. if true then keep calculate, if not then save value in screen as result
            if (model.isCalculating()) {
                executionEquation();
            } else {
                model.setResult(valueInScreen);
            }
        }
        //check if user can inverse or not.
        if (model.getResult() == 0) {
            view.setValueToScreen("Cannot inverse");
        } else {
            model.inverse();
            displayValue(model.getResult());
        }
        model.setNewInput(true);
        model.setOperator("");
        model.setCalculating(false);
    }

    /**
     * root the showing value in screen
     */
    private void actionOfButtonRoot() {
        //check if screen is showing error or not
        if (isScreenShowingError() == false) {
            double valueOnScreen = Double.parseDouble(view.getValueInScreen());
            //check if already calculating or not. if true then keep calculate, if not then save value in screen as result
            if (model.isCalculating()) {
                executionEquation();
            } else {
                model.setResult(valueOnScreen);
            }
        }
        //check if user can root or not
        if (model.getResult() < 0) {
            view.setValueToScreen("Error");
        } else {
            model.root();
            displayValue(model.getResult());
        }
        model.setNewInput(true);
        model.setCalculating(false);
        model.setOperator("");
    }

    /**
     * Action for button percent
     */
    private void actionOfButtonPercent() {
        //check if screen is showing error or not
        if (isScreenShowingError() == false) {
            double valueOnScreen = Double.parseDouble(view.getValueInScreen());
            //check if already calculating or not. if true then keep calculate, if not then save value in screen as result
            if (model.isCalculating()) {
                executionEquation();
            } else {
                model.setResult(valueOnScreen);
            }
        }
        model.percent();
        displayValue(model.getResult());
        model.setNewInput(true);
        model.setCalculating(false);
        model.setOperator("");
    }

    /**
     * Action for button get result.
     */
    private void actionOfButtonGetResult() {
        //check if screen is showing error or not.
        if (isScreenShowingError() == false) {
            double valueInScreen = Double.parseDouble(view.getValueInScreen());
            //check if already calculating or not. if true then keep calculate, if not then just show value in screen after format instead
            if (model.isCalculating()) {
                executionEquation();
            } else {
                displayValue(valueInScreen);
            }
            //check if screen is showing error or not.
            //this check execute after do executionEqution() above
            if (isScreenShowingError() == false) {
                model.setCalculating(false);
                model.setOperator("");
            }
        }
        model.setNewInput(true);
    }

    /**
     * Class for action of normal operator
     */
    class ActionListenerOfNormalOperators implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            //check if screen is showing error or not.
            if (isScreenShowingError() == false) {
                double valueInScreen = Double.parseDouble(view.getValueInScreen());
                //check if already calculating or not. if true then keep calculate, if not then save value in screen as result
                if (model.isCalculating()) {
                    executionEquation();
                } else {
                    model.setResult(valueInScreen);
                }
            }
            //this set up to help user can change their operator without execute equation
            //such as: 1++ -> result: 1
            if (button.getText().equals("+") || button.getText().equals("-")) {
                model.setNumber(0);
            } else {
                model.setNumber(1);
            }
            model.setCalculating(true);
            model.setNewInput(true);
            model.setOperator(button.getText());
        }
    }

    /**
     * execution equation that first number , second number and operation
     * already had had.(normal operation: +,-,*,/)
     */
    private void executionEquation() {
        switch (model.getOperator()) {
            case "+": {
                model.add();
                displayValue(model.getResult());
                break;
            }
            case "-": {
                model.subtract();
                displayValue(model.getResult());
                break;
            }
            case "*": {
                model.multiply();
                displayValue(model.getResult());
                break;
            }
            case "/": {
                if (model.getNumber() == 0) {
                    view.setValueToScreen("Cannot divide by 0");
                } else {
                    model.divide();
                    displayValue(model.getResult());
                }
                break;
            }
        }
    }
}
