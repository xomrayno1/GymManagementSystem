<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
	 <div class="breadcrumb-area gray-bg">
            <div class="container">
                <div class="breadcrumb-content">
                    <ul>
                        <li><a href="index.html">Home</a></li>
                        <li class="active">Product Details </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="product-details pt-100 pb-90">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-12">
                        <div class="product-details-img">
                            <img class="zoompro" src='<c:url value="${product.imgUrl}"></c:url>' data-zoom-image="${product.imgUrl}" alt="zoom"/>
                            <span>-0%</span>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-12">
                        <div class="product-details-content">
                            <h4><a href="${product.url}">${product.name}</a></h4>
                            <div class="rating-review">
                                <div class="pro-dec-review">
                                    <ul>
                                        <li>32 Reviews </li>
                                        <li> Add Your Reviews</li>
                                    </ul>
                                </div>
                            </div>
                            <span><fmt:formatNumber value="${product.price}" type="currency"/></span>
                            <div class="in-stock">
                                <p>Available: <span>In stock</span></p>
                            </div>
                            <p class="title-product">${product.description}</p>
                            <br/>
                            <div class="pro-details-cart-wrap">
                                <div class="shop-list-cart-wishlist">
                                    <a title="Add To Cart" href="#">
                                        <i class="ion-android-cart"></i>
                                    </a>
                                    <a title="Wishlist" href="#">
                                        <i class="ion-ios-heart-outline"></i>
                                    </a>
                                </div>
                                <div class="product-quantity">
                                    <div class="cart-plus-minus">
                                        <input class="cart-plus-minus-box" type="text" name="qtybutton" value="2">
                                    </div>
                                </div>
                            </div>
                            <div class="pro-dec-social">
                                <ul>
                                    <li><a class="tweet" href="#"><i class="ion-social-twitter"></i> Tweet</a></li>
                                    <li><a class="share" href="#"><i class="ion-social-facebook"></i> Share</a></li>
                                    <li><a class="google" href="#"><i class="ion-social-googleplus-outline"></i> Google+</a></li>
                                    <li><a class="pinterest" href="#"><i class="ion-social-pinterest"></i> Pinterest</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

				     <div class="description-review-area pb-100">
			            <div class="container">
			                <div class="description-review-wrapper">
			                    <div class="description-review-topbar nav text-center">
			                        <a class="active" data-toggle="tab" href="#des-details1">Chi tiết sản phẩm</a>
			                        <a data-toggle="tab" href="#des-details3">Review</a>
			                    </div>
			                    <div class="tab-content description-review-bottom">
			                        <div id="des-details1" class="tab-pane active">
			                            <div class="product-description-wrapper">
			                                ${product.description}
			                              <hr>
			                              Thông tin chi tiết
			                           		<div class="table-responsive">
			                           			 <table class="table table-bordered">
					                            	<tbody>
					                            		<c:if test="${product.dateOfPublication != null}">
					                            			<tr>
						                            			<th>Ngày xuất bản</th>
						                            			<td>${product.dateOfPublication}</td>
					                            			</tr>
					                            		</c:if>
					                            		<c:if test="${product.publisherDTO.name != null}">
					                            			<tr>
						                            			<th>Nhà xuất bản</th>
						                            			<td>${product.publisherDTO.name}</td>
					                            			</tr>
					                            		</c:if>
					                            		<c:if test="${product.categoryDTO.name != null}">
					                            			<tr>
						                            			<th>Danh mục</th>
						                            			<td>${product.categoryDTO.name}</td>
					                            			</tr>
					                            		</c:if>
					                            		<c:if test="${product.authorDTO.name != null}">
					                            			<tr>
						                            			<th>Tác giả</th>
						                            			<td>${product.authorDTO.name}</td>
					                            			</tr>
					                            		</c:if>
					                            		<c:if test="${product.pageNumber != 0}">
					                            			<tr>
						                            			<th>Số trang</th>
						                            			<td>${product.pageNumber}</td>
					                            			</tr>
					                            		</c:if>
					                            		<c:if test="${product.pageNumber != null}">
					                            			<tr>
						                            			<th>Kích cỡ</th>
						                            			<td>${product.size}</td>
					                            			</tr>
					                            		</c:if>
					                            	</tbody>
				                              </table>
			                           		</div>  
			                              
			                            </div>
			                        </div>
			                        <div id="des-details3" class="tab-pane">
			                            <div class="rattings-wrapper">
			                                <div class="sin-rattings">
			                                    <div class="star-author-all">
			                                        <div class="ratting-star f-left">
			                                            <i class="ion-star theme-color"></i>
			                                            <i class="ion-star theme-color"></i>
			                                            <i class="ion-star theme-color"></i>
			                                            <i class="ion-star theme-color"></i>
			                                            <i class="ion-star theme-color"></i>
			                                            <span>(5)</span>
			                                        </div>
			                                        <div class="ratting-author f-right">
			                                            <h3>tayeb rayed</h3>
			                                            <span>12:24</span>
			                                            <span>9 March 2018</span>
			                                        </div>
			                                    </div>
			                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Utenim ad minim veniam, quis nost rud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Utenim ad minim veniam, quis nost.</p>
			                                </div>
			                                <div class="sin-rattings">
			                                    <div class="star-author-all">
			                                        <div class="ratting-star f-left">
			                                            <i class="ion-star theme-color"></i>
			                                            <i class="ion-star theme-color"></i>
			                                            <i class="ion-star theme-color"></i>
			                                            <i class="ion-star theme-color"></i>
			                                            <i class="ion-star theme-color"></i>
			                                            <span>(5)</span>
			                                        </div>
			                                        <div class="ratting-author f-right">
			                                            <h3>farhana shuvo</h3>
			                                            <span>12:24</span>
			                                            <span>9 March 2018</span>
			                                        </div>
			                                    </div>
			                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Utenim ad minim veniam, quis nost rud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Utenim ad minim veniam, quis nost.</p>
			                                </div>
			                            </div>
			                            <div class="ratting-form-wrapper">
			                                <h3>Add your Comments :</h3>
			                                <div class="ratting-form">
			                                    <form action="#">
			                                        <div class="star-box">
			                                            <h2>Rating:</h2>
			                                            <div class="ratting-star">
			                                                <i class="ion-star theme-color"></i>
			                                                <i class="ion-star theme-color"></i>
			                                                <i class="ion-star theme-color"></i>
			                                                <i class="ion-star theme-color"></i>
			                                                <i class="ion-star"></i>
			                                            </div>
			                                        </div>
			                                        <div class="row">
			                                            <div class="col-md-6">
			                                                <div class="rating-form-style mb-20">
			                                                    <input placeholder="Name" type="text">
			                                                </div>
			                                            </div>
			                                            <div class="col-md-6">
			                                                <div class="rating-form-style mb-20">
			                                                    <input placeholder="Email" type="text">
			                                                </div>
			                                            </div>
			                                            <div class="col-md-12">
			                                                <div class="rating-form-style form-submit">
			                                                    <textarea name="message" placeholder="Message"></textarea>
			                                                    <input type="submit" value="add review">
			                                                </div>
			                                            </div>
			                                        </div>
			                                    </form>
			                                </div>
			                            </div>
			                        </div>
			                    </div>
			                </div>
			            </div>
       			 </div>        
        <div class="product-area pb-95">
            <div class="container">
                <div class="product-top-bar section-border mb-25">
                    <div class="section-title-wrap">
                        <h3 class="section-title section-bg-white">Related Products</h3>
                    </div>
                </div>
                <div class="related-product-active owl-carousel product-nav">
                    <div class="product-wrapper">
                        <div class="product-img">
                            <a href="product-details.html">
                                <img src="assets/img/product/product-1.jpg" alt="">
                            </a>
                            <div class="product-action">
                                <div class="pro-action-left">
                                    <a title="Add Tto Cart" href="#"><i class="ion-android-cart"></i> Add Tto Cart</a>
                                </div>
                                <div class="pro-action-right">
                                    <a title="Wishlist" href="wishlist.html"><i class="ion-ios-heart-outline"></i></a>
                                    <a title="Quick View" data-toggle="modal" data-target="#exampleModal" href="#"><i class="ion-android-open"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="product-content">
                            <h4>
                                <a href="product-details.html">PRODUCTS NAME HERE </a>
                            </h4>
                            <div class="product-price-wrapper">
                                <span>$100.00</span>
                                <span class="product-price-old">$120.00 </span>
                            </div>
                        </div>
                    </div>
                    <div class="product-wrapper">
                        <div class="product-img">
                            <a href="product-details.html">
                                <img src="assets/img/product/product-2.jpg" alt="">
                            </a>
                            <div class="product-action">
                                <div class="pro-action-left">
                                    <a title="Add Tto Cart" href="#"><i class="ion-android-cart"></i> Add Tto Cart</a>
                                </div>
                                <div class="pro-action-right">
                                    <a title="Wishlist" href="wishlist.html"><i class="ion-ios-heart-outline"></i></a>
                                    <a title="Quick View" data-toggle="modal" data-target="#exampleModal" href="#"><i class="ion-android-open"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="product-content">
                            <h4>
                                <a href="product-details.html">PRODUCTS NAME HERE </a>
                            </h4>
                            <div class="product-price-wrapper">
                                <span>$200.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="product-wrapper">
                        <div class="product-img">
                            <a href="product-details.html">
                                <img src="assets/img/product/product-3.jpg" alt="">
                            </a>
                            <div class="product-action">
                                <div class="pro-action-left">
                                    <a title="Add Tto Cart" href="#"><i class="ion-android-cart"></i> Add Tto Cart</a>
                                </div>
                                <div class="pro-action-right">
                                    <a title="Wishlist" href="wishlist.html"><i class="ion-ios-heart-outline"></i></a>
                                    <a title="Quick View" data-toggle="modal" data-target="#exampleModal" href="#"><i class="ion-android-open"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="product-content">
                            <h4>
                                <a href="product-details.html">PRODUCTS NAME HERE </a>
                            </h4>
                            <div class="product-price-wrapper">
                                <span>$90.00</span>
                                <span class="product-price-old">$100.00 </span>
                            </div>
                        </div>
                    </div>
                    <div class="product-wrapper">
                        <div class="product-img">
                            <a href="product-details.html">
                                <img src='<c:url value="/resources/img/product/product-4.jpg"></c:url>' alt="">
                            </a>
                            <div class="product-action">
                                <div class="pro-action-left">
                                    <a title="Add Tto Cart" href="#"><i class="ion-android-cart"></i> Add Tto Cart</a>
                                </div>
                                <div class="pro-action-right">
                                    <a title="Wishlist" href="wishlist.html"><i class="ion-ios-heart-outline"></i></a>
                                    <a title="Quick View" data-toggle="modal" data-target="#exampleModal" href="#"><i class="ion-android-open"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="product-content">
                            <h4>
                                <a href="product-details.html">PRODUCTS NAME HERE </a>
                            </h4>
                            <div class="product-price-wrapper">
                                <span>$50.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="product-wrapper">
                        <div class="product-img">
                            <a href="product-details.html">
                                <img src="assets/img/product/product-7.jpg" alt="">
                            </a>
                            <div class="product-action">
                                <div class="pro-action-left">
                                    <a title="Add Tto Cart" href="#"><i class="ion-android-cart"></i> Add Tto Cart</a>
                                </div>
                                <div class="pro-action-right">
                                    <a title="Wishlist" href="wishlist.html"><i class="ion-ios-heart-outline"></i></a>
                                    <a title="Quick View" data-toggle="modal" data-target="#exampleModal" href="#"><i class="ion-android-open"></i></a>
                                </div>
                            </div>
                        </div>
                        <div class="product-content">
                            <h4>
                                <a href="product-details.html">PRODUCTS NAME HERE </a>
                            </h4>
                            <div class="product-price-wrapper">
                                <span>$100.00</span>
                                <span class="product-price-old">$120.00 </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
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
                                        <img src="assets/img/product-details/product-detalis-l1.jpg" alt="">
                                    </div>
                                    <div id="pro-2" class="tab-pane fade">
                                        <img src="assets/img/product-details/product-detalis-l2.jpg" alt="">
                                    </div>
                                    <div id="pro-3" class="tab-pane fade">
                                        <img src="assets/img/product-details/product-detalis-l3.jpg" alt="">
                                    </div>
                                    <div id="pro-4" class="tab-pane fade">
                                        <img src="assets/img/product-details/product-detalis-l4.jpg" alt="">
                                    </div>
                                </div>
                                <!-- Thumbnail Large Image End -->
                                <!-- Thumbnail Image End -->
                                <div class="product-thumbnail">
                                    <div class="thumb-menu owl-carousel nav nav-style" role="tablist">
                                        <a class="active" data-toggle="tab" href="#pro-1"><img src="assets/img/product-details/product-detalis-s1.jpg" alt=""></a>
                                        <a data-toggle="tab" href="#pro-2"><img src="assets/img/product-details/product-detalis-s2.jpg" alt=""></a>
                                        <a data-toggle="tab" href="#pro-3"><img src="assets/img/product-details/product-detalis-s3.jpg" alt=""></a>
                                        <a data-toggle="tab" href="#pro-4"><img src="assets/img/product-details/product-detalis-s4.jpg" alt=""></a>
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
                                            <input class="cart-plus-minus-box" type="text" name="qtybutton" value="2">
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
</div>