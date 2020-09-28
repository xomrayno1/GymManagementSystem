<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="cart-main-area  pb-100" style="margin-top: 40px;">
	<div class="container">
		<div class="row">
			<jsp:include page="/WEB-INF/views/front-end/layout/menu.jsp"></jsp:include>
			<div class="col-lg-10 col-md-10">
				<h3 class="page-title">Đơn hàng của tôi</h3>
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="order-review-wrapper">
							<div class="order-review">
								<div class="table-responsive">
									<table class="table">
										<form:form method="POST" modelAttribute="searchOrderForm" servletRelativeAction="/order/list/1">
											<thead>
												<tr>
													<th class="width-1"><form:input path="dateTo" type="date"/></th>
													<th class="width-2"><form:input path="dateFrom" type="date"/></th>
													<th class="width-3">
														<form:select path="status" cssClass="status">
															<form:option value="0">---Chọn---</form:option>	
															<form:option value="1">Đã hủy</form:option>	
															<form:option value="2">Hoàn thành</form:option>	
															<form:option value="3">Đang xử lý</form:option>	
														</form:select>
													</th>
													<th class="width-4"><button class="btn btn-primary"  type="submit">Lọc</button></th>
												</tr>
											</thead>
										</form:form>
										<thead>
											<tr>
												<th class="width-1">Mã đơn hàng</th>
												<th class="width-2">Ngày mua</th>
												<th class="width-4">Tổng tiền</th>
												<th class="width-4">Trạng thái đơn hàng</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${list}" var="item">
												<tr class="text-center">
													<td>
														<div class="o-pro-dec">
															<p>
																<a class="title-product"
																	href='<c:url value="#"></c:url>'>${item.id}</a>
															</p>
														</div>
													</td>
													<td>
														<div class="o-pro-price">
															<p>${item.createDate}</p>
														</div>
													</td>
													<td>
														<div class="o-pro-qty">
															<p>
																<fmt:formatNumber value="${item.subTotal}"
																	type="currency" />
															</p>
														</div>
													</td>
													<td>
														<div class="o-pro-subtotal">
															<p>
																<c:choose>
																	<c:when test="${item.status == 3}">
																		Đang xử lý
																	</c:when>
																	<c:when test="${item.status == 1}">
																		Đã hủy
																	</c:when>
																	<c:otherwise> 
																		Hoàn thành
																	</c:otherwise>
																</c:choose>
															</p>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<nav aria-label="Page navigation example"
										style="margin-top: 20px;">
										<ul class="pagination">
											<li class="page-item"><a class="page-link" href="#">Previous</a></li>
											<c:forEach begin="1" end="${pageInfo.totalPage}"
												varStatus="i">
												<c:choose>
													<c:when test="${pageInfo.pageIndex == i.index}">
														<li class="page-item active"><a class="page-link"
															href="javascript:void(0)">${i.index}</a></li>
													</c:when>
													<c:otherwise>
														<li class="page-item"><a class="page-link"
															onclick="gotoPage(${i.index})" href="javascript:void(0)">${i.index}</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<li class="page-item"><a class="page-link" href="#">Next</a></li>
										</ul>
									</nav>
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
		function gotoPage(page){
			$('#searchOrderForm').attr('action','<c:url value="/order/list/"/>'+page);
			$('#searchOrderForm').submit();
		}
	</script>
