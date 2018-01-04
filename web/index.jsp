<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bussiness.Products"%>
<%@page import="data.ProductDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />
<%--<jsp:include page="/includes/slide.jsp" />--%>
<section id="slider"><!--slider-->
    <div class="container">
        <img style="margin-left: 88px;" src="image/banner.jpg" alt="banner" />
    </div>
</section><!--/slider-->

<section>
    <div class="container">
        <div class="row">
            <jsp:include page="/includes/menuleft.jsp" />
            <div class="col-sm-9 main-right">
                <!--features_items-->
                <div class="features_items">
                    <h2 class="title text-center">Sản phẩm mới</h2>
                    <c:forEach var="p" items="${productsbestsell}">
                        <div class="col-sm-4">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">  
                                        <a href="product-details.jsp?productID=${p.productID}"><img src="image/${p.urlImage}" alt="" /></a>

                                        <h2>${p.price}</h2>
                                        <p>Easy Polo Black Edition</p>
                                        <a href="cartServlet?productID=${p.productID}" class="btn btn-default add-to-cart">
                                            <i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>                            
                                </div>

                            </div>
                        </div>
                    </c:forEach>

                </div><!--features_items-->

                <!--Sell best-tab-->             
                <div class="category-tab">
                    <h2 class="title text-center">Sản phẩm bán chạy</h2>

                    <div class="tab-pane fade in" >
                        <c:forEach var="p" items="${productnew}">
                        <div class="col-sm-4">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">  
                                        <a href="product-details.jsp?productID=${p.productID}"><img src="image/${p.urlImage}" alt="" /></a>

                                        <h2>${p.price}</h2>
                                        <p>Easy Polo Black Edition</p>
                                        <a href="cartServlet?productID=${p.productID}" class="btn btn-default add-to-cart">
                                            <i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>                            
                                </div>

                            </div>
                        </div>
                    </c:forEach>
                    </div>



                </div><!--/Sell best-tab-->

                <!--Promotions-->
                <div class="recommended_items">
                    <h2 class="title text-center">Sản phẩm khuyến mãi</h2>	
                    <c:forEach var="p" items="${productpro}">
                        <div class="col-sm-4">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">  
                                        <a href="product-details.jsp?productID=${p.productID}"><img src="image/${p.urlImage}" alt="" /></a>

                                        <h2>${p.price}</h2>
                                        <p>Easy Polo Black Edition</p>
                                        <a href="cartServlet?productID=${p.productID}" class="btn btn-default add-to-cart">
                                            <i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>                            
                                </div>

                            </div>
                        </div>
                    </c:forEach>
                </div><!--/Promotions-->

            </div>
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



