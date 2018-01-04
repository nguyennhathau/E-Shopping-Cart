/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import data.AccountDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String url="";
        String message="";
        if(user==""||pass==""){
             message="username or password is wrong.";
             url="/admin/login.jsp";
        }else if (AccountDB.login(user, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", user);
            url="/admin/index.jsp";
        } else {
            message="Acount is invalid!";
            url="/admin/login.jsp";
        }
        request.setAttribute("message",message );
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    //Xoa session khi logout
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException { //To change body of generated methods, choose Tools | Templates.
//        HttpSession session = request.getSession();
//        session.removeAttribute("username");
//        response.sendRedirect("login.jsp");
//    }
    //Xoa session cach 2
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        String url="/admin/login.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

}
