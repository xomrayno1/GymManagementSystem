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
				                                            <img width="150px" height="150px" src='<c:url value="${product.imgUrl}"></c:url>' alt="">
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
				                                        <img width="150px" height="150px" src='<c:url value="${menuChil.imgUrl}"></c:url>' alt="">
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
