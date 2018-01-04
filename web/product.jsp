<%@page import="bussiness.Products"%>
<%@page import="data.ProductDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/slide.jsp" />


<section>
    <div class="container">
        <div class="row">
            <jsp:include page="/includes/menuleft.jsp" />
            <div class="col-sm-9 padding-right">
                <!--Sell best-tab-->             
                <div class="category-tab">
                    <h2 class="title text-center">Product</h2>
                    <div class="tab-pane fade in" >
                        <%
                            int categoryID = (Integer.parseInt(request.getParameter("categoryID")));
                            for (Products p : ProductDB.getProductsByCategory(categoryID)) {
                        %>
                        <div class="col-sm-4">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">
                                        <a href="product-details.jsp?productID=<%=p.getProductID()%>">
                                            <img src="image/<%=p.getUrlImage()%>" alt="" />
                                        </a>
                                        <h2><%=p.getFormattedPrice()%></h2>
                                        <p><%=p.getProductName()%></p>
                                        <a href="cartServlet?productID=<%=p.getProductID()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>

                </div><!--/Sell best-tab-->
            </div>
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



