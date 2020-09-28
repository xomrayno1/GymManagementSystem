<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="cart-main-area  pb-100" style="margin-top: 40px;">
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="billing-information-wrapper">
							<div class="row">
								<div class="col-lg-6 col-md-6">
									<div class="billing-info">
										<label>Tên </label> <input type="text" value="${cartInfo.shipmentDetails.name}"
											readonly="readonly">
									</div>
								</div>
								<div class="col-lg-6 col-md-6">
									<div class="billing-info">
										<label>Số điện thoại</label> <input type="text"
											value="${cartInfo.shipmentDetails.phone}" readonly="readonly">
									</div>
								</div>
								<div class="col-lg-12 col-md-12">
									<div class="billing-info">
										<label>Tỉnh</label> <input type="text"
											value="${cartInfo.shipmentDetails.province}" readonly="readonly">
									</div>
								</div>
								<div class="col-lg-12 col-md-12">
									<div class="billing-info">
										<label>Huyện</label> <input type="text"
											value="${cartInfo.shipmentDetails.district}" readonly="readonly">
									</div>
								</div>
								<div class="col-lg-12 col-md-12">
									<div class="billing-info">
										<label>Xã</label> <input type="text"
											value="${cartInfo.shipmentDetails.commune}" readonly="readonly">
									</div>
								</div>
								<div class="col-lg-12 col-md-12">
									<div class="billing-info">
										<label>Chi tiết</label> <input type="text"
											value="${cartInfo.shipmentDetails.description}" readonly="readonly">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-8 col-md-8">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="order-review-wrapper">
							<div class="order-review">
								<div class="table-responsive">
									<table class="table">
										<thead>
											<tr>
												<th class="width-1">Product Name</th>
												<th class="width-2">Price</th>
												<th class="width-3">Qty</th>
												<th class="width-4">Subtotal</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${cartInfo.listDetailDTOs}" var="item">
												<tr>
													<td>
														<div class="o-pro-dec">
															<p>
																<a class="title-product"
																	href='<c:url value="/${item.productInfoDTO.url}"></c:url>'>${item.productInfoDTO.name}</a>
															</p>
														</div>
													</td>
													<td>
														<div class="o-pro-price">
															<p>
																<fmt:formatNumber value="${item.productInfoDTO.price}"
																	type="currency" />
															</p>
														</div>
													</td>
													<td>
														<div class="o-pro-qty">
															<p>${item.quantity}</p>
														</div>
													</td>
													<td>
														<div class="o-pro-subtotal">
															<p>
																<fmt:formatNumber value="${item.totalPrice}"
																	type="currency" />
															</p>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<td colspan="3">Subtotal</td>
												<td colspan="1"><fmt:formatNumber
														value="${cartInfo.totalPrice}" type="currency" /></td>
											</tr>
											<tr class="tr-f">
												<td colspan="3">Shipping & Handling (Flat Rate - Fixed</td>
												<td colspan="1">$0</td>
											</tr>
											<tr>
												<td colspan="3">Grand Total</td>
												<td colspan="1"><fmt:formatNumber
														value="${cartInfo.subTotal}" type="currency" /></td>
											</tr>
										</tfoot>
									</table>
								</div>
								<div class="billing-back-btn">
									<span> Forgot an Item? <a
										href='<c:url value="/cart/list"></c:url>'> Edit Your Cart.</a>
									</span>
									<div class="billing-btn">
										<button  onclick="order()">Đặt</button>
									</div>
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
	function order(){
		var check = confirm("Bạn có chắc chắn muốn đặt không");
		if(check){
			location.href="<c:url value='/checkout/order' />";
		}
	}
	</script>
