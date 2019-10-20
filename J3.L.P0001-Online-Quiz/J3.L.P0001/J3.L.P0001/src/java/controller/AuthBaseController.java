/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Features;

/**
 *
 * @author Drol
 */
public abstract class AuthBaseController extends BaseController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (login(req)) {
            if (hasPermission(req)) {
                super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
            } else {
                req.setAttribute("message", "Permission denied.");
                req.getRequestDispatcher("view/message-page.jsp").forward(req, resp);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (login(req)) {
            if (hasPermission(req)) {
                super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
            } else {
                req.setAttribute("message", "Permission denied.");
                req.getRequestDispatcher("view/message-page.jsp").forward(req, resp);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }

    private boolean login(HttpServletRequest req) {
        return req.getSession().getAttribute("USER") != null;
    }

    private boolean hasPermission(HttpServletRequest req) {
        List<Features> feature = (List<Features>) req.getSession().getAttribute("FEATURE_USER");

        String url = req.getRequestURI();
        for (Features f : feature) {
            String fullPath = req.getContextPath() + f.getURL();
            if (fullPath.equals(url)) {
                return true;
            }
        }
        return false;
    }
}
