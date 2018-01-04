
<%@page import="data.ProductDB"%>
<%@page import="bussiness.Products"%>
<%@page import="bussiness.Kinds"%>
<%@page import="data.CategoryDB"%>
<%@page import="bussiness.Categories"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="includes/menu.jsp" />
<div id="body-content" style="width: 82%; margin:10px 9px">	
    <table  align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td colspan="10" style="color: black"> Danh Sách Sản Phẩm
                <a href="addProduct.jsp"><img src="/Webbanhangdientu/admin/img/add.jpg"></a><p style="background-color: blue;">${message}</p>
                <form action="" method="post">
                    <label>Loai san pham:</label>
                    <select>
                        <option>--Category Product--</option>
                        <%
                            for (Kinds k : CategoryDB.getKinds()) {
                        %>
                        <option style="background-color: #23282d; color: #fff"><%=k.getKindName()%></option>
                        <%
                            for (Categories c : CategoryDB.getCategories(k.getKindID())) {
                        %>
                        <option name="categoryID" value="<%=c.getCategoryID()%>"><%=c.getCategoryName()%></option>
                        <%}
                            }%>
                        <option style="background-color: #0b65bf; color: #fff" name="promotion" value="promotion">promotions</option>
                    </select>
                    <input type="submit" name="act" id="button" value="search" />
                </form>
                
            </td>

        </tr>
        <tr class="tb-black" >
            <th width="10%"><div align="center">productID</div></th>
            <th width="10%"><div align="center">categoryID</div></th>
            <th width="10%"><div align="center">productName </div></th>
            <th width="15%"><div align="center">timeUpdate</div></th>
            <th width="15%"><div align="center">urlImage</div></th>
            <th width="10%"><div align="center">price</div></th>
            <th width="25%"><div align="center">description</div></th>
            <th width="5%"><div align="center">Sửa</div></th>
            <th width="5%"><div align="center">Xóa</div></th>
        </tr>
        <%
            for (Products p : ProductDB.getProducts()) {
        %>    
        <tr class="tb-white">
            <td width="10%"><div align="center"><%=p.getProductID()%></div></td>
            <td width="10%"><div align="center"><%=p.getCategoryID()%></div></td>
            <td width="10%"><div align="center"><%=p.getProductName()%></div></td>
            <td width="15%"><div align="center"><%=p.getTimeUpdate()%></div></td>
            <td width="15%"><div align="center"><img src="/Webbanhangdientu/image/<%=p.getUrlImage()%>" width="100" height="100"></div></td>
            <td width="10%"><div align="center"><%=p.getFormattedPrice()%>$</div></td>
            <td width="25%"><div align="center"><%=p.getDescription()%></div></td>
            <td width="5%"><div align="center">
                    <a href="update_product?productID=<%=p.getProductID()%>&categoryID=<%=p.getCategoryID()%>&productName=<%=p.getProductName()%>&price=<%=p.getPrice()%>
                       &urlImage=<%=p.getUrlImage()%>&timeUpdate=<%=p.getTimeUpdate()%>&description=<%=p.getDescription()%>">
                        <img src="/Webbanhangdientu/admin/img/sua.png"></a></div></td>
            <td width="5%"><div align="center"><a href="/Webbanhangdientu/admin_ProductServlet?act=delete&productID=<%=p.getProductID()%>"><img src="/Webbanhangdientu/admin/img/del.jpg"></a></div></td>
        </tr>
        <%
            }
        %>
        

    </table>
    <!--        <div class="clear"></div>-->
    <p class="pagenavi" align="center">

        <!-- trang hien tai cua tong so trang -->
        <span>Page 1 of 41</span>

        <!-- hien trang dau -->
        <a href="index.php?act=sanpham&p=1">Trang đầu</a>
        <!-- liet ke thu tu cac trang trong nhom -->
        1&nbsp; <a href="index.php?act=sanpham&p=2">2</a>
        <a href="index.php?act=sanpham&p=3">3</a>
        <a href="index.php?act=sanpham&p=4">4</a>
        <a href="index.php?act=sanpham&p=5">5</a>
        <a href="index.php?act=sanpham&p=6">6</a>
        <a href="index.php?act=sanpham&p=7">7</a>
        <a href="index.php?act=sanpham&p=8">8</a>
        <a href="index.php?act=sanpham&p=9">9</a>
        <a href="index.php?act=sanpham&p=10">10</a>
        <!-- hien trang sau -->
        <a href="index.php?act=sanpham&p=2">>></a>&nbsp;
        <a href="index.php?act=sanpham&p=41">Trang cuối</a>
    </p>

</div>
</body>
</html>



