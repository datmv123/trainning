/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import controller.BaseController;
import dal.FeatureDAO;
import dal.RoleDAO;
import dal.UserDAO;
import dal.User_RoleDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Features;
import model.Roles;
import model.User_Role;
import model.Users;

/**
 *
 * @author Drol
 */
public class Register extends BaseController {

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //get roles
            RoleDAO roleDB = new RoleDAO();
            List<Roles> roles = roleDB.getAll();
            req.setAttribute("ROLES", roles);

            //get infomation
            String username = req.getParameter("username");
            username = username == null ? "" : username.trim();
            String password = req.getParameter("password");
            password = password == null ? "" : password.trim();
            String email = req.getParameter("email");
            email = email == null ? "" : email.trim();
            String roleString = req.getParameter("role");
            roleString = roleString == null ? "" : roleString.trim();
            int role = -1;
            //check if role is  positive integer type or not
            if (roleString.matches("[0-9]+")) {
                role = Integer.parseInt(roleString);
            }
            //check exist role
            if (roleDB.get(role) == null) {
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.setAttribute("REGISTER_OK", "User type is not valid.");
                req.getRequestDispatcher("view/register.jsp").forward(req, resp);
                return;
            }
            //check empty info
            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.setAttribute("role", role);
                req.setAttribute("REGISTER_OK", "Please fill all field.");
                req.getRequestDispatcher("view/register.jsp").forward(req, resp);
                return;
            }
            //check valid email.
            if (!email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+")) {
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.setAttribute("role", role);
                req.setAttribute("REGISTER_OK", "Please input valid email.");
                req.getRequestDispatcher("view/register.jsp").forward(req, resp);
                return;
            }

            Users oldUser = new UserDAO().get(username);
            //chekc if username already exist, true mean exist
            if (oldUser != null) {
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.setAttribute("role", role);
                req.setAttribute("REGISTER_OK", "Register fail.");
                req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            } else {
                //create new user
                Users newUser = new Users();
                newUser.setUsername(username);
                newUser.setPassword(password);
                newUser.setEmail(email);
                new UserDAO().insert(newUser);
                //set role for new user
                User_Role user_Role = new User_Role();
                user_Role.setUsername(username);
                user_Role.setRoleId(role);
                new User_RoleDAO().insert(user_Role);
                //set user login
                req.getSession().setAttribute("USER", newUser);
                List<Features> features = new FeatureDAO().getFeaturesByUser(newUser.getUsername());
                req.getSession().setAttribute("FEATURE_USER", features);
                resp.sendRedirect(req.getContextPath() + "/take-quiz");
            }
        } catch (Exception ex) {
            resp.sendRedirect(req.getContextPath() + "/error");
        }

    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("USER") != null) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }
        try {
            //get roles
            RoleDAO roleDB = new RoleDAO();
            List<Roles> roles = roleDB.getAll();
            req.setAttribute("ROLES", roles);
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
        } catch (Exception ex) {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }

}
