/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import bussiness.Categories;
import data.CategoryDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Manager_CategoryServlet", urlPatterns = {"/manager_CategoryServlet"})
public class Manager_CategoryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("act");

        if (action.equals("insert")) {
            doInsert(request, response);
        } else if (action.equals("update")) {
            doUpdate(request, response);
        } else if (action.equals("delete")) {
            doDeleteCategory(request, response);
        } else {
            String url = "/admin/manager_category.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        
    }

    private void doInsert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/admin/manager_category.jsp";
        String categoryName = request.getParameter("categoryName");
        int kindID = Integer.parseInt(request.getParameter("kindID"));
        String message;
        if (categoryName.equals("")) {
            message = "field category Name empty.";
            request.setAttribute("message", message);
        }
        Categories c = new Categories(0, categoryName, kindID);
        if (CategoryDB.insertCategory(c)) {
            message = "Insert success.";
        } else {
            message = "Insert fail.";
            url="/admin/addcategory.jsp";
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "manager_category.jsp";
        String categoryName = request.getParameter("categoryName");
        int categoryID = Integer.parseInt(request.getParameter("id"));
        int kindID = Integer.parseInt(request.getParameter("kindID"));
        Categories c = new Categories(categoryID, categoryName, kindID);
        String message;
        if (CategoryDB.updateCategory(c)) {
            message = "Update success.";
        } else {
            message = "khong update dc";
            url = "/admin/update_category.jsp";
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void doDeleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/admin/manager_category.jsp";
        String message;
        int categoryID = Integer.parseInt(request.getParameter("id"));
        if (CategoryDB.deleteCategory(categoryID)) {
            message = "Delete success.";
        } else {
            message = "khong xoa dc";
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
