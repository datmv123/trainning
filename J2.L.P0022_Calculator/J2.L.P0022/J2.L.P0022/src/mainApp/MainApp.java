/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainApp;

import controller.CalcController;
import business.CalcManage;
import ui.Calculator;

/**
 *
 * @author Drol
 */
public class MainApp {

    public static void main(String[] args) {
        CalcManage model = new CalcManage();
        Calculator view = new Calculator();
        CalcController controller = new CalcController(view, model);
        controller.initController();
    }
}
