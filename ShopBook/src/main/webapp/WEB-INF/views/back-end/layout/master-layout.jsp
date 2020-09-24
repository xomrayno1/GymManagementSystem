<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Manage</title>
	
       <!-- Bootstrap -->
    <link href="<c:url value="/resources/backend/vendors/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value="/resources/backend/vendors/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value="/resources/backend/vendors/nprogress/nprogress.css"/>" rel="stylesheet">
    <!-- jQuery custom content scroller -->
    <link href="<c:url value="/resources/backend/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css"/>" rel="stylesheet"/>

    <!-- Custom Theme Style -->
    <link href="<c:url value="/resources/backend/build/css/custom.min.css"/>" rel="stylesheet">
  
     <script type="text/javascript" src='<c:url value="/resources/backend/vendors/jquery/dist/jquery.min.js"></c:url>'></script>
     
    <link href='<c:url value="/resources/backend/build/css/map.css"></c:url>' rel="stylesheet">
    
    <!-- PNotify -->

    <link href='<c:url value="/resources/backend/vendors/pnotify/dist/pnotify.css"></c:url>' rel="stylesheet">
    <link href='<c:url value="/resources/backend/vendors/pnotify/dist/pnotify.buttons.css"></c:url>' rel="stylesheet">
    <link href='<c:url value="/resources/backend/vendors/pnotify/dist/pnotify.nonblock.css"></c:url>' rel="stylesheet">
 
    <link href='<c:url value="/resources/backend/vendors/bootstrap-daterangepicker/daterangepicker.css"></c:url>' rel="stylesheet">
    <link href="<c:url value="/resources/backend/vendors/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.css"/>" rel="stylesheet">
    
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href='<c:url value="/manage/index"></c:url>' class="site_title"><i class="fa fa-paw"></i> <span>Management Shop</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src='<c:url value="/resources/backend/images/img.jpg"></c:url>' alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>${userInfo.name}</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
			<tiles:insertAttribute name="sidebar" />
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <tiles:insertAttribute name="top-nav" />
        <!-- /top navigation -->

        <!-- page content -->
         <tiles:insertAttribute name="body" />
        <!-- /page content -->

        <!-- footer content -->
        <tiles:insertAttribute name="footer"/>
        <!-- /footer content -->
      </div>
    </div>

   <!-- PNotify -->

    <script src='<c:url value="/resources/backend/vendors/pnotify/dist/pnotify.js"></c:url>'></script>
    <script src='<c:url value="/resources/backend/vendors/pnotify/dist/pnotify.buttons.js"></c:url>'></script>
    <script src='<c:url value="/resources/backend/vendors/pnotify/dist/pnotify.nonblock.js"></c:url>'></script>


    <!-- jQuery -->
    <script src="<c:url value="/resources/backend/vendors/jquery/dist/jquery.min.js"/>"></script>
    <!-- Bootstrap -->
    <script src="<c:url value="/resources/backend/vendors/bootstrap/dist/js/bootstrap.min.js"/>"></script>
    <!-- FastClick -->
    <script src="<c:url value="/resources/backend/vendors/fastclick/lib/fastclick.js"/>"></script>
    <!-- NProgress -->
    <script src="<c:url value="/resources/backend/vendors/nprogress/nprogress.js"/>"></script>
    <!-- jQuery custom content scroller -->
    <script src="<c:url value="/resources/backend/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"/>"></script>
    <!-- bootstrap-datetimepicker -->    
    <!-- bootstrap-daterangepicker -->
 	 <script src="<c:url value="/resources/backend/vendors/moment/min/moment.min.js"/>"></script>
    <script src="<c:url value="/resources/backend/vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"/>"></script>
    <!-- Custom Theme Scripts -->
    <script src="<c:url value="/resources/backend/build/js/custom.min.js"/>"></script>
  </body>
</html>