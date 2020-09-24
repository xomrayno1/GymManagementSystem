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
        
          <script type="text/javascript" src='<c:url value="/resources/backend/vendors/jquery/dist/jquery.min.js"></c:url>'></script>
    </head>
    <body>
        <!-- header start -->
        <tiles:insertAttribute name="header" />
        



		<tiles:insertAttribute name="body"/>
        
		<tiles:insertAttribute name="footer"/>
        
  		 <script src="<c:url value="/resources/backend/vendors/jquery/dist/jquery.min.js"/>"></script>
        <!-- <script src="<c:url value='/resources/frontend/js/vendor/jquery-1.12.0.min.js'></c:url>"></script> -->
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
