<%@page import="data.CategoryDB"%>
<%@page import="bussiness.Kinds"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/Webbanhangdientu/admin/css/index.css" rel="stylesheet" type="text/css"/>
        <link href="/Webbanhangdientu/admin/css/products.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <div class="top" style="height: 6em;">
            <div class="trangchu"><p><a href=""> <img src="/Webbanhangdientu/admin/images/home.png">NH View Site</a></p></div>
            <div class="info">
                <p>Xin chao: ${sessionScope.username}
                <a style="color: darkcyan"; href="" >Logout</a></p>
            </div>     
        </div>
        <div id="adminmenuwrap" >
            <ul id="adminmenu">
                <li id="menu-top""><a href="/Webbanhangdientu/admin/index.jsp"><div class="wp-menu-arrow"></div><div class="menu-name">Trang Chủ</div></a></li>
                <li id="menu-top"><a href="/Webbanhangdientu/admin/manager_kinds.jsp"><div class="wp-menu-arrow"></div><div class="menu-name">Loại Sản phẩm</div></a></li>
                <li id="menu-top"><a href="/Webbanhangdientu/admin/manager_category.jsp"><div class="wp-menu-arrow"></div><div class="menu-name">Nhà Sản Xuất</div></a></li>
                <li id="menu-top"><a href="/Webbanhangdientu/admin/manager_products.jsp"><div class="wp-menu-arrow"></div><div class="menu-name">Sản Phẩm</div></a></li>
                <li id="menu-top"><a href="/Webbanhangdientu/admin/manager_order.jsp"><div class="wp-menu-arrow"></div><div class="menu-name">Đơn hàng</div></a></li>
                <li id="menu-top"><a href="/Webbanhangdientu/admin/manager_acc.jsp"><div class="wp-menu-arrow"></div><div class="menu-name"> Tài khoản</div></a> </li>
                <li id="menu-top"><a href="/Webbanhangdientu/LoginServlet"><div class="wp-menu-arrow"></div><div class="menu-name"> Thoát</div></a> </li>
            </ul>
        </div>

