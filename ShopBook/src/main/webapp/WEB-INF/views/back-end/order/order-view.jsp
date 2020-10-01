<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="right_col" role="main">
	<div class="">
			<div class="page-title">
				<div class="title_left">
					<h4>Chi tiết đơn hàng #${order.id} - <c:choose>
                    				<c:when test="${order.status == 3}"> Đang xử lý</c:when>
                    				<c:when test="${order.status == 2}"> Hoàn thành</c:when>
                    				<c:when test="${order.status == 1}"> Hủy đơn</c:when>
                    				<c:otherwise> Đang giao hàng</c:otherwise>
                    			 </c:choose></h4>
				</div>
				<div class="clearfix"></div>
			</div>
				<div class="clearfix"></div>
                      <table class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings text-center">
                            <th class="column-title">#</th>
                            <th class="column-title text-center">Tên Sản phẩm</th>
                            <th class="column-title">Tồn kho</th>
                            <th class="column-title">Đơn giá</th>
                            <th class="column-title">Số lượng</th>
                            <th class="column-title text-center">Thành tiền</th>
                            <th class="column-title no-link last text-center" colspan="3" ><span class="nobr">Xóa</span>
                            </th>
                          </tr>
                        </thead>

                        <tbody>
                          <c:forEach items="${order.listDetailDTOs}" var="item" varStatus="i"> 
                          	<tr>
                            <td>${pageInfo.offSet + i.index + 1} </td>
                            <td>${item.productInfoDTO.name}</td>
                            <td>10</td>
                        	<td><fmt:formatNumber value="${item.price}"  type="currency"/></td>
                        	<td>${item.quantity}</td>
                        	<td class="text-center"><fmt:formatNumber value="${item.totalPrice}"  type="currency"/></td>
                            <td colspan="3" class="last text-center">                                                    
	                            <a onclick="deleteItem(${item.id})" href="javascript:void(0)" title="Xóa item"><i style="color: red" class="glyphicon glyphicon-trash"></i></a>
                            </td>                  
                          	</tr>
                          </c:forEach>
							<tr>
	                            <td colspan="6" class="text-center">Tạm tính</td>
	                            <td class="text-center"> <span><fmt:formatNumber type="currency" value=" ${order.totalPrice}" /></span></td>
	                            <td colspan="3" class="last text-center"></td>                  
                          	</tr>
                          	<tr>
	                            <td colspan="6" class="text-center">Phí</td>
	                            <td class="text-center">
	                            	<span><fmt:formatNumber type="currency" value="0" /></span>
	                            </td>
	                            <td colspan="3" class="last text-center"></td>                  
                          	</tr>
                          	<tr>
	                            <td colspan="6" class="text-center">Thành tiền</td>
	                            <td class="text-center"> <span><fmt:formatNumber type="currency" value="${order.subTotal}" /></span></td>
	                            <td colspan="3" class="last text-center"></td>                  
                          	</tr>
                          	<tr >
	                            <td colspan="2"></td>
	                            <td colspan="4" class="text-center">
	                            	<a  href="javascript:void(0)" title="In hóa đơn" class="btn btn-success"><i class="glyphicon glyphicon-floppy-disk"> In Phiếu</i></a>	       	              
	                            </td>
	                         	<td>
	                         		<div class="dropdown">
										  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Chuyển trạng thái
										  <span class="caret"></span></button>
										  <ul class="dropdown-menu">										   
										    <li><a class="dropdown-item" onclick="updateStatus(${order.id},1)" href="javascript:void(0)">Hủy đơn</a></li>
										    <li><a class="dropdown-item" onclick="updateStatus(${order.id},2)" href="javascript:void(0)">Hoàn thành</a></li>
										    <li><a class="dropdown-item" onclick="updateStatus(${order.id},3)" href="javascript:void(0)">Đang xử lý</a></li>
										    <li><a class="dropdown-item" onclick="updateStatus(${order.id},4)" href="javascript:void(0)">Đang giao hàng</a></li>
										  </ul>
									</div>
	                         	</td>   	                         
	                            <td colspan="3" class="last text-center"></td>                  
                          	</tr>
                        </tbody>
                      </table>
     <jsp:include page="/WEB-INF/views/back-end/layout/paging.jsp"/>                      
	</div>
</div>

<script type="text/javascript">
	function gotoPage(page){
		$("#searchForm").attr('action',"<c:url value='/manage/order/list/'/>"+page);
		$("#searchForm").submit();
	}
	
	function deleteItem(id){
		var check = confirm("Bạn có thật sự muốn xóa");
		if(check){
			location.href="<c:url value='/manage/order/detail/delete/'/>"+id;
		}
	}
	function updateStatus(id,status){
		location.href="<c:url value='/manage/order/update-status/'/>"+id+"?status="+status;
	}
	
	$(document).ready(function(){
		var msgError = '${msgError}';
		var msgSuccess ='${msgSuccess}';
		if(msgError){
			new PNotify({
		        title: 'Thông Báo',
		        text: msgError,
		        type: 'error',
		        styling: 'bootstrap3'
		        
		    });	
		}
		if(msgSuccess){
			new PNotify({
		        title: 'Thông Báo',
		        text: msgSuccess,
		        type: 'success',
		        styling: 'bootstrap3'
		    });	
		}
	});
	
	$(document).ready(function(){
		$('#manageorderlistId').parents("li").addClass('active').siblings().removeClass("active");
		$('#manageorderlistId').addClass('current-page').siblings().removeClass("current-page");
		$('#manageorderlistId').parents().show();
	});
	
	
</script>



