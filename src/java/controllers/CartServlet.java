package controllers;

import bussiness.Cart;
import bussiness.LineItem;
import bussiness.Orders;
import bussiness.Products;
import data.OrdersDB;
import data.ProductDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.jni.SSLContext;

@WebServlet(name = "CartServlet", urlPatterns = {"/cartServlet"})
public class CartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";
        }
        if (action.equals("cart") || action.equals("update") || action.equals("remove")) {
            doAddToCart(request, response);
        } else if (action.equals("shop")) {
            doShop(request, response);
        } else if (action.equals("checkout")) {
            doCheckout(request, response);
        }

    }

    private void doAddToCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int productID = Integer.parseInt(request.getParameter("productID"));
        String quantityString = request.getParameter("quantity");

        int quantity = 0;
        try {
            quantity = Integer.parseInt(quantityString);

        } catch (NumberFormatException e) {
            quantity = 1;
        }
        Products p = ProductDB.getProduct(productID);
        LineItem item = new LineItem(0, p, quantity);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        if (action == null) {
            cart.addItem(item);
        } else if (quantity == 0 || action.equals("remove")) {
            cart.removeItem(item);
        } else {
            cart.update(item);
        }
//        session.setAttribute("item", item);
//        session.setAttribute("p", p);

        session.setAttribute("cart", cart);
        String url = "/cart.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void doCheckout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String hoten = request.getParameter("hoten");
        String address = request.getParameter("address");
//         int phone = Integer.parseInt(request.getParameter("phone"));
        String phoneString = request.getParameter("phone");

        int phone = 0;
        try {
            phone = Integer.parseInt(phoneString);

        } catch (NumberFormatException e) {
            phone = 1;
        }
        String email = request.getParameter("email");
        LocalDate orderDate = LocalDate.now();
        String url = "";
        String message = "";
        if (hoten == "" || address == "" || phone == 0 || email == "") {
            message = "Request enter full all flield.";
            url = "/cart.jsp";
        } else {
            Cart cart = (Cart) request.getSession().getAttribute("cart");

            Orders orders = new Orders(0, hoten, address, phone, email, orderDate,false, cart);

            message = "";
            if (OrdersDB.insertOrders(orders)) {
                message = "Cám ơn quí khách đã mua hàng của website.";
            } else {
                message = "Đặt hàng thất bại";
            }
            url = "/thanks.jsp";
        }

        HttpSession session = request.getSession();
        session.invalidate();
        session = request.getSession();
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void doShop(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";

        getServletContext()
                .getRequestDispatcher(url).forward(request, response);
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
