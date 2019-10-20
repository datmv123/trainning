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
import javax.servlet.http.HttpSession;
import model.Questions;

/**
 *
 * @author Drol
 */
public class DoQuiz extends AuthBaseController {

    //milisecond time plus for latency
    private final int TIME_PLUS = 500;

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get action of user, next question or back to previous question
        String next = req.getParameter("next");
        String back = req.getParameter("back");
        String finish = req.getParameter("finish");
        String action;
        if (next != null) {
            action = "NEXT";
        } else if (back != null) {
            action = "BACK";
        } else {
            action = "";
        }
        //get user answer
        String questionId = req.getParameter("questionId");
        boolean optionAIsChecked = req.getParameter("optionA") != null;
        boolean optionBIsChecked = req.getParameter("optionB") != null;
        boolean optionCIsChecked = req.getParameter("optionC") != null;
        boolean optionDIsChecked = req.getParameter("optionD") != null;
        Questions q = new Questions();
        q.setId(Integer.parseInt(questionId));
        q.setOptionAIsAnswer(optionAIsChecked);
        q.setOptionBIsAnswer(optionBIsChecked);
        q.setOptionCIsAnswer(optionCIsChecked);
        q.setOptionDIsAnswer(optionDIsChecked);
        //check if still have time remain, false mean have time
        long expireTime = (long) req.getSession().getAttribute("EXPIRE_TIME_MILISECOND");
        if (expireTime + TIME_PLUS <= System.currentTimeMillis()) {
            finish = "submit";
        } else {
            //add or update new answer of user
            List<Questions> answer = (List<Questions>) req.getSession().getAttribute("USER_ANSWER");
            int index = answer.indexOf(q);
            if (index != -1) {
                answer.remove(index);
                answer.add(index, q);
                req.getSession().setAttribute("USER_ANSWER", answer);
            }
        }
        //true mean user want to submit, otherwise, take action with other questons
        if (finish != null) {
            req.getSession().setAttribute("QUIZ_ACTION", "submit-quiz");
            resp.sendRedirect(req.getContextPath() + "/submit-quiz");
        } else {
            req.getSession().setAttribute("ACTION", action);
            resp.sendRedirect(req.getContextPath() + "/do-quiz");
        }
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object currentQuestion = session.getAttribute("CURRENT_QUESTION_INDEX");
        //true mean use is doing quiz, otherwise, use want to take new one
        if (currentQuestion != null) {
            Object raw_action = session.getAttribute("ACTION");
            String action = (raw_action == null) ? "" : raw_action.toString();
            //action is "next" or "back", get next question or previous questions
            if (action.equalsIgnoreCase("NEXT")) {
                int indexCurrQuestion = Integer.parseInt(currentQuestion.toString());
                int indexNextQuestion = indexCurrQuestion + 1;
                //set index of question that will show to user
                session.setAttribute("CURRENT_QUESTION_INDEX", indexNextQuestion);
            } else if (action.equalsIgnoreCase("BACK")) {
                int indexCurrQuestion = Integer.parseInt(currentQuestion.toString());
                int indexPreviousQuestion = indexCurrQuestion - 1;
                //set index of question that will show to user
                session.setAttribute("CURRENT_QUESTION_INDEX", indexPreviousQuestion);
            } else {
                //do nothing
            }
            session.removeAttribute("ACTION");
        } else {
            session.setAttribute("CURRENT_QUESTION_INDEX", 0);
        }
        req.getRequestDispatcher("view/do-quiz.jsp").forward(req, resp);
    }

}
