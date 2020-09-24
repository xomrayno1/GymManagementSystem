<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!doctype html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Book</title>
        <meta name="description" content="">
        <meta name="robots" content="noindex, follow" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="<c:url value='/resources/img/favicon.png'></c:url>" >		
		<!-- all css here --> 
        <link rel="stylesheet" href="<c:url value='/resources/frontend/css/bootstrap.min.css'></c:url>">
        <link rel="stylesheet" href="<c:url value='/resources/frontend/css/animate.css'></c:url>">
        <link rel="stylesheet" href="<c:url value='/resources/frontend/css/owl.carousel.min.css'></c:url>">
        <link rel="stylesheet" href="<c:url value='/resources/frontend/css/slick.css'></c:url>">
        <link rel="stylesheet" href="<c:url value='/resources/frontend/css/chosen.min.css'></c:url>">
        <link rel="stylesheet" href="<c:url value='/resources/frontend/css/font-awesome.min.css'></c:url>">
        <link rel="stylesheet" href="<c:url value='/resources/frontend/css/simple-line-icons.css'></c:url>">
        <link rel="stylesheet" href="<c:url value='/resources/frontend/css/ionicons.min.css'></c:url>">
        <link rel="stylesheet" href="<c:url value='/resources/frontend/css/meanmenu.min.css'></c:url>">
        <link rel="stylesheet" href="<c:url value='/resources/frontend/css/style.css'></c:url>">
        <link rel="stylesheet" href="<c:url value='/resources/frontend/css/responsive.css'></c:url>">
        <script src="<c:url value='/resources/frontend/js/vendor/modernizr-2.8.3.min.js'></c:url>"></script>
    </head>
    <body>
        <!-- header start -->
        <tiles:insertAttribute name="header" />
        
		<tiles:insertAttribute name="banner" />
	
     <div class="container">
     	      <div>
	       		<div class="product-tab-list-wrap text-center mb-40 yellow-color">
	        		<p>Tác phẩm mới</p>	
	        	</div>       
                <div class="tab-content jump yellow-color">               	
							<div id="tab1" class="tab-pane active">
			                        <div class="row">
			                        <c:forEach items="${listProdut}" var="product" > 
			                        	<div class="custom-col-5">
				                                <div class="product-wrapper mb-25">
				                                    <div class="product-img">
				                                        <a href='<c:url value="${product.url}"></c:url>'>
				                                            <img src='<c:url value="${product.imgUrl}"></c:url>' alt="">
				                                        </a>
				                                    </div>
				                                    <div class="product-content">
				                                        <h4>
				                                            <a href='<c:url value="${product.url}"></c:url>' class="title-product">${product.name} </a>
				                                        </h4>
				                                    </div>
				                                </div>
			                           	 </div>
			                        </c:forEach>
			                        </div>
			                    </div>                 
                </div>
	       </div>	
        <c:forEach items="${menuInfo}" var="menu">
	       <div>
	       		<div class="product-tab-list-wrap text-center mb-40 yellow-color">
	        		<p>${menu.name}</p>	
	        	</div>       
                <div class="tab-content jump yellow-color">               	
					<div id="tab1" class="tab-pane active">
			              <div class="row">
			                    <c:forEach items="${menu.childCategory}" var="menuChil">
			                           <div class="custom-col-5">
				                           <div class="product-wrapper mb-25">
				                               <div class="product-img">
				                                    <a href='<c:url value="/the-loai/${menuChil.url}"></c:url>'>
				                                        <img src='<c:url value="${menuChil.imgUrl}"></c:url>' alt="">
				                                     </a>
				                                </div>
				                                <div class="product-content">
				                                      <h4>
				                                         <a href='<c:url value="/the-loai/${menuChil.url}"></c:url>'>${menuChil.name} </a>
				                                      </h4>
				                                </div>
				                           </div>
			                           </div>			                            
			                   </c:forEach>
			             </div>
			        </div>                 
                </div>
	       </div>	       
	 </c:forEach> 
	            	
        </div>
        
        
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">x</span></button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-5 col-sm-5 col-xs-12">
                                <!-- Thumbnail Large Image start -->
                                <div class="tab-content">
                                    <div id="pro-1" class="tab-pane fade show active">
                                        <img src="resources/img/product-details/product-detalis-l1.jpg" alt="">
                                    </div>
                                    <div id="pro-2" class="tab-pane fade">
                                        <img src="resources/img/product-details/product-detalis-l2.jpg" alt="">
                                    </div>
                                    <div id="pro-3" class="tab-pane fade">
                                        <img src="resources/img/product-details/product-detalis-l3.jpg" alt="">
                                    </div>
                                    <div id="pro-4" class="tab-pane fade">
                                        <img src="resources/img/product-details/product-detalis-l4.jpg" alt="">
                                    </div>
                                </div>
                                <!-- Thumbnail Large Image End -->
                                <!-- Thumbnail Image End -->
                                <div class="product-thumbnail">
                                    <div class="thumb-menu owl-carousel nav nav-style" role="tablist">
                                        <a class="active" data-toggle="tab" href="#pro-1"><img src="resources/img/product-details/product-detalis-s1.jpg" alt=""></a>
                                        <a data-toggle="tab" href="#pro-2"><img src="resources/img/product-details/product-detalis-s2.jpg" alt=""></a>
                                        <a data-toggle="tab" href="#pro-3"><img src="resources/img/product-details/product-detalis-s3.jpg" alt=""></a>
                                        <a data-toggle="tab" href="#pro-4"><img src="resources/img/product-details/product-detalis-s4.jpg" alt=""></a>
                                    </div>
                                </div>
                                <!-- Thumbnail image end -->
                            </div>
                            <div class="col-md-7 col-sm-7 col-xs-12">
                                <div class="modal-pro-content">
                                    <h3>PRODUCTS NAME HERE </h3>
                                    <div class="product-price-wrapper">
                                        <span>$120.00</span>
                                        <span class="product-price-old">$162.00 </span>
                                    </div>
                                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet.</p>	
                                    <div class="quick-view-select">
                                        <div class="select-option-part">
                                            <label>Size*</label>
                                            <select class="select">
                                                <option value="">S</option>
                                                <option value="">M</option>
                                                <option value="">L</option>
                                            </select>
                                        </div>
                                        <div class="quickview-color-wrap">
                                            <label>Color*</label>
                                            <div class="quickview-color">
                                                <ul>
                                                    <li class="blue">b</li>
                                                    <li class="red">r</li>
                                                    <li class="pink">p</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-quantity">
                                        <div class="cart-plus-minus">
                                            <input class="cart-plus-minus-box" type="text" name="qtybutton" value="02">
                                        </div>
                                        <button>Add to cart</button>
                                    </div>
                                    <span><i class="fa fa-check"></i> In stock</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
		<tiles:insertAttribute name="footer"/>
        
   
        <script src="<c:url value='/resources/frontend/js/vendor/jquery-1.12.0.min.js'></c:url>"></script>
        <script src="<c:url value='/resources/frontend/js/popper.js'></c:url>"></script>
        <script src="<c:url value='/resources/frontend/js/bootstrap.min.js'></c:url>"></script>
        <script src="<c:url value='/resources/frontend/js/imagesloaded.pkgd.min.js'></c:url>"></script>
        <script src="<c:url value='/resources/frontend/js/isotope.pkgd.min.js'></c:url>"></script>
        <script src="<c:url value='/resources/frontend/js/ajax-mail.js'></c:url>"></script>
        <script src="<c:url value='/resources/frontend/js/owl.carousel.min.js'></c:url>"></script>
        <script src="<c:url value='/resources/frontend/js/plugins.js'></c:url>"></script>
        <script src="<c:url value='/resources/frontend/js/main.js'></c:url>"></script>
    </body>
</html>
