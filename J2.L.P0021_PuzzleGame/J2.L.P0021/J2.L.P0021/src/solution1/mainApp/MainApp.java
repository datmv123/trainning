/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution1.mainApp;

import solution1.controller.PuzzleController;
import solution1.view.PuzzleView;

/**
 *
 * @author Drol
 */
public class MainApp {

    public static void main(String[] args) {
        PuzzleView view = new PuzzleView();
        view.createGameMap(3);
        PuzzleController controller = new PuzzleController(view);
        controller.initController();

    }
}
