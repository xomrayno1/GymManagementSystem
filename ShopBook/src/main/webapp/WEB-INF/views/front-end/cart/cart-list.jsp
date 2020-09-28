<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <div class="cart-main-area pt-95 pb-100">
            <div class="container">
                <h3 class="page-title">
                	<c:choose>
	                	<c:when test="${cartInfo!=null}">
	                		<span>Giỏ hàng(${cartInfo.listDetailDTOs.size()})</span>
	                	</c:when>
	                	<c:otherwise>
	                		<span>Giỏ hàng(0)</span>
	                	</c:otherwise>
                	</c:choose>
				</h3>
                <c:choose>
                	<c:when test="${cartInfo.listDetailDTOs.size() == 0 || cartInfo == null}">
                		<div class="alert alert-info">
                			Không có sản phẩm nào trong giỏ hàng.
                		</div>	
                	</c:when>
                	<c:otherwise>
		                <div class="row">
		                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
		                            <div class="table-content table-responsive">
		                                <table>
		                                    <thead>
		                                        <tr>
		                                            <th>Image</th>
		                                            <th>Product Name</th>
		                                            <th>Until Price</th>
		                                            <th>Qty</th>
		                                            <th>Subtotal</th>
		                                            <th>action</th>
		                                        </tr>
		                                    </thead>
		                                    <tbody>
		                                        <c:forEach items="${cartInfo.listDetailDTOs}" var="item">
			                                        <tr>
			                                            <td class="product-thumbnail">
			                                                <a href="#"><img style="width: 70px; height: 70px;" src='<c:url value="${item.productInfoDTO.imgUrl}" ></c:url>' alt=""></a>
			                                            </td>
			                                            <td class="product-name"><a href='<c:url value="/${item.productInfoDTO.url}"></c:url>'>${item.productInfoDTO.name} </a></td>
			                                            <td class="product-price-cart">
			                                            	<span class="amount"><fmt:formatNumber value="${item.productInfoDTO.price}"  type="currency"/> </span>
			                                            </td>	
			                                            <td class="product-quantity">
			                                                <div class="cart-plus-minus">		                                                
			                                                    <input class="cart-plus-minus-box" id="qty" type="text" name="qty"  value="${item.quantity}">
			                                                </div>
			                                            </td>
			                                            <td class="product-subtotal"><fmt:formatNumber value="${item.totalPrice}" type="currency" /> </td>
			                                            <td class="product-remove">
			                                            	<input value="${item.productInfoDTO.id}" type="hidden" id="id">
			                                               	<a title="Cập nhật"  class="btnUpdate"   href="javascript:void(0)"><i class="fa fa-pencil"></i></a>
			                                               	<a href='<c:url value="/cart/delete?id=${item.productInfoDTO.id}"></c:url>' title="Xóa"><i class="fa fa-times"></i></a>
			                                           </td>
			                                        </tr>
		                                        </c:forEach>
		                                    </tbody>
		                                </table>
		                            </div>
		                            <div class="row">
		                                <div class="col-lg-12">
		                                    <div class="cart-shiping-update-wrapper">
		                                        <div class="cart-shiping-update">
		                                            <a href="#">Continue Shopping</a>
		                                        </div>
		                                        <div class="cart-clear">
		                                            <button>Update Shopping Cart</button>
		                                            <a href='<c:url value="/cart/clear"></c:url>'>Clear Shopping Cart</a>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                        <div class="row">
		                            <div class="col-lg-4 col-md-6">
		                                <div class="cart-tax">
		                                    <div class="title-wrap">
		                                        <h4 class="cart-bottom-title section-bg-gray">Estimate Shipping And Tax</h4>
		                                    </div>
		                                    <div class="tax-wrapper">
		                                        <p>Enter your destination to get a shipping estimate.</p>
		                                        <div class="tax-select-wrapper">
		                                            <div class="tax-select">
		                                                <label>
		                                                    * Country
		                                                </label>
		                                                <select class="email s-email s-wid">
		                                                    <option>Bangladesh</option>
		                                                    <option>Albania</option>
		                                                    <option>Åland Islands</option>
		                                                    <option>Afghanistan</option>
		                                                    <option>Belgium</option>
		                                                </select>
		                                            </div>
		                                            <div class="tax-select">
		                                                <label>
		                                                    * Region / State
		                                                </label>
		                                                <select class="email s-email s-wid">
		                                                    <option>Bangladesh</option>
		                                                    <option>Albania</option>
		                                                    <option>Åland Islands</option>
		                                                    <option>Afghanistan</option>
		                                                    <option>Belgium</option>
		                                                </select>
		                                            </div>
		                                            <div class="tax-select">
		                                                <label>
		                                                    * Zip/Postal Code
		                                                </label>
		                                                <input type="text">
		                                            </div>
		                                            <button class="cart-btn-2" type="submit">Get A Quote</button>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                            <div class="col-lg-4 col-md-6">
		                                <div class="discount-code-wrapper">
		                                    <div class="title-wrap">
		                                       <h4 class="cart-bottom-title section-bg-gray">Use Coupon Code</h4> 
		                                    </div>
		                                    <div class="discount-code">
		                                        <p>Enter your coupon code if you have one.</p>
		                                        <form>
		                                            <input type="text" required="required" name="name">
		                                            <button class="cart-btn-2" type="submit">Apply Coupon</button>
		                                        </form>
		                                    </div>
		                                </div>
		                            </div>
		                            <div class="col-lg-4 col-md-12">
		                                <div class="grand-totall">
		                                    <div class="title-wrap">
		                                        <h4 class="cart-bottom-title section-bg-gary-cart">Cart Total</h4>
		                                    </div>
		                                    <h5>Total products <span><fmt:formatNumber type="currency" value="${cartInfo.totalPrice}" /></span></h5>
		                                    <div class="total-shipping">
		                                        <h5>Total shipping</h5>
		                                        <ul>
		                                            <li><input type="checkbox"> Standard <span>$20.00</span></li>
		                                            <li><input type="checkbox"> Express <span>$30.00</span></li>
		                                        </ul>
		                                    </div>
		                                    <h4 class="grand-totall-title">Grand Total  <span><fmt:formatNumber type="currency" value="${cartInfo.subTotal}" /> </span></h4>
		                                    <a href='<c:url value="/checkout/shipping"></c:url>'>Tiến hành đặt hàng</a>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
                	</c:otherwise>
                </c:choose>
            </div>
        </div>
        <script type="text/javascript">
			var btnUpdate = document.getElementsByClassName('btnUpdate');
			for(var i = 0 ; i < btnUpdate.length ; i++){
				btnUpdate[i].addEventListener('click',function(){
					var id = $(this).parent('td').find('#id').val();
					var qty = $(this).parents('tr').find('#qty').val();
					location.href="<c:url value='/cart/update?id="+id+"&qty="+qty+" '/>";
				});
			}
		</script>