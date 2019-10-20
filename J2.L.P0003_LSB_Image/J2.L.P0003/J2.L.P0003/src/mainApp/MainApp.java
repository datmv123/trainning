/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainApp;

import controller.MainController;
import view.MainView;

/**
 *
 * @author Drol
 */
public class MainApp {

    public static void main(String[] args) {
        MainView view = new MainView();
        MainController controller = new MainController(view);
        controller.initController();
    }
}
