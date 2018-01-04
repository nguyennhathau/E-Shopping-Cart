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

    <form action="/Webbanhangdientu/admin_ProductServlet" method="post" enctype="multipart/form-data">
        <!-- enctype="multipart/form-data" -->
        <table width="100%" border="1" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td colspan="2"><div align="center">sửa Sản Phẩm</div></td>
            </tr>
            <p style="background-color: blue;">${message}</p>  
            <tr>
                <td width="100">Tên Sản Phẩm</td>
                <td width="250"><input name="productName" type="text" value="<%=request.getParameter("productName")%>"></td>
            </tr>

            <tr>
                <td width="100">Loại Sản Phẩm</td>
                <td width="600">
                    <select name="categoryID"  onchange="loadXMLDoc(this.value)">
                        <!-- Loai san pham -->
                        <option>--Category Product--</option>
                        <%
                            for (Kinds k : CategoryDB.getKinds()) {
                        %>
                        <option style="background-color: #23282d; color: #fff"><%=k.getKindName()%></option>
                        <%
                            for (Categories c : CategoryDB.getCategories(k.getKindID())) {
                        %>
                        <option name="categoryID" value="<%=c.getCategoryID()%>" 
                                <% if (c.getCategoryID() == Integer.parseInt(request.getParameter("categoryID"))) {
                                    System.out.print("selected");
                                    }%>
                                ><%=c.getCategoryName()%></option>
                        <%}
                                }%>
                        <option style="background-color: #0b65bf; color: #fff" name="promotion" value="promotion">promotions</option>
                    </select>
                    <!--<div id="sp" style="width:150px;"></div>-->  
                </td>
            </tr>
            <tr>
                <td width="100">Ngày Cập Nhật</td>
                <td width="250">
                    <input type="text" name="timeUpdate" id="f_date_b" value="<%=request.getParameter("timeUpdate")%>"/>
                    <button type="reset" id="f_trigger_b">...</button>
                    <script type="text/javascript">
                        Calendar.setup({
                            inputField: "f_date_b", // id of the input field
                            ifFormat: "%d/%m/%Y", // format of the input field
                            showsTime: true, // will display a time selector
                            button: "f_trigger_b", // trigger for the calendar (button ID)
                            singleClick: false, // double-click mode
                            step: 1                // show all years in drop-down boxes (instead of every other year as default)
                        });
                    </script>
                </td>
            </tr>

            <tr>
                <td width="100">Hình</td>
                <td width="250"><input name="urlImage" type="file" value="<%=request.getParameter("urlImage")%>"></td>
            </tr>

            <tr>
                <td width="100">Giá</td>
                <td width="250"><input name="price" type="text" value="<%=request.getParameter("price")%>"></td>
            </tr>
            <tr>
                <td width="100">Mô tả:</td>
                <td width="250">
                    <textarea cols="58" name="description" rows="10"><%=request.getParameter("description")%></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2"><div align="center">
                        <input type="submit" name="act" value="update">
                        <input type="button" name="Submit2" value="Quay Về" onClick="history.back()">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>



