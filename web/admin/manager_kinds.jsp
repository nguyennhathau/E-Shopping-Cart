<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
<div id="body-content" style="width: 82%; margin:10px 9px">	
    <table  align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td colspan="10" style="color: black"> Danh Sách Category
                <a href="addProduct.jsp"><img src="img/add.jpg"></a><p style="background-color: blue;">${message}</p>               
            </td>

        </tr>
        <tr class="tb-black" >
            <th width="10%"><div align="center">KindID</div></th>
            <th width="10%"><div align="center">Kind Name</div></th>
            <th width="10%"><div align="center">Total Product</div></th>
            <th width="5%"><div align="center">Sửa</div></th>
            <th width="5%"><div align="center">Xóa</div></th>
        </tr>
        <c:forEach var="k" items="kinks">
        <tr class="tb-white">
            <td width="10%"><div align="center">${k.kindID}</div></td>
            <td width="10%"><div align="center">${k.kindName}</div></td>
            <td width="10%"><div align="center">${k.sumProductInKinds}</div></td>           
            <td width="5%"><div align="center"><a href=""><img src="img/sua.png"></a></div></td>
            <td width="5%"><div align="center"><a href=""><img src="img/del.jpg"></a></div></td>
        </tr>
        </c:forEach>        
    </table>
</div>
</body>
</html>