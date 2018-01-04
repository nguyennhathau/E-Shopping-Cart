<%@page import="bussiness.Products"%>
<%@page import="data.ProductDB"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:include page="/includes/header.jsp" />--%>
<%@include file="/includes/header.jsp" %>
<section id="cart_items">
    <div class="container">
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                    <tr class="cart_menu">
                        <td class="image">Item</td>
                        <td class="description"></td>
                        <td class="price">Price</td>
                        <td class="quantity">Quantity</td>
                        <td class="total">Total</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item"  items="${cart.items}" >
                        <tr>
                            <td class="cart_product">
                                <a href=""><img src="images/cart/one.png" alt=""></a>
                            </td>
                            <td class="cart_description">
                                <h4><a href="">${item.products.productName}</a></h4>
                                <p>product ID: ${item.products.productID}</p>
                            </td>
                            <td class="cart_price">
                                <p>${item.products.price}</p>
                            </td>
                            <td class="cart_quantity">
                                <form action="cartServlet" method="post">
                                    <input type="hidden" name="productID" value="${item.products.productID}">
                                    <input type="hidden" name="action" value="update">
                                    <input class="cart_quantity_input" type="text" name="quantity" value="${item.quantity}" autocomplete="off" size="2">
                                    <input type="submit" class="btn btn-default update" value="Update">
                                </form>
                            </td>
                            <td class="cart_total">
                                <p class="cart_total_price">${item.totalFormatted}$</p>
                            </td>
                            <td class="cart_delete">
                                <a class="cart_quantity_delete" href="cartServlet?action=remove&productID=${item.products.productID}"><i class="fa fa-times"></i></a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>          
        </div>
        <form style="margin-left: 0;" action="cartServlet" method="post">
                <input type="hidden" name="action" value="shop">
                <input class="btn btn-default check_out"  style="margin-top: 1em;" type="submit" value="Continue buy">         
            </form>
    </div>
</section> <!--/#cart_items-->

<section id="do_action">
    <div class="container">

        <div class="heading">
            <h3>What would you like to do next?</h3>
            <p>Choose if you have a discount code or reward points you want to use or would like to estimate your delivery cost.</p>
        </div>
        <div class="row">

            <div class="col-sm-10">
                <div class="total_area">
                    <ul>
                        <li>Total product: <span>${cart.getTotalProduct()}</span></li>
                        <li>Total Price: <span>${cart.totalPriceFormatted}$</span></li>
                        <li>Shipping Cost <span>Free</span></li>
                    </ul>
                    <p style="color:red;margin-left: 45px;">${message}</p>
                    <form style="margin-left: 46px;" action="cartServlet" method="post">
                        <input type="hidden" name="action" value="checkout">
                        <label style="width: 70px;">Name: </label>       
                        <input type="text" name="hoten" size="40"> <br>
                        <label style="width: 70px;">Address:</label>
                        <input type="text" name="address" size="40"> <br>
                        <label style="width: 70px;">phone:</label>
                        <input type="text" name="phone" > <br>
                        <label style="width: 70px;">Email:</label>
                        <input type="email" name="email" size="40"> <br>
                        <!--<input type="text" name="orderDate">--> 
                        <input class="btn btn-default check_out" type="submit" value="Checkout"> 
                    </form>
                </div>
            </div>
            <div class="col-sm-2">

            </div>
        </div>
    </div>
</section><!--/#do_action-->



<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
<!--footer-->
<jsp:include page="/includes/footer.jsp" />



