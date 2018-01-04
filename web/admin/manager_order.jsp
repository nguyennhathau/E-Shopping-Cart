<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bussiness.Orders"%>
<%@page import="data.OrdersDB"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/menu.jsp" />
<div id="body-content" style="width: 82%; margin:10px 9px">	
    <table  align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td colspan="10" style="color: black"> Danh Sách Đơn Hàng
            </td>
         
        </tr>
        <p style="background-color: blue;color: white;">${message}</p>  
        <tr class="tb-black" >
            <th width="10%"><div align="center">OrderID</div></th>
            <th width="10%"><div align="center">Họ tên</div></th>
            <th width="10%"><div align="center">Địa chỉ</div></th>
            <th width="10%"><div align="center">SDT</div></th>
            <th width="10%"><div align="center">email</div></th>
            <th width="10%"><div align="center">ngày đặt hàng</div></th>
            <th width="10%"><div align="center">Trạng thái</div></th>
            <th width="10%"><div align="center">Chi tiết đơn hàng</div></th>
            <th width="5%"><div align="center">Cập nhập</div></th>
            <th width="5%"><div align="center">Xóa</div></th>
        </tr>
        <c:forEach var="o" items="${order}">
            <tr class="tb-white">
            <td width="10%"><div align="center">${o.orderID}</div></td>
            <td width="10%"><div align="center">${o.hoten}</div></td>
            <td width="10%"><div align="center">${o.address}</div></td>           
            <td width="10%"><div align="center">${o.phone}</div></td>           
            <td width="10%"><div align="center">${o.email}</div></td>           
            <td width="10%"><div align="center">${o.orderDate}</div></td>           
            <td width="10%"><div align="center">${o.statusOrder}</div></td>           
            <td width="10%"><div align="center"><button><a href="/Webbanhangdientu/admin/lineItem.jsp?orderID=${o.orderID}">Chi tiết HĐ</a></button></div></td>           
            <td width="5%"><div align="center">
                    <a href="/Webbanhangdientu/manager_orderServlet?act=update&id=${o.orderID}">
                        <button>Đã giao hàng</button></a></div></td>
            <td width="5%"><div align="center"><a href="/Webbanhangdientu/manager_orderServlet?act=delete&id=${o.orderID}">
                        <img src="/Webbanhangdientu/admin/img/del.jpg"></a></div></td>
        </tr>
        </c:forEach>
        
        
              
    </table>
</div>
</body>
</html>