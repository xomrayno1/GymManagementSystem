<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>					
           <div class="col-sm-2 col-sm-2">
                		<h3 class="page-title text-center"><i class="fa fa-user"></i></h3>             
                   		<ul class="list-group">
                   			<li class="list-group-item ">
                   				<a href='<c:url value="/account/"></c:url>'>Thông tin tài khoản</a>
                   			</li>
                   			<li class="list-group-item ">
                   				<a href='<c:url value="/order/list"></c:url>'>Quản lý đơn hàng</a>
                   			</li>
                   			<li class="list-group-item">
                   				<a href='<c:url value="/account/address/list"></c:url>'>Sổ địa chỉ</a>
                   			</li>
                   			<li class="list-group-item">
                   				<a href='<c:url value="/account/wishlist"></c:url>'>Sản phẩm yêu thích</a>
                   			</li>
                   			<li class="list-group-item">
                   				<a href="#">Sản phẩm bạn đã xem</a>
                   			</li>
                   			<li class="list-group-item">
                   				<a href='<c:url value="/account/password"></c:url>'>Đổi mật khẩu</a>
                   			</li>
                   		</ul>
             </div>