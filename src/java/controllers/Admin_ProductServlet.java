package controllers;

import bussiness.Products;
import data.ProductDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Admin_ProductServlet", urlPatterns = {"/admin_ProductServlet"})
public class Admin_ProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("act");
        if (action.equals("insert")) {
            doSave(request, response);
        } else if (action.equals("update")) {
            doUpdateProduct(request, response);
        }else if (action.equals("delete")){
            doDeleteProduct(request, response);
        }else{
            
        }
    }

    protected void doSave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        String productName = request.getParameter("productName");
        int price = Integer.parseInt(request.getParameter("price"));
        String urlImage = request.getParameter("urlImage");
        String timeUpdateString = request.getParameter("timeUpdate");
        LocalDate  timeUpdate = LocalDate.parse(timeUpdateString,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String description = request.getParameter("description");

        Products p = new Products(0, categoryID, productName, price, urlImage, timeUpdate, description);
        String url = "/admin/manager_products.jsp";
        String message = "";
        if (ProductDB.insertProduct(p)) {
            message = "Add product success";
        } else {
            message = "add product fail";
            url="/admin/addProduct.jsp";
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void doUpdateProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        String productName = request.getParameter("productName");
        int price = Integer.parseInt(request.getParameter("price"));
        String urlImage = request.getParameter("urlImage");
        String timeUpdateString = request.getParameter("timeUpdate");
        LocalDate timeUpdate = LocalDate.parse(timeUpdateString);
        String description = request.getParameter("description");

        Products p = new Products(0, categoryID, productName, price, urlImage, timeUpdate, description);
        String url = "/admin/manager_products.jsp";
        String message = "";
        if (ProductDB.updateProduct(p)) {
            message = "update success.";
        } else {
            message = "update fail.";
            url="/admin/update_product.jsp";
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void doDeleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/admin/manager_products.jsp";
        String message;
        int productID = Integer.parseInt(request.getParameter("productID"));
        if (ProductDB.deleteProduct(productID)) {
            message = "Delete success.";
        } else {
            message = "Don't delete";
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
