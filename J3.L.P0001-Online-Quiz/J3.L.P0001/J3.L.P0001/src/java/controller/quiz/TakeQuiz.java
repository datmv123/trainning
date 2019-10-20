/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.quiz;

import controller.AuthBaseController;
import dal.QuestionDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Questions;

/**
 *
 * @author Drol
 */
public class TakeQuiz extends AuthBaseController {

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            //get number of question that user need
            String numQuizString = req.getParameter("num-quiz");
            numQuizString = numQuizString == null ? "" : numQuizString.trim();
            //validate
            int numberQuiz = -1;
            if (numQuizString.matches("[0-9]+")) {
                numberQuiz = Integer.parseInt(numQuizString);
            }
            req.setAttribute("numQ", numQuizString);
            QuestionDAO questionDB = new QuestionDAO();
            //get number of questions
            int countAllQuestions = questionDB.countAll();
            //check if can get questions that user need, if not send message back to user
            if (numberQuiz <= 0) {
                req.setAttribute("GET_QUIZ_MESSAGE", "Please input positive number.");
                req.getRequestDispatcher("view/take-quiz.jsp").forward(req, resp);
            } else if (numberQuiz > countAllQuestions) {
                req.setAttribute("GET_QUIZ_MESSAGE", "We just have " + countAllQuestions + " questions available.");
                req.getRequestDispatcher("view/take-quiz.jsp").forward(req, resp);
            } else {
                List<Questions> questions = questionDB.getRandomQuestionsByQuantity(numberQuiz);
                session.setAttribute("QUESTIONS", questions);
                List<Questions> userAnswer = setUpUserAnswers(questions);
                session.setAttribute("USER_ANSWER", userAnswer);
                session.setAttribute("NUMBER_QUESTION", numberQuiz);
                session.setAttribute("QUIZ_ACTION", "do-quiz");
                long expireTime = numberQuiz * getDefaultSecondPerQuestion() * 1000 + System.currentTimeMillis();
                session.setAttribute("EXPIRE_TIME_MILISECOND", expireTime);

                resp.sendRedirect(req.getContextPath() + "/do-quiz");
            }
        } catch (Exception ex) {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/take-quiz.jsp").forward(req, resp);
    }

    //get clone list question, return a question same size but each element just have id, don't have other value
    private List<Questions> setUpUserAnswers(List<Questions> questions) {
        List<Questions> result = new ArrayList<>();
        for (Questions q : questions) {
            Questions cloneQuestion = new Questions();
            cloneQuestion.setId(q.getId());
            result.add(cloneQuestion);
        }
        return result;
    }

    private long getDefaultSecondPerQuestion() throws Exception {
        try {
            Context initCxt = new InitialContext();
            Context envirCxt = (Context) initCxt.lookup("java:comp/env");
            String secondPerQuestion = (String) envirCxt.lookup("secondPerQuestion");
            if (secondPerQuestion.matches("[1-9][0-9]*")) {
                return Integer.parseInt(secondPerQuestion);
            }
            return 0;
        } catch (NamingException ex) {
            throw ex;
        }
    }

}
