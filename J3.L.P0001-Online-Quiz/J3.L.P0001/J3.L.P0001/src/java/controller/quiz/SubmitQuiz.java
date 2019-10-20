/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.quiz;

import controller.AuthBaseController;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Questions;

/**
 *
 * @author Drol
 */
public class SubmitQuiz extends AuthBaseController {

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //remove old status of last doing quiz
        req.getSession().removeAttribute("QUIZ_ACTION");
        req.getSession().removeAttribute("FINAL_RESULT");
        req.getSession().removeAttribute("QUESTIONS");
        req.getSession().removeAttribute("USER_ANSWER");
        req.getSession().removeAttribute("CURRENT_QUESTION_INDEX");
        req.getSession().removeAttribute("NUMBER_QUESTION");

        resp.sendRedirect(req.getContextPath() + "/take-quiz");
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Questions> answers = (List<Questions>) req.getSession().getAttribute("USER_ANSWER");
        List<Questions> questions = (List<Questions>) req.getSession().getAttribute("QUESTIONS");
        int numberQuestions = questions.size();
        //count number correct answer
        int count = 0;
        for (Questions t : questions) {
            for (Questions b : answers) {
                //chek user answer
                if (b.getId() == t.getId()) {
                    if (b.isOptionAIsAnswer() == t.isOptionAIsAnswer()
                            && b.isOptionBIsAnswer() == t.isOptionBIsAnswer()
                            && b.isOptionCIsAnswer() == t.isOptionCIsAnswer()
                            && b.isOptionDIsAnswer() == t.isOptionDIsAnswer()) {
                        count++;
                    }
                }
            }
        }
        double result = (double) count * 10 / numberQuestions;
        double finalScore = (double) Math.round(result * 10) / 10;
        req.getSession().setAttribute("FINAL_RESULT", finalScore);
        req.getRequestDispatcher("view/submit-quiz.jsp").forward(req, resp);
    }

}
