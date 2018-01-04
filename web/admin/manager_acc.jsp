<%@page import="data.AccountDB"%>
<%@page import="bussiness.Accounts"%>
<%@page import="bussiness.Accounts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/menu.jsp" />
<div id="body-content" style="width: 82%; margin:10px 9px">	
    <table  align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td colspan="10" style="color: black"> Danh Sách Tài khoản
                <a href="/Webbanhangdientu/admin/addAcc.jsp"><img src="/Webbanhangdientu/admin/img/add.jpg"></a>            
            </td>
         
        </tr>
        <p style="background-color: blue; color: white;">${message}</p>  
        <tr class="tb-black" >
            <th width="10%"><div align="center">username</div></th>
            <th width="10%"><div align="center">Họ password</div></th>
            <th width="5%"><div align="center">Sửa</div></th>
            <th width="5%"><div align="center">Xóa</div></th>
        </tr>
        <%
            for (Accounts acc : AccountDB.getAccounts()) {
        %> 
        <tr class="tb-white">
            <td width="10%"><div align="center"><%=acc.getUsername()%></div></td>
            <td width="10%"><div align="center"><%=acc.getPassword()%></div></td>          
            <td width="5%"><div align="center"><a href="updateAcc.jsp?username=<%=acc.getUsername()%>&password=<%=acc.getPassword()%> "><img src="/Webbanhangdientu/admin/img/sua.png"></a></div></td>
            <td width="5%"><div align="center"><a href="/Webbanhangdientu/manager_accServlet?act=delete&username=<%=acc.getUsername()%>"><img src="/Webbanhangdientu/admin/img/del.jpg"></a></div></td>
        </tr>
        <%
            }
        %>        
    </table>
</div>
</body>
</html>