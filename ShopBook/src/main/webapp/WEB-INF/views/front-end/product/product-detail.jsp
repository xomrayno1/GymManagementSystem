<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                                <p>Available: 
                                	<span>                                		
                                		<c:choose>
                                			<c:when test="${product.productInStockDTO.quantity != 0 && product.productInStockDTO != null }">
                                				In stock
                                			</c:when>
                                			<c:otherwise>
                                				Out of stock
                                			</c:otherwise>
                                		</c:choose>
                                	</span>                                
                                </p>
                            </div>
                            <p class="title-product">${product.description}</p>
                            <br/>
                            <div class="pro-details-cart-wrap">
                                <div class="product-quantity">
                                    <div class="cart-plus-minus">
                                        <input class="cart-plus-minus-box" type="text" name="qty" id="qty"   value="1">
                                    </div>
                                </div>
                                <div class="shop-list-cart-wishlist">
                                	<input type="hidden" id="id" value="${product.id}">
                                   	<a title="Add to cart" id="add-cart" href="javascript:void(0)" onclick="addToCart(${product.id})">
                                   		<i class="ion-android-cart"></i>
                                   </a>
                                    <a title="Wishlist" href='<c:url value="/account/wishlist/add-to-wishlist?id=${product.id}"></c:url>'>
                                        <i class="ion-ios-heart-outline"></i>
                                    </a>
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

			                            <div class="ratting-form-wrapper">
			                                <h3>Add your Comments :</h3>
			                                <div class="ratting-form">
			                                    <form id="submitForm" action='<c:url value="/api/review/add"></c:url>' method="POST">
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
			                                            <c:if test="${userInfo == null}">
				                                            <div class="col-md-6">
				                                                <div class="rating-form-style mb-20">
				                                                    <input placeholder="name" type="text" id="name">
				                                                </div>
				                                            </div>
				                                            <div class="col-md-6">
				                                                <div class="rating-form-style mb-20">
				                                                    <input placeholder="email" type="text" id="email">
				                                                </div>
				                                            </div>
			                                            </c:if>
			                                            <div class="col-md-12">
			                                                <div class="rating-form-style form-submit">
			                                                	<input type="hidden" value="${product.id}" id="idProduct">
			                                                    <textarea name="content" placeholder="Message" id="content"></textarea>
			                                                    <input type="submit"  id="submit_btn" value="add review">
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
                                    <a title="Add Tto Cart" href="#"><i class="ion-android-cart"></i> Add to Cart</a>
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
</div>
	<script type="text/javascript">
	function addToCart(id){
		var value = $('#qty').val();
		location.href="<c:url value='/cart/add-to-cart?id='/>"+id+'&qty='+value;
	}
	$(document).ready(function(){
		loadReview();		
			$("#submitForm").submit(function(e) {
				var name = $('#name').val();
				var email = $('#email').val();
				var content = $('#content').val();
				var idProduct = $('#idProduct').val();
				var json = {'name' : name , 'email' : email , 'content' : content  , 'idProduct' : idProduct};
				$.ajax({
					url : $('#submitForm').attr('action'),
					data : JSON.stringify(json),
					type : 'POST',
					timeout : 100000,
					beforeSend : function(xhr){
						xhr.setRequestHeader('Accept','application/json');
						xhr.setRequestHeader('Content-Type','application/json');
					},
					success : function(data){
						console.log("ok");
						loadReview();
						$('#name').val("");
						$('#email').val("");
						$('#content').val("");
					},
					error : function(e){
						console.log("ERROR : ",e)
					}
				});
				event.preventDefault();
			});
		
	});
	function loadReview(){
		$.ajax({
			url: "/ShopBook/api/review/"+${product.id},
			success : function(data){
				for(var i = 0 ; i < data.length ; i++){
					var str =  '<div  class="rattings-wrapper">';
						str+=		'<div class="sin-rattings">'
						str+=			'<div class="star-author-all">'
						str+=				'<div class="ratting-star f-left">'
						str+=					'<i class="ion-star theme-color"></i>'
						str+=					'<i class="ion-star theme-color"></i>'
						str+=					'<i class="ion-star theme-color"></i>'
						str+=					'<i class="ion-star theme-color"></i>'
						str+=					'<i class="ion-star theme-color"></i>'
						str+=					'<span>(5)</span>'
						str+=				'</div>'
						str+=				'<div class="ratting-author f-right">'
						str+=					'<h3>'+data[i].name+'</h3>'
						str+=				'</div>'
						str+=			'</div>'
						str+=				'<p>'+data[i].content+'</p>'
						str+=		'</div>'
						str += '</div>'
					$("#des-details3").prepend(str);
				}				
			}
		});
	}
	</script>
<!-- 
			                    
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
	                        <div class="ratting-author f-right" id=title-review>
	                           
	                            	<h3>tayeb rayed</h3>
	                            	<span>12:24</span>
	                            	<span>9 March 2018</span>
	                      
	                        </div>
	                    </div>
	                    <div id="content-review">
	                    	
	                    </div>
                </div>
  		</div>
 -->