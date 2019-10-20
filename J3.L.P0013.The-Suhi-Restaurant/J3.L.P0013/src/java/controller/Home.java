/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.IntroductionDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Introduction;
import model.Product;

/**
 *
 * @author Drol
 */
public class Home extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String pageStr = request.getParameter("page");
            pageStr = pageStr == null ? "1" : pageStr.trim();
            int page = -1;
            if (pageStr.matches("[0-9]+")) {
                page = Integer.parseInt(pageStr);
            }
            ProductDAO db = new ProductDAO();
            int pageSize = getPageSize_Home();
            int count = db.count();
            int maxPage = count / pageSize + (count % pageSize > 0 ? 1 : 0);
            maxPage = maxPage == 0 ? 1 : maxPage;
            //check valid page index
            if (page <= 0 || page > maxPage) {
                request.setAttribute("message", "Something wrong");
                request.getRequestDispatcher("view/message-page.jsp").forward(request, response);
                return;
            }
            List<Product> products = db.getProductPaging(page, pageSize);

            Introduction intro = new IntroductionDAO().getIntroduction();
            request.setAttribute("products", products);
            request.setAttribute("number", products.size());
            request.setAttribute("intro", intro);
            request.setAttribute("pageIndex", page);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("count", count);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("active", "home");
            request.getRequestDispatcher("view/home.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect(request.getContextPath() + "/error");
        }

    }

    private int getPageSize_Home() throws Exception {
        try {
            Context initCxt = new InitialContext();
            Context envirCxt = (Context) initCxt.lookup("java:comp/env");
            String homePageSize = (String) envirCxt.lookup("homePageSize");
            return Integer.parseInt(homePageSize);
        } catch (NamingException ex) {
            throw ex;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
