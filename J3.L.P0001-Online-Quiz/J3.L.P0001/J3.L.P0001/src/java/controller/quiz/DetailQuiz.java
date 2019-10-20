/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.quiz;

import controller.AuthBaseController;
import dal.QuestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Questions;
import model.Users;

/**
 *
 * @author Drol
 */
public class DetailQuiz extends AuthBaseController {

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGet(req, resp);
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String raw_id = req.getParameter("id");
            raw_id = raw_id == null ? "" : raw_id.trim();
            Users user = (Users) req.getSession().getAttribute("USER");
            int id = -1;
            if (raw_id.matches("[0-9]+")) {
                id = Integer.parseInt(raw_id);
            }
            QuestionDAO questionDB = new QuestionDAO();
            Questions q = questionDB.get(id);
            //check if question is exist or not, q = null mean not exist
            if (q == null) {
                req.setAttribute("message", "Something wrong.");
                req.getRequestDispatcher("view/message-page.jsp").forward(req, resp);
            } else {
                if (q.getAuthorName().equals(user.getUsername())) {
                    req.setAttribute("DETAIL_QUESTION", q);
                    req.getRequestDispatcher("view/detail-quiz.jsp").forward(req, resp);
                } else {
                    req.setAttribute("message", "Permission denied.");
                    req.getRequestDispatcher("view/message-page.jsp").forward(req, resp);
                }
            }
        } catch (Exception ex) {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }

}
