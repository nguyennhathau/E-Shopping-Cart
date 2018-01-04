<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/menu.jsp" />
<link rel="stylesheet" type="text/css" media="all" href="css/calendar-win2k-1.css" title="win2k-cold-1" />
<script src="js/calendar.js" type="text/javascript"></script>
<script type="text/javascript" src="js/calendar-en.js"></script>
<script type="text/javascript" src="js/calendar-setup.js"></script>
<!-- CKEditor Sample -->
<script type="text/javascript" src="js/ckeditor.js"></script>
<script src="js/sample.js" type="text/javascript"></script>
<link href="js/sample.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="scripts1.js"></script>
<div id="body-content" style="width: 82%; margin:10px 9px">	

    <form action="/Webbanhangdientu/manager_accServlet" method="post">
        <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td colspan="2"><div align="center">Thêm người dùng</div></td>
            </tr>
            <p style="background-color: blue;">${message}</p>  
            <tr>
                <td width="100">UserName:</td>
                <td width="250"><input name="username" type="text" value=""></td>
            </tr>

            <tr>
                <td width="100">PassWord:</td>
                <td width="250"><input name="password" type="text" value=""></td>
            </tr>
            <tr>
                <td colspan="2"><div align="center">
                        <input type="hidden" name="act" value="insert">
                        <input type="submit"  value="Save">
                        <input type="button" name="Submit2" value="Quay Về" onClick="history.back()">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>



