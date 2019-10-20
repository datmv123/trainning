/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BaseDAO;
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
import model.Product;

/**
 *
 * @author Drol
 */
public class AboutCake extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String raw_page = request.getParameter("page");
            raw_page = raw_page == null ? "1" : raw_page;
            int page = -1;
            if (raw_page.matches("[0-9]+")) {
                page = Integer.parseInt(raw_page);
            }

            ProductDAO db = new ProductDAO();
            int pageSize = getPageSize();
            int count = db.count();
            int maxPage = count / pageSize + (count % pageSize > 0 ? 1 : 0);
            maxPage = maxPage == 0 ? 1 : maxPage;
            if (page <= 0 || page > maxPage) {
                request.getRequestDispatcher("view/error.jsp").forward(request, response);
                return;
            }
            List<Product> products = null;
            if (count <= pageSize) {
                products = db.getProductPaging(1, pageSize);
            } else {
                products = db.getProductPaging(page, pageSize);
            }
            request.setAttribute("products", products);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("pageIndex", page);
            request.setAttribute("count", count);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("active", "about-cake");
            request.getRequestDispatcher("view/about-cake.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AboutCake.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect(request.getContextPath() + "/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private int getPageSize() throws NamingException {
        try {
            Context initCxt = new InitialContext();
            Context envirCxt = (Context) initCxt.lookup("java:comp/env");
            String pageStr = (String) envirCxt.lookup("pageSize");
            return Integer.parseInt(pageStr);
        } catch (NamingException ex) {
            throw ex;
        }
    }
}
