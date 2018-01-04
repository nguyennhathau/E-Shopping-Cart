<%@page import="bussiness.Categories"%>
<%@page import="bussiness.Categories"%>
<%@page import="data.CategoryDB"%>
<%@page import="bussiness.Kinds"%>
<%@page import="bussiness.Kinds"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/menu.jsp" />
<link rel="stylesheet" type="text/css" media="all" href="css/calendar-win2k-1.css" title="win2k-cold-1" />
<!-- main calendar program -->
<script src="js/calendar.js" type="text/javascript"></script>
<!-- language for the calendar -->
<script type="text/javascript" src="js/calendar-en.js"></script>

<!-- the following script defines the Calendar.setup helper function, which makes
     adding a calendar a matter of 1 or 2 lines of code. -->
<script type="text/javascript" src="js/calendar-setup.js"></script>
<!-- CKEditor Sample -->
<script type="text/javascript" src="js/ckeditor.js"></script>
<script src="js/sample.js" type="text/javascript"></script>
<link href="js/sample.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="scripts1.js"></script>
<div id="body-content" style="width: 82%; margin:10px 9px">	

    <form action="/Webbanhangdientu/manager_CategoryServlet" method="post">
        <!-- enctype="multipart/form-data" -->
        <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td colspan="2"><div align="center">Add category</div></td>
            </tr>
            <p style="background-color: blue;">${message}</p>  
            <tr>
                <td width="100">Category Name</td>
                <td width="250"><input name="categoryName" type="text" value="<%=request.getParameter("name")%>"></td>
            </tr>

            <tr>
                <td width="100">Loại Sản Phẩm</td>
                <td width="600">
                    <select name="kindID">
                        <!-- Loai san pham -->
                        <option>--Kinds--</option>
                        <%
                            for (Kinds k : CategoryDB.getKinds()) {
                        %>
                        <option  value="<%=k.getKindID()%>"><%=k.getKindName()%></option>
                        <%}%>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><div align="center">
                        <input type="hidden" name="act" value="update">
                        <input type="hidden" name="categoryID" value="<%=request.getParameter("id")%>">
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



