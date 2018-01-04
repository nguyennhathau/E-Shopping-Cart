<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Đăng nhập hệ thống</title>
        <link href="/Webbanhangdientu/admin/css/csslogin.css" rel="stylesheet" type="text/css" />
    </head>

    <body >
        <div class="login-container">
            <img  class="profile-img-card" src="/Webbanhangdientu/admin/img/logo.jpg" alt="" />
            <form method="post" action="/Webbanhangdientu/LoginServlet" id="loginForm">
                <input type="text"  class="text" name="username" id="username" value="" class="form-text" />
                <input type="password" class="text" name="password" id="password" class="form-text" />
                <input type="submit" name="dangnhap" id="btnSubmit" value="Đăng nhập" class="form-submit" />
                <p style="text-align: center;background-color: #008b11;">${message}</p>
            </form>
        </div>
        </form>
    </body>
</html>
