<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="right_col" role="main">
	<div class="">
			<div class="page-title">
				<div class="title_left">
					<h4>Quản lý đơn hàng</h4>
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
									<form:form servletRelativeAction="/manage/order/list/1" method="POST" modelAttribute="searchForm" cssClass="form-horizontal form-label-left">
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="id">  Mã đơn <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input path="id" cssClass="form-control"/>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="status">  Trạng thái <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:select path="status" cssClass="form-control">
													<form:option value="0">---Chọn---</form:option>
													<form:option value="1">Hủy đơn</form:option>
													<form:option value="2">Hoàn thành</form:option>
													<form:option value="3">Đang xử lý</form:option>
													<form:option value="4">Đang giao hàng</form:option>
												</form:select>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="dateTo">  Ngày bắt đầu <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input type="date" path="dateTo" cssClass="form-control"/>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="dateFrom"> Ngày kết thúc <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input type="date" path="dateFrom" cssClass="form-control"/>
											</div>
										</div>
									
										<div class="ln_solid"></div>
										<div class="item form-group">
											<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
												<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-search"></i> Search</button>												
												<button class="btn btn-primary" type="reset"><i class="glyphicon glyphicon-refresh"></i> Reset</button>												
											</div>
										</div>

									</form:form>
								</div>
							</div>
						</div>
					</div>
		
	<div class="table-responsive">
	<a href='<c:url value="/manage/order/add"></c:url>'><button class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> Tạo hóa đơn </button></a>
	<a href='<c:url value="#"></c:url>'><button class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i> Xóa đơn </button></a>
	<a href='<c:url value="#"></c:url>'><button class="btn btn-default"><i style="color: red" class="glyphicon glyphicon-trash"></i> Lịch sử xóa </button></a>
                      <table class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                            <th class="column-title"><input type="checkbox" name="all"></th>
                            <th class="column-title">#</th>
                            <th class="column-title text-center">Mã đơn hàng</th>
                            <th class="column-title">Tình trạng</th>
                            <th class="column-title">Người nhận</th>
                            <th class="column-title">Địa chỉ giao hàng</th>
                            <th class="column-title">Điện thoại khách</th>                           
                            <th class="column-title">Tổng tiền</th>
                            <th class="column-title">Ngày mua</th>
                          </tr>
                        </thead>
                        <tbody>
                          <c:forEach items="${list}" var="item" varStatus="i"> 
                          	<tr>
                          	<td>
                          		<form:form	modelAttribute="deleteForm" action="POST" servletRelativeAction="#">
                          			<form:checkbox path="checkbox" value="${item.id}"/>
                          		</form:form>
                          	</td>
                            <td>${pageInfo.offSet + i.index + 1} </td>
                            <td class="text-center"><a href='<c:url value="/manage/order/view/${item.id}"></c:url>'>${item.id}</a></td>
                            <td >
                            	<p class="status-content">
									<c:choose>
										<c:when test="${item.status == 3}">
											Đang xử lý
										</c:when>
										<c:when test="${item.status == 1}">
											Đã hủy
										</c:when>
										<c:when test="${item.status == 2}">
											Hoàn thành
										</c:when>
										<c:otherwise> 
											Đang giao hàng
										</c:otherwise>
									</c:choose>
								</p>
                          	</td>                          	
                          	<td>${item.shipmentDetails.name}</td>
                          	<td>${item.shipmentDetails.province}</td>
                          	<td>${item.shipmentDetails.phone}</td>
                        	<td><fmt:formatNumber value="${item.subTotal}"  type="currency"/> </td>
                        	<td>${item.createDate}</td>                    
                          	</tr>
                          </c:forEach>
							
                        </tbody>
                      </table>
    	 	<jsp:include page="/WEB-INF/views/back-end/layout/paging.jsp"/>                      
      </div>

	</div>
</div>

<script type="text/javascript">
	function gotoPage(page){
		$("#searchForm").attr('action',"<c:url value='/manage/order/list/'/>"+page);
		$("#searchForm").submit();
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



