/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.quiz;

import controller.AuthBaseController;
import dal.QuestionDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Questions;
import model.Users;

/**
 *
 * @author Drol
 */
public class ListQuiz extends AuthBaseController {

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGet(req, resp);
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            Users user = (Users) session.getAttribute("USER");
            String pageIndexStr = req.getParameter("page");
            pageIndexStr = pageIndexStr == null ? "1" : pageIndexStr.trim();
            int page = 0;
            if (pageIndexStr.matches("[0-9]+")) {
                page = Integer.parseInt(pageIndexStr);
            }
            //get page size
            int pageSize = getPageSize();

            QuestionDAO questionDB = new QuestionDAO();
            int countByAuthor = questionDB.countQuestionsByAuthor(user.getUsername());
            int maxPage = countByAuthor / pageSize + (countByAuthor % pageSize > 0 ? 1 : 0);
            //make sure always have 1 page
            maxPage = maxPage == 0 ? 1 : maxPage;
            //check valide page index
            if (page <= 0 || page > maxPage) {
                req.setAttribute("message", "Something wrong.");
                req.getRequestDispatcher("view/error.jsp").forward(req, resp);
                return;
            }

            List<Questions> questions;
            if (countByAuthor <= pageSize) {
                questions = questionDB.getQuestionsByAuthor(user.getUsername());
            } else {
                questions = questionDB.getQuestionsByAuthorPagging(user.getUsername(), page, pageSize);
            }
            req.setAttribute("MAX_PAGE", maxPage);
            req.setAttribute("QUESTION_OF_USER", questions);
            req.setAttribute("NUMBER_OF_QUESTION_OF_USER", countByAuthor);
            req.setAttribute("PAGE_SIZE", pageSize);
            req.setAttribute("PAGE_INDEX", page);
            req.getRequestDispatcher("view/list-quiz.jsp").forward(req, resp);
        } catch (Exception ex) {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }

    private int getPageSize() {
        try {
            Context initCxt = new InitialContext();
            Context envirCxt = (Context) initCxt.lookup("java:comp/env");
            String pageSize = (String) envirCxt.lookup("pageSize");
            if (pageSize.matches("[1-9][0-9]*")) {
                return Integer.parseInt(pageSize);
            }
        } catch (NamingException ex) {
            Logger.getLogger(TakeQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 10;
    }
}
