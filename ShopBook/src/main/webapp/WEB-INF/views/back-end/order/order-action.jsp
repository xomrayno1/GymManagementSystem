<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="right_col" role="main">
<form method="POST"	action='<c:url value="/api/manage/order/save"></c:url>'	class="form-horizontal form-label-left" id="formOrder">
	<div class="">
			
			<div class="page-title">
				<div class="title_left">
					<h4>Tạo đơn</h4>
				</div>
				<div class="clearfix"></div>
			</div>
				<div class="clearfix"></div>
			<div class="clearfix"></div>
					<div class="row">

						<div class="col-md-12 col-sm-12 ">
							<div class="x_panel">
								<div class="x_content">
									<br />									
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="name"> Tên <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">	
												<input name="name" class="form-control" placeHolder=" Tên khách hàng" id="name">
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="address"> Địa chỉ<span class="required">*</span>
											</label>	
											<div class="col-md-3 col-sm-3 ">
												<input name="province" class="form-control" placeHolder=" Tên Tỉnh" id="province">
											</div>
											<div class="col-md-3 col-sm-3 ">
												<input name="district" class="form-control" placeHolder=" Tên Huyện" id="district">
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="address"> <span class="required"></span>
											</label>	
											<div class="col-md-3 col-sm-3 ">
												<input name="commune" class="form-control" placeHolder=" Tên xã" id="commune">
											</div>
											<div class="col-md-3 col-sm-3 ">
												<input name="description" class="form-control" placeHolder=" Chi tiết" id="description">
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="phone"> Số điện thọai <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input name="phone" class="form-control" placeHolder=" Số điện thọai" id="phone">
											</div>
										</div>
										<div class="ln_solid"></div>
									
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 col-sm-12 ">
							<div class="x_panel">
								<div class="x_content">
									<div id="product-form">
										<div class="item form-group item-product product" >	
											<div class="col-md-4 col-sm-4 ">
												<select name="idProduct" id="idProduct"  class="form-control	idProduct" >
														<option value="0">-----Select-----</option>
													<c:forEach items="${listProduct}" var="item" >
														<option value="${item.id}">${item.name}</option>
													</c:forEach>
												</select>
											</div>											
											<div class="col-md-2 col-sm-2 ">
												<input name="price" class="form-control prices"  placeHolder=" Đơn giá"  id="prices" readonly="readonly">
											</div>
											<div class="col-md-1 col-sm-1 ">									
												<input name="quantity"	 class="form-control	quantity"  placeHolder=" Số lượng"   id="quantity" >
											</div>
											<div class="col-md-2 col-sm-2 ">
												<input name="totalPrice" class="form-control	totalPrice"   placeHolder=" Thành tiền" id="totalPrice" readonly="readonly">
											</div>
											<div class="col-md-1 col-sm-1 ">
												<a  class="btn btn-danger remove" href="javascript:void(0)"><i class="glyphicon glyphicon-trash"></i></a>
											</div>
										</div>
									</div>		
								</div>
							</div>
						</div>
					</div>
				<div class="row">
						<div class="col-md-12 col-sm-12 ">
							<div class="x_panel">
								<div class="x_content">
									<br />									
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="name"> Tạm tính <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input name="totalpriceOrder" class="form-control"  placeHolder=" Tạm tính" id="totalpriceOrder" readonly="readonly">
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="name"> Sales (%) <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input name="sales" class="form-control"  placeHolder=" Sales" id="sales">
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="name"	> Thành tiền <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<input name="subpriceOrder"  class="form-control"  placeHolder=" Thành tiền" id="subpriceOrder"	readonly="readonly">
											</div>
										</div>
										<div class="ln_solid"></div>
										<div class="item form-group">
											<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
												<a onclick="addRow()" href="javascript:void(0)" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> Add Row</a>
												<a href="javascript:void(0)" type="submit" id="btn-save" class="btn btn-success"><i class="glyphicon glyphicon-search"></i> Tạo Đơn hàng</a>				
												<button class="btn btn-primary" type="reset"><i class="glyphicon glyphicon-refresh"></i> Reset</button>												
											</div>
										</div>				
								</div>
							</div>
						</div>
					</div>		
		</div>
	</form>
</div>
<script type="text/javascript">
/*	
$('#addMore').on('click', function() {
    var data = $("#tb tr:eq(1)").clone(true).appendTo("#tb");
    data.find("input").val('');
});
*/
	function addRow(){
		var newProduct = $(".product").clone();
		newProduct.removeClass('product');
		$("#product-form").append(newProduct);
		newProduct.find('input').val('');
		bind();
	}
	$(document).on('click','.remove',function(){
		var trIndex = $(this).closest('div .item-product').index();
		if(trIndex  > 0){
			$(this).closest('div .item-product').remove();
			update_subPrice();
		}else{
			alert(" Sorry , Can't  remove first row");
		}
		
	});

	$(document).ready(function(){
		createOrder();
		
		$(document).on('change','.idProduct',function(){
			var id = $(this).val();
			var row = $(this).closest('.item-product');
			$.ajax({
				url : '/ShopBook/api/product/price/'+id,
				success : function(data){
					row.find('#prices').val(data);
					//$('.idProduct').change(update_totalPrice);
				}
			});
		});
		
		bind();
	});
	function createOrder(){
		$('#btn-save').click(function(e){
			var shipment = {
					'name' : $("#name").val(),
					'province' : $("#province").val(),
					'district' : $("#district").val(),
					'commune' : $("#commune").val(),
					'description' : $("#description").val(),
					'phone' : $('#phone').val()
			}
			var items = [];
			$.each($('.item-product'),function(){				
				var object = {
						'quantity' : $(this).find('#quantity').val(),
						'price' : $(this).find('#prices').val(),
						'totalPrice' : $(this).find('#totalPrice').val(),
						'idProduct' : $(this).find('#idProduct').val()						
				}
				items.push(object);
			});
			var totalPrice = $('#totalpriceOrder').val();
			var subTotal = $('#subpriceOrder').val();
			var sales = $('#sales').val();
			var order =  {
					'shipmentDetails': shipment ,
					'totalPrice' :	totalPrice ,
					'sales' : sales,
					'subTotal' : subTotal,
					'listDetailDTOs': items
			}
			addOrder(order);
			console.log(order);
		});
	}
	function clear(){
		$("#name").val("");
		$("#province").val("");
		$("#district").val("");
		$("#commune").val("");
		$("#description").val("");
		$('#phone').val("");
		$('#quantity').val("");
		$('.prices').each(function(){
			$(this).val("");
		});
		$('.quantity').each(function(){
			$(this).val("");
		});
		$('.idProduct').each(function(){
			$(this).val(0);
		});
		$('.totalPrice').each(function(){
			$(this).val("");
		});		
		$('#totalpriceOrder').val("");
		$('#subpriceOrder').val("");
		$('#sales').val("");
	}
	function bind(){
		$('.quantity').change(update_totalPrice); // dinh blur nhung ko nhan - nen change v		
		$('#sales').change(update_subPrice);
	}
	function addOrder(order){
		$.ajax({
			url : '/ShopBook/api/order/save',
			type : 'POST',
			data : JSON.stringify(order),
			timeout : 100000,
			beforeSend : function(xhr){
				xhr.setRequestHeader('Accept','application/json');
				xhr.setRequestHeader('Content-Type','application/json');
			},
			success : function(data){
				
				alert("Thêm đơn thành công");
				clear();
			}
		});
	}
	function update_totalPrice(){
		console.log("change");
		var row = $(this).closest(".item-product");
		var qty = row.find('#quantity').val();
		console.log(qty);
		var price = row.find('#prices').val();
		console.log(price);
		row.find('#totalPrice').val(Number(price) * Number(qty));
		update_subPrice();
	}
	function update_subPrice(){
		var total = 0 ;
		$('.totalPrice').each(function(){
			total += Number($(this).val());
		});
		$('#totalpriceOrder').val(total);
		var sales = $('#sales').val();
		var value = (total / 100) * sales;
		$('#subpriceOrder').val(Number(total) - value);
	}
	//totalpriceOrder
	$(document).ready(function(){
		$('#manageorderaddId').parents("li").addClass('active').siblings().removeClass("active");
		$('#manageorderaddId').addClass('current-page').siblings().removeClass("current-page");
		$('#manageorderaddId').parents().show();
	});

</script>



