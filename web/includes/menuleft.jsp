<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<link href="../css/main.css" rel="stylesheet" type="text/css"/>-->
<!--left-->
<div class="col-sm-3">
    <div class="left-sidebar">
        <h2>Category</h2>
        <div class="panel-group category-products"><!--category-productsr-->
            <c:forEach var="c" items="category">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            
                        </h4>
                    </div>                    
                </div>
            </c:forEach>



        </div><!--/category-products-->

        <div class="brands_products"><!--brands_products-->
            <h2>Brands</h2>
            <div class="brands-name">
                <ul class="nav nav-pills nav-stacked">
                    
                </ul>
            </div>
        </div><!--/brands_products-->



        <div class="shipping text-center"><!--shipping-->
            <img src="image/shipping.jpg" alt="" />
        </div><!--/shipping-->

    </div>
</div>
<!-- ---left-->