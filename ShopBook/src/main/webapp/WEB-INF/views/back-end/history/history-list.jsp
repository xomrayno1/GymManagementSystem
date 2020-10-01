<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="right_col" role="main">
	<div class="">
			<div class="page-title">
				<div class="title_left">
					<h4> Lịch sử nhập xuất kho </h4>
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
									<c:url value="/manage/history/list/1" var="searchUrl"></c:url>
									<form:form servletRelativeAction="${searchUrl}" method="POST" modelAttribute="searchForm" cssClass="form-horizontal form-label-left">
										
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="dateTo">Kiểu  <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:select path="type" cssClass="form-control">
													<form:option value="0">---Chọn---</form:option>
													<form:option value="1">Nhập</form:option>
													<form:option value="2">Xuất</form:option>
												</form:select>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="dateTo">Từ  <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input  type="date" path="dateTo" cssClass="form-control"/>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="dateFrom">Đến <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input  type="date" path="dateFrom" cssClass="form-control"/>
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
                      <table class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                            <th class="column-title">#</th>
                            <th class="column-title">Id</th>
                            <th class="column-title">Action Name</th>
                            <th class="column-title">Tên sản phẩm</th>
                            <th class="column-title">Đơn giá</th>
                            <th class="column-title">Số lượng</th>
                            <th class="column-title">Thành tiền</th>
                            <th class="column-title">Người nhập</th>
                            <th class="column-title">Ngày</th>                        
                          </tr>
                        </thead>

                        <tbody>
                          <c:forEach items="${list}" var="item" varStatus="i"> 
                          	<tr>
                            <td>${pageInfo.offSet + i.index + 1} </td>
                            <td>${item.id}</td>
                            <td>${item.actionName}</td>
                        	<td>${item.productInfoDTO.name}</td>
                        	<td>${item.price}</td>
                        	<td>${item.quantity}</td> 
                        	<td>${item.totalPrice}</td>
                        	<td>${item.userDTO.name}</td>  
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
		$("#searchForm").attr('action',"<c:url value='/manage/history/list/'/>"+page);
		$("#searchForm").submit();
	}
	
	
	$(document).ready(function(){
		$('#managehistorylistId').parents("li").addClass('active').siblings().removeClass("active");
		$('#managehistorylistId').addClass('current-page').siblings().removeClass("current-page");
		$('#managehistorylistId').parents().show();
	});
	
	
</script>





