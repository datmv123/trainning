/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Drol
 */
public class CalcManage {

    //memory
    private double memory = 0;

    //final result
    private double result = 0;
    //number to do equation with result
    private double number = 0;
    //operator
    private String operator = "";

    //true mean user can input new number. false mean they can append old number with number such as: 1 -> 123
    private boolean newInput = true;
    //keep state calculate. true mean already calculate.
    //false mean this is new calculate.
    private boolean calculating = false;

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isNewInput() {
        return newInput;
    }

    public void setNewInput(boolean newInput) {
        this.newInput = newInput;
    }

    public boolean isCalculating() {
        return calculating;
    }

    public void setCalculating(boolean calculating) {
        this.calculating = calculating;
    }

    public double getMemory() {
        return memory;
    }

    public void clearMemory() {
        memory = 0;
    }

    public void setResult(double number) {
        this.result = number;
    }

    public double getResult() {
        return result;
    }

    public void addToMemory(double number) {
        memory += number;
    }

    public void subtractFromMemory(double number) {
        memory -= number;
    }

    public double opposite(double number) {
        return -number;
    }

    public void inverse() {
        result = 1 / result;
    }

    public void root() {
        result = Math.sqrt(result);
    }

    public void percent() {
        result = result / 100;
    }

    public void add() {
        result += number;
    }

    public void subtract() {
        result -= number;
    }

    public void multiply() {
        result *= number;
    }

    public void divide() {
        result /= number;
    }
}
