/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.DecodeManage;
import business.EncodeManage;
import view.DecodeView;
import view.EncodeView;
import view.MainView;

/**
 *
 * @author Drol
 */
public class MainController {

    private MainView view;

    public MainController(MainView view) {
        this.view = view;
    }

    public void initController() {
        view.addActionListenerDecodeProgram(e -> startDecodeProgram());
        view.addActionListenerEncodeProgram(e -> startEncodeProgram());
    }

    private void startEncodeProgram() {
        EncodeView view = new EncodeView();
        EncodeManage model = new EncodeManage();
        EncodeController controller = new EncodeController(view, model);
        controller.initController();
    }

    private void startDecodeProgram() {
        DecodeView view = new DecodeView();
        DecodeManage model = new DecodeManage();
        DecodeController controller = new DecodeController(view, model);
        controller.initController();
    }
}
