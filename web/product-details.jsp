<%@page import="bussiness.Products"%>
<%@page import="data.ProductDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />


<section>
    <div class="container">
        <div class="row">
            <jsp:include page="/includes/menuleft.jsp" />
            <div class="col-sm-9 padding-right">
                <%
                        int productID=Integer.parseInt(request.getParameter("productID"));
                        Products p=ProductDB.getProduct(productID);
                    %>
                <div class="product-details"><!--product-details-->
                    <div class="col-sm-5">
                        <div class="view-product">
                            <img src="image/<%=p.getUrlImage()%>" alt="" />
                            <h3>ZOOM</h3>
                        </div>


                    </div>
                    <div class="col-sm-7">
                        <div class="product-information"><!--/product-information-->
                            <img src="image/new.jpg" class="newarrival" alt="" />
                            <h2><%=p.getProductName()%></h2>
                            <p>Products ID: <%=p.getProductID()%></p>
                            <img src="image/rating.png" alt="" />
                            <span>
                                <span>US <%=p.getFormattedPrice()%>$</span>

                                <form action="cartServlet" method="post">
                                    <input type="hidden" name="productID" value="${item.product.productID}">
                                    <input type="hidden" name="action" value="update">
                                    <label>Quantity:</label>
                                    <input type="text" name="quantity" value="${item.quantity}">
                                    <input type="submit" class="fa fa-shopping-cart btn btn-fefault cart" value="Update">
                                </form>
                            </span>
                            <p>${p.description}</p>
                            <a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
                        </div><!--/product-information-->
                    </div>
                </div><!--/product-details-->
                
            </>
        </div>
    </div>
</section>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
<!--footer-->
<jsp:include page="/includes/footer.jsp" />



