package solution2.mainApp;

import solution2.controller.PuzzleController_AnotherSolution;
import solution2.view.PuzzleView_AnotherSolution;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Drol
 */
public class MainApp2 {

    public static void main(String[] args) {
        PuzzleView_AnotherSolution view = new PuzzleView_AnotherSolution();
        view.createGameMap(3);
        PuzzleController_AnotherSolution controller = new PuzzleController_AnotherSolution(view);
        controller.initController();
    }
}
