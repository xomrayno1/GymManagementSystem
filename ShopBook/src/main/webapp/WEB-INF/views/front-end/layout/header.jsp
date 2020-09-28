<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

        <header class="header-area">
            <div class="header-middle">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-4 col-12 col-sm-4">
                            <div class="logo">
                                <a href='<c:url value="/index"></c:url>'>
                                    <img alt="" src='<c:url value="/resources/frontend/img/logo/logo.png"></c:url>'>
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-9 col-md-8 col-12 col-sm-8">
                            <div class="header-middle-right f-right">
                                <div class="header-login">
                                      <div class="login-text-content">
			                              <p>
			                                 <c:choose>
			                                  	<c:when test="${userInfo == null}">
			                                  		<a href='<c:url value="/register"></c:url>'><span>
			                                  			<i class="fa fa-key icon-header"></i> Tạo tài khoản</span>
			                                  		</a>	                                  	
			                                  		<a href='<c:url value="/login"></c:url>'>
			                                  			<i class="fa fa-lock icon-header"></i><span> Đăng nhập</span>
			                                  		</a>
			                                  	</c:when>
			                                  	<c:otherwise>
			                                  		<a href='<c:url value="/order/list"></c:url>'>
														<i class="fa fa-map-marker icon-header" ></i><span> Kiểm tra đơn hàng</span>
													</a>
													<a href='<c:url value="/account/"></c:url>'>
														<i class="fa fa-user icon-header" ></i><span> Tài khoản</span>
													</a>
				                                  	<a href='<c:url value="/logout"></c:url>'>
				                                  		<i class="fa fa-key icon-header"></i><span> Đăng xuất</span>
				                                  	</a>
			                                  	</c:otherwise>
			                                 </c:choose>
							                       <a href='<c:url value="/account/wishlist"></c:url>'>
				                                        <i class="icon-heart icon-header"></i><span> Yêu Thích</span>
				                                        
				                                   </a>
			                              </p>
		                             </div>
                               </div>
                                <div class="header-wishlist">
                                </div>
                                <div class="cart-header">
                                	<i class="fa fa-cart-plus icon-header"></i>
                                	<a href='<c:url value="/cart/list"></c:url>'>
				                    <span> Giỏ hàng (${cartInfo.listDetailDTOs.size()})</span>
				                  	<span class="shop-total"><fmt:formatNumber type="currency" value="${cartInfo.totalPrice}" /></span>
				                </a>
                                </div>	
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header-bottom transparent-bar black-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-12">
                            <div class="main-menu">
                                <nav>
                                    <ul>
                                        <li class="top-hover"><a href='<c:url value="/index"></c:url>'>Trang chủ</a></li>
                                        <c:forEach items="${menuInfo}" var="item">
	                                        <li class="mega-menu-position top-hover"><a href='<c:url value="/the-loai/${item.url}"></c:url>'>${item.name} <i class="ion-chevron-down"></i></a>
	                                            <ul class="mega-menu">
	                                                <c:forEach items="${item.childCategory}" var="ite">
	                                                        <li><a href='<c:url value="/the-loai/${ite.url}"></c:url>'>${ite.name}</a></li>
	                                                </c:forEach>	
	                                            </ul>
	                                        </li>
                                        </c:forEach>
                                        <li><a href="about-us.html">about</a></li>
                                        <li><a href="about-us.html">Contact</a></li>
                                        <li class="top-hover"><a href="#">blog <i class="ion-chevron-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="blog.html">Blog No sidebar</a></li>
                                                <li><a href="blog-rightsidebar.html">Blog sidebar</a></li>
                                                <li><a href="blog-details.html">Blog details</a></li>
                                                <li><a href="blog-details-gallery.html">Blog details gallery</a></li>
                                                <li><a href="blog-details-video.html">Blog details video</a></li>
                                            </ul>
                                        </li>
                                        <li>
                                        	<form id="searchForm" method="get" action='<c:url value="/tim-kiem/"></c:url>'>
                                        		<input name="s"   placeholder="Tìm kiếm" id="s">
                                        	</form>
                                        </li>                                       
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- mobile-menu-area-start -->
			<!-- 
			<div class="mobile-menu-area">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="mobile-menu">
								<nav id="mobile-menu-active">
									<ul class="menu-overflow" id="nav">
										<li><a href="index.html">Home</a>
											<ul>
												<li><a href="index.html">home version 1</a></li>
                                                <li><a href="index-2.html">home version 2</a></li>
											</ul>
										</li>
										<li><a href="#">pages</a>
											<ul>
												<li><a href="about-us.html">about us </a></li>
                                                <li><a href="shop.html">shop Grid</a></li>
                                                <li><a href="shop-list.html">shop list</a></li>
                                                <li><a href="product-details.html">product details</a></li>
                                                <li><a href="cart-page.html">cart page</a></li>
                                                <li><a href="checkout.html">checkout</a></li>
                                                <li><a href="wishlist.html">wishlist</a></li>
                                                <li><a href="my-account.html">my account</a></li>
                                                <li><a href="login-register.html">login / register</a></li>
                                                <li><a href="contact.html">contact</a></li>
                                                <li><a href="testimonial.html">Testimonials</a></li>
											</ul>
										</li>
										<li><a href="shop.html"> Shop </a>
                                            <ul>
                                                <li><a href="#">Categories 01</a>
                                                    <ul>
                                                        <li><a href="shop.html">salad</a></li>
                                                        <li><a href="shop.html">sandwich</a></li>
                                                        <li><a href="shop.html">bread</a></li>
                                                        <li><a href="shop.html">steak</a></li>
                                                        <li><a href="shop.html">tuna steak</a></li>
                                                        <li><a href="shop.html">spaghetti </a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Categories 02</a>
                                                    <ul>
                                                        <li><a href="shop.html">rice</a></li>
                                                        <li><a href="shop.html">pizza</a></li>
                                                        <li><a href="shop.html">hamburger</a></li>
                                                        <li><a href="shop.html">eggs</a></li>
                                                        <li><a href="shop.html">sausages</a></li>
                                                        <li><a href="shop.html">apple juice</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Categories 03</a>
                                                    <ul>
                                                        <li><a href="shop.html">milk</a></li>
                                                        <li><a href="shop.html">grape juice</a></li>
                                                        <li><a href="shop.html">cookie</a></li>
                                                        <li><a href="shop.html">candy</a></li>
                                                        <li><a href="shop.html">cake</a></li>
                                                        <li><a href="shop.html">cupcake</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Categories 04</a>
                                                    <ul>
                                                        <li><a href="shop.html">pie</a></li>
                                                        <li><a href="shop.html">stoberry</a></li>
                                                        <li><a href="shop.html">sandwich</a></li>
                                                        <li><a href="shop.html">bread</a></li>
                                                        <li><a href="shop.html">steak</a></li>
                                                        <li><a href="shop.html">hamburger</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </li>
										<li><a href="blog-rightsidebar.html">blog</a>
											<ul>
												<li><a href="blog.html">Blog No sidebar</a></li>
                                                <li><a href="blog-rightsidebar.html">Blog sidebar</a></li>
                                                <li><a href="blog-details.html">Blog details</a></li>
                                                <li><a href="blog-details-gallery.html">Blog details gallery</a></li>
                                                <li><a href="blog-details-video.html">Blog details video</a></li>
											</ul>
										</li>
										<li><a href="contact.html">contact us</a></li>
										<li><a href="shop.html">burger</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
			 -->
			<!-- mobile-menu-area-end -->
        </header>