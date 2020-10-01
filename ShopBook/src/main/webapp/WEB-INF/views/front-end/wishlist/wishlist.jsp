<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <div class="cart-main-area  pb-100" style="margin-top: 40px;">
            <div class="container">
                <div class="row">                 	
                   	<jsp:include page="/WEB-INF/views/front-end/layout/menu.jsp"></jsp:include>
                    <div class="col-sm-10">
                    		<h3 class="page-title">
                    			<c:choose>
                    				<c:when test="${pageInfo == null}">
	                   	 				Danh sách yêu thích (0)
                   	 				</c:when>
                   	 				<c:otherwise>
                   	 					Danh sách yêu thích (${pageInfo.totalProduct})
                   	 				</c:otherwise>
                    			</c:choose>
                   	 		</h3>
                   	 		<c:choose>
                   	 			<c:when test="${pageInfo == null}">
                   	 				<div class="alert alert-success">
                   	 					Danh sách yêu thích  đang trống.
                   	 				</div>	
                   	 			</c:when>
                   	 			<c:otherwise>
			                    	<div class="col-lg-12 col-md-12 col-sm-12 col-12">	                        
			                            <div class="table-content table-responsive wishlist">
			                                <table>
			                                    <thead>
			                                        <tr>
			                                            <th>Hình ảnh</th>
			                                            <th>Tên sản phẩm</th>
			                                            <th>Giá </th>                                            
			                                            <th>Add To Cart</th>
			                                            <th></th>
			                                        </tr>
			                                    </thead>
			                                    <tbody>
			                                       <c:forEach items="${list}" var="wishList">
				                                       	<tr>
				                                            <td class="product-thumbnail">
				                                                <a href="#"><img style="width: 70px" height="70px" src='<c:url value="${wishList.productInfoDTO.imgUrl}"></c:url>' alt=""></a>
				                                            </td>
				                                            <td class="product-name">
				                                            	<a href='<c:url value="/${wishList.productInfoDTO.url}"></c:url>'>${wishList.productInfoDTO.name}</a>
				                                            </td>
				                                            <td class="product-price-cart">
				                                            	<span class="amount"><fmt:formatNumber value="${wishList.productInfoDTO.price}"   type="currency" /></span>
				                                            </td>
				                                            <td class="product-wishlist-cart">
				                                                <a href='<c:url value="/cart/add-to-cart?id=${wishList.productInfoDTO.id}"></c:url>'>Add to cart</a>
				                                            </td>
				                                            <td class="product-wishlist-cart">
				                                                <a href='<c:url value="/account/wishlist/delete?id=${wishList.id}" ></c:url>' id="delete">Xóa</a>
				                                            </td>
				                                        </tr>                                       
			                                       </c:forEach>
			                                    </tbody>
			                                </table>
												 <nav aria-label="Page navigation example" style="margin-top: 20px;">
													  <ul class="pagination">
													  		<li class="page-item">
															    <c:choose>
															    	<c:when test="${pageInfo.pageIndex == 1}">
															    		<a class="page-link" href="javascript:void(0)">Previous</a>
															    	</c:when>
															    	<c:otherwise>
															    		<a class="page-link" href='<c:url value="/account/wishlist/?page=${pageInfo.pageIndex - 1}"></c:url>'>Previous</a>
															    	</c:otherwise>
															    </c:choose>
														    </li>
														     <c:forEach begin="1" end="${pageInfo.totalPage}" varStatus="i">
															    	<c:choose>
															    		<c:when test="${pageInfo.pageIndex == i.index}">
															    			<li class="page-item active"><a class="page-link" href="javascript:void(0)">${i.index}</a></li>
															    		</c:when>
															    		<c:otherwise>
															    			<li class="page-item"><a class="page-link" href='<c:url value="/account/wishlist/?page=${i.index}"></c:url>'>${i.index}</a></li>
															    		</c:otherwise>
															    	</c:choose>
														    	</c:forEach>
														    <li class="page-item">
															    <c:choose>													    
															    	<c:when test="${pageInfo.pageIndex == pageInfo.totalPage}">
															    		<a class="page-link" href="javascript:void(0)">Next</a>
															    	</c:when>
															    	<c:otherwise>
															    		<a class="page-link" href='<c:url value="/account/wishlist/?page=${pageInfo.pageIndex + 1}"></c:url>'>Next</a>
															    	</c:otherwise>
															    </c:choose>
														    </li>
													  </ul>
												</nav>
			                            </div>
			                      </div>
	                    		</c:otherwise>
                   	 		</c:choose>
                    </div>
                    
                </div>
            </div>
        </div>
        <script type="text/javascript">

		</script>