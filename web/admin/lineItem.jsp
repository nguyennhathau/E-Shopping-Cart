<%@page import="data.LineItemDB"%>
<%@page import="bussiness.LineItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/menu.jsp" />
<div id="body-content" style="width: 82%; margin:10px 9px">	
    <table  align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td colspan="10" style="color: black"> Chi tiết hóa Đơn    
            </td>      
        </tr>
        <p>Số sản phẩm khách hàng đã mua</p>
        <tr class="tb-black" >
            <th width="10%"><div align="center">OrderID</div></th>
            <th width="10%"><div align="center">Tên sản phẩm</div></th>
            <th width="10%"><div align="center">số lượng</div></th>
            <th width="10%"><div align="center">giá</div></th>
        </tr>
        <%
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            for (LineItem l : LineItemDB.getItem(orderID)) {
        %> 
        <tr class="tb-white">
            <td width="10%"><div align="center"><%=l.getOrderID()%></div></td>
            <td width="10%"><div align="center"><%=l.getProducts().getProductName()%></div></td>
            <td width="10%"><div align="center"><%=l.getQuantity()%></div></td>           
            <td width="10%"><div align="center"><%=l.getTotal()%></div></td>                 
        </tr>
        <%
            }
        %>        
    </table>
    <button> <a href="/Webbanhangdientu/admin/manager_order.jsp" onClick="history.back()">Quay về</a></button>
</div>
</body>
</html>