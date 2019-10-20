/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Drol
 */
public class ContinueDoQuiz implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Object quizAcitonRaw = req.getSession().getAttribute("QUIZ_ACTION");
        String quizAciton = (quizAcitonRaw == null) ? "take-quiz" : quizAcitonRaw.toString();
        String URI = req.getRequestURI();
        String path = req.getContextPath() + "/" + quizAciton;
        //check if user is doing what action (take, do, submit quiz) then keep doing that action
        if (URI.equals(path)) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect(path);
        }
    }

    @Override
    public void destroy() {

    }

}
