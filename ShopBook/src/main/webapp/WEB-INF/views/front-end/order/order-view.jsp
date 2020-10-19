<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <div class="cart-main-area  pb-100" style="margin-top: 40px;">
            <div class="container">
                <div class="row">                 	
                   	<jsp:include page="/WEB-INF/views/front-end/layout/menu.jsp"></jsp:include>
                    <div class="col-sm-10">
                    		<h3 class="page-title">
                    			Chi tiết đơn hàng #${order.id} - <c:choose>
                    				<c:when test="${order.status == 3}"> Đang xử lý</c:when>
                    				<c:when test="${order.status == 2}"> Hoàn thành</c:when>
                    				<c:when test="${order.status == 1}"> Đã hủy</c:when>
                    				<c:otherwise> Đang giao hàng</c:otherwise>
                    			 </c:choose>
                   	 		</h3>
                   	 		<div class="row">
                   	 			<div class="col-lg-6 col-md-6 col-sm-6 col-6">
                   	 				<div class="title-address">
                   	 					<i >Địa chỉ người nhận</i>
                   	 				</div>	      
	                   	 			<div class="panel panel-default">	                   	 				
					                     <div class="panel-body">
					                       <div class="item">
					                       		<div class=".info">
						                       		<div class="name"><b>${order.shipmentDetails.name}</b></div>
						                       		<div class="address">
						                       			Địa chỉ :	<span> ${order.shipmentDetails.fullAddress()}</span>
						                       		</div> 
						                       		<div class="phone">
						                       			Điện thoại : 	<span> ${order.shipmentDetails.phone}</span>
						                       		</div> 
					                       		</div> 
					                       </div>        
					                    </div>
					                </div>
				                </div>
				              <div class="col-lg-6 col-md-6 col-sm-6 col-6">
                   	 				<div class="title-address">
                   	 					<i >Hình thức thanh toán</i>
                   	 				</div>	      
	                   	 			<div class="panel panel-default">	                   	 				
					                     <div class="panel-body">
					                       <div class="item">
					                       		<div class=".info">
						                       		Thanh toán tiền mặt khi nhận hàng
					                       		</div> 
					                       </div>        
					                    </div>
					                </div>
				                </div>
                   	 		</div>
                   	 		<div class="row">
			                    	<div class="col-lg-12 col-md-12 col-sm-12 col-12">	                        
			                            <div class="table-content table-responsive wishlist">
			                                <table>
			                                    <thead>
			                                        <tr>
			                                            <th>Hình ảnh</th>
			                                            <th>Tên sản phẩm</th>
			                                            <th>Giá </th>
			                                            <th>Số lượng</th>
			                                            <th>Tạm tính</th>
			                                            <th></th>                                            			                                          
			                                        </tr>
			                                    </thead>
			                                    <tbody>
			                                       <c:forEach items="${order.listDetailDTOs}" var="item">
				                                       	<tr>
				                                            <td class="product-thumbnail">
				                                                <a href="#"><img style="width: 70px" height="70px" src='<c:url value="${item.productInfoDTO.imgUrl}"></c:url>' alt=""></a>
				                                            </td>
				                                            <td class="product-name">
				                                            	<a href='<c:url value="/${item.productInfoDTO.url}"></c:url>'>${item.productInfoDTO.name}</a>
				                                            </td>
				                                            <td class="product-price-cart">
				                                            	<span class="amount"><fmt:formatNumber value="${item.productInfoDTO.price}"   type="currency" /></span>
				                                            </td>
				                                            <td class="product-price-cart">
				                                            	<span class="amount">${item.quantity}</span>
				                                            </td>
				                                            <td class="product-price-cart">
				                                            	<span class="amount"><fmt:formatNumber value="${item.totalPrice}"   type="currency" /></span>
				                                            </td>
				                                            <td class="product-price-cart">
				                                            	<c:choose>
				                                            		<c:when test="${order.status == 3}">
				                                            			<a onclick="deleteItem(${item.id})" href="javascript:void(0)" class="btn btn-danger" title="Xóa item">Xóa</a>
				                                            		</c:when>
				                                            		<c:when test="${order.status == 4}">
																		<i  class="fa fa-twitter"></i>
																	</c:when>
				                                            		<c:when test="${order.status == 1}">
																		<i class="fa fa-times"></i>
																	</c:when>
				                                            		<c:otherwise>
				                                            			<i class="fa fa-check-circle"></i>
				                                            		</c:otherwise>
				                                            	</c:choose>					                                            
				                                            </td>				                                            
				                                        </tr>                                       
			                                       </c:forEach>
			                                    </tbody>
			                                </table>
											<c:if test="${pageInfo != null}">
															 <nav aria-label="Page navigation example" style="margin-top: 20px;">
															  <ul class="pagination">
															    <li class="page-item">
															    	<c:choose>
															    		<c:when test="${pageInfo.pageIndex == 0}">
															    			<a class="page-link" href="javascript:void(0)">Previous</a>
															    		</c:when>
															    		<c:otherwise>
															    			<a class="page-link" href='<c:url value="/order/view/${order.id}?page=${pageInfo.pageIndex - 1}"></c:url>'>Previous</a>
															    		</c:otherwise>
															    	</c:choose>
															    </li>
															     <c:forEach begin="1" end="${pageInfo.totalPage}" varStatus="i">
																    	<c:choose>
																    		<c:when test="${pageInfo.pageIndex == i.index}">
																    			<li class="page-item active"><a class="page-link" href="javascript:void(0)">${i.index}</a></li>
																    		</c:when>
																    		<c:otherwise>
																    			<li class="page-item"><a class="page-link" href='<c:url value="/order/view/${order.id}?page=${i.index}"></c:url>'>${i.index}</a></li>
																    		</c:otherwise>
																    	</c:choose>
															    	</c:forEach>
															    <li class="page-item">
															   	 	<c:choose>
															   	 		<c:when test="${pageInfo.pageIndex == pageInfo.totalPage}">
															   	 			<a class="page-link" href="javascript:void(0)">Next</a>						   	 			
															   	 		</c:when>
															   	 		<c:otherwise>
															   	 			<a class="page-link" href='<c:url value="/order/view/${order.id}?page=${pageInfo.pageIndex + 1}"></c:url>'>Next</a>
															   	 		</c:otherwise>
															   	 	</c:choose>
															    </li>			    
															  </ul>
														</nav>
											</c:if>
			                            </div>
			                 <div class="row">
		                            <div class="col-lg-4 col-md-6">
		                            </div>
		                            <div class="col-lg-4 col-md-6">
		                            </div>
		                            <div class="col-lg-4 col-md-12">
		                                <div class="grand-totall">
		                                    <h5>Tạm tính <span><fmt:formatNumber type="currency" value="${order.totalPrice}" /></span></h5>
		                            	    <h5>Phí vận chuyển <span> 0 </span></h5>
		                            	    <h5>VAT <span> 0 </span></h5>
		                                    <h5>Tổng cộng <span><fmt:formatNumber type="currency" value="${order.subTotal}" /></span></h5>
		                                </div>
		                            </div>
		                        </div>
			               </div>
						</div>	               
                    </div>
                    
                </div>
            </div>
        </div>
        <script type="text/javascript">
	    	function deleteItem(id){
	    		var check = confirm("Bạn có thật sự muốn xóa sản phẩm này ?");
	    		if(check){
	    			location.href="<c:url value='/order/detail/delete/'/>"+id;
	    		}
	    	}
	    	$(document).ready(function(){
				$('#order').parent('li').addClass('select').siblings().removeClass('select');
			});
		</script>