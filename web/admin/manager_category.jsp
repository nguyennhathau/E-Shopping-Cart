<%@page import="bussiness.Categories"%>
<%@page import="data.CategoryDB"%>
<%@page import="bussiness.Kinds"%>
<%@page import="bussiness.Kinds"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/menu.jsp" />
<div id="body-content" style="width: 82%; margin:10px 9px">	
    <table  align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td colspan="10" style="color: black"> Danh Sách nhà sản xuất
                <a href="addcategory.jsp"><img src="/Webbanhangdientu/admin/img/add.jpg"></a>            
            </td>
         
        </tr>
        <p style="background-color: blue;color: white;">${message}</p>  
        <tr class="tb-black" >
            <th width="10%"><div align="center">CategoryID</div></th>
            <th width="10%"><div align="center">Category Name</div></th>
            <th width="10%"><div align="center">KindID</div></th>
            <th width="5%"><div align="center">Sửa</div></th>
            <th width="5%"><div align="center">Xóa</div></th>
        </tr>
        <%
            for (Categories c : CategoryDB.getCategories()) {
        %> 
        <tr class="tb-white">
            <td width="10%"><div align="center"><%=c.getCategoryID()%></div></td>
            <td width="10%"><div align="center"><%=c.getCategoryName()%></div></td>
            <td width="10%"><div align="center"><%=c.getKindID()%></div></td>           
            <td width="5%"><div align="center"><a href="update_category.jsp?id=<%=c.getCategoryID()%>&name=<%=c.getCategoryName()%>&kindID=<%=c.getKindID()%>"><img src="/Webbanhangdientu/admin/img/sua.png"></a></div></td>
            <td width="5%"><div align="center"><a href="/Webbanhangdientu/manager_CategoryServlet?act=delete&id=<%=c.getCategoryID()%>"><img src="/Webbanhangdientu/admin/img/del.jpg"></a></div></td>
        </tr>
        <%
            }
        %>        
    </table>
</div>
</body>
</html>