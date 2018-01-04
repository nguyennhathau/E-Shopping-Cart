/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import bussiness.Accounts;
import data.AccountDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Manager_accServlet", urlPatterns = {"/manager_accServlet"})
public class Manager_accServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("act");
        if (action.equals("insert")) {
            insertAcc(request, response);
        } else if (action.equals("update")) {
            updateAcc(request, response);
        }else if (action.equals("delete")){
            deleteAcc(request, response);
        }
    }
        
        protected void insertAcc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Accounts acc=new Accounts(username, password);
        String url = "/admin/manager_acc.jsp";
        String message = "";
        if (AccountDB.insertAcc(acc)) {
            message = "Thêm người dùng thành công.";
        } else {
            message = "Thêm thất bại";
            url="/admin/addAcc.jsp";
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void updateAcc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String username = request.getParameter("username");
        String password = request.getParameter("password");

        Accounts acc=new Accounts(username, password);
        String url = "/admin/manager_acc.jsp";
        String message = "";
        if (AccountDB.updateAcc(acc)) {
            message = "Cập nhập thành công.";
        } else {
            message = "cập nhập thất bại.";
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void deleteAcc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/admin/manager_acc.jsp";
        String message;
        String username = request.getParameter("username");
        if (AccountDB.deleteAcc(username)) {
            message = "Xóa thành công.";
        } else {
            message = "Xóa không thành công.";
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
