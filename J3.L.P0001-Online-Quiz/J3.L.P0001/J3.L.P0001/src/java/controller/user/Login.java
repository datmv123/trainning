/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.BaseController;
import dal.FeatureDAO;
import dal.UserDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Features;
import model.Users;

/**
 *
 * @author Drol
 */
public class Login extends BaseController {

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            username = username == null ? "" : username;
            String password = req.getParameter("password");;
            password = password == null ? "" : password;

            UserDAO userDB = new UserDAO();
            HttpSession session = req.getSession();

            Users model = userDB.login(username, password);
            if (model != null) {
                session.setAttribute("USER", model);
                List<Features> features = new FeatureDAO().getFeaturesByUser(username);
                session.setAttribute("FEATURE_USER", features);
                resp.sendRedirect(req.getContextPath() + "/home");
            } else {
                req.setAttribute("LOGIN_OK", "Incorrect username or password.");
                req.setAttribute("username", username);
                req.getRequestDispatcher("view/home.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/home.jsp").forward(req, resp);
    }

}
