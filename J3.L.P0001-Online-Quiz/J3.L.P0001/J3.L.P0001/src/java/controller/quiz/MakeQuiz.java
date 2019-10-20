/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.quiz;

import controller.AuthBaseController;
import dal.QuestionDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Questions;
import model.Users;

/**
 *
 * @author Drol
 */
public class MakeQuiz extends AuthBaseController {

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get raw option and question
        String question = req.getParameter("question");
        question = (question == null) ? "" : question.trim();
        String optionA = req.getParameter("optionA");
        optionA = (optionA == null) ? "" : optionA.trim();
        String optionB = req.getParameter("optionB");
        optionB = (optionB == null) ? "" : optionB.trim();
        String optionC = req.getParameter("optionC");
        optionC = (optionC == null) ? "" : optionC.trim();
        String optionD = req.getParameter("optionD");
        optionD = (optionD == null) ? "" : optionD.trim();
        //get answer
        boolean optionAIsAnswer = req.getParameter("optionAIsAnswer") != null;
        boolean optionBIsAnswer = req.getParameter("optionBIsAnswer") != null;
        boolean optionCIsAnswer = req.getParameter("optionCIsAnswer") != null;
        boolean optionDIsAnswer = req.getParameter("optionDIsAnswer") != null;
        //make instace of question
        Questions model = new Questions();
        model.setOptionA(optionA);
        model.setOptionAIsAnswer(optionAIsAnswer);
        model.setOptionB(optionB);
        model.setOptionBIsAnswer(optionBIsAnswer);
        model.setOptionC(optionC);
        model.setOptionCIsAnswer(optionCIsAnswer);
        model.setOptionD(optionD);
        model.setOptionDIsAnswer(optionDIsAnswer);
        model.setQuestion(question);
        model.setCreationDate(new Date(System.currentTimeMillis()));
        Users user = (Users) req.getSession().getAttribute("USER");
        model.setAuthorName(user.getUsername());
        req.setAttribute("makeQ", model);
        //check empty quiz
        if (question.isEmpty() || optionA.isEmpty() || optionB.isEmpty() || optionC.isEmpty() || optionD.isEmpty()) {
            req.setAttribute("CREATE_QUESTION_OK", "Please fill all field.");
            req.getRequestDispatcher("view/make-quiz.jsp").forward(req, resp);
            return;
        }
        //check at least one answer
        if (optionAIsAnswer == false
                && optionBIsAnswer == false
                && optionCIsAnswer == false
                && optionDIsAnswer == false) {
            req.setAttribute("CREATE_QUESTION_OK", "Chose answer(s).");
            req.getRequestDispatcher("view/make-quiz.jsp").forward(req, resp);
            return;
        }

        //DB
        QuestionDAO questionDB = new QuestionDAO();
        try {
            boolean successInsert = questionDB.insert(model);
            if (successInsert == true) {
                req.setAttribute("makeQ", null);
                req.setAttribute("CREATE_QUESTION_OK", "Create successful.");
                req.getRequestDispatcher("view/make-quiz.jsp").forward(req, resp);
            } else {
                req.setAttribute("CREATE_QUESTION_OK", "Create fail.");
                req.getRequestDispatcher("view/make-quiz.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/make-quiz.jsp").forward(req, resp);
    }

}
