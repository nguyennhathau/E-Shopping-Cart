/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import bussiness.Orders;
import data.OrdersDB;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Manager_orderServlet", urlPatterns = {"/manager_orderServlet"})
public class Manager_orderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("act");

        if (action.equals("update")) {
            doUpdate(request, response);
        } else if (action.equals("delete")) {
            deleteOrder(request, response);
        } else {
            String url = "/admin/manager_order.jsp";
            List<Orders> order = OrdersDB.getOrders();
            request.setAttribute("order", order);
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
    }
    
    private void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/admin/manager_order.jsp";
        int orderID = Integer.parseInt(request.getParameter("id"));
        boolean status =true;
        String message;
        if (OrdersDB.updateOrder(orderID, status)) {
            message = "Update success.";
        } else {
            message = "khong update dc";
        }
         List<Orders> order = OrdersDB.getOrders();
            request.setAttribute("order", order);
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    
    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/admin/manager_order.jsp";
        int orderID = Integer.parseInt(request.getParameter("id"));
        String message;
        if (OrdersDB.deleteOrder(orderID)) {
            message = "xóa thành công.";
        } else {
            message = "khong xoa dc";
        }
         List<Orders> order = OrdersDB.getOrders();
            request.setAttribute("order", order);
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
