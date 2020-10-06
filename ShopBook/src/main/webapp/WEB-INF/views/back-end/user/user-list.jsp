<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="right_col" role="main">
	<div class="">
			<div class="page-title">
				<div class="title_left">
					<h4>Tài khoản</h4>
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
									<c:url value="/manage/user/list/1" var="searchUrl"></c:url>
									<form:form servletRelativeAction="${searchUrl}" method="POST" modelAttribute="searchForm" cssClass="form-horizontal form-label-left">
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="name"> Name <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input path="name" cssClass="form-control"/>
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
		<a href='<c:url value="/manage/user/add"></c:url>'><button class="btn btn-primary"><i class="glyphicon glyphicon-plus"></i>Thêm</button></a>
                      <table class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                            <th class="column-title">#</th>
                            <th class="column-title">Id</th>
                            <th class="column-title">Tên</th>
                            <th class="column-title">Email</th>
                            <th class="column-title">Phone</th>
                            <th class="column-title">Ngày sinh</th>
                            <th class="column-title no-link last text-center" colspan="3" ><span class="nobr">Action</span>
                            </th>
                          </tr>
                        </thead>

                        <tbody>
                          <c:forEach items="${list}" var="user" varStatus="i"> 
                          	<tr>
                            <td>${pageInfo.offSet + i.index + 1} </td>
                            <td>${user.id}</td>
                        	<td>${user.name}</td>
                        	<td>${user.email}</td>
                        	<td>${user.phone}</td> 
                        	<td>${user.birthDay}</td>                         	
                            <td colspan="3" class="last text-center">
	                            <a href='<c:url value="/manage/user/view/${user.id}"></c:url>' class="btn btn-primary"><i class="glyphicon glyphicon-eye-open"></i></a> 
	                           <c:if test="${user.idRole != 1}">
	                           		 <a href='<c:url value="/manage/user/edit/${user.id}"></c:url>' class="btn btn-warning"><i class="glyphicon glyphicon-edit"></i></a> 
	                           </c:if>
	                            <a href="javascript:void(0)"	onclick="deleteItem(${user.id})" class="btn btn-danger "><i class="glyphicon glyphicon-trash"></i></a>
	                            <a href="javascript:void(0)"		class="btn btn-success "	onclick="resetPassword(${user.id})" title="Reset mật khẩu"><i class="glyphicon glyphicon-refresh"></i></a>
                            </td>                  
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
		$("#searchForm").attr('action',"<c:url value='/manage/user/list/'/>"+page);
		$("#searchForm").submit();
	}
	function deleteItem(id){
		if(confirm("Bạn có chắc chắn muốn xóa tài khoản này không ")){
			location.href="<c:url value='/manage/user/delete/'/>"+id;
		}
	}
	function resetPassword(id){
		if(confirm("Bạn có chắc chắn muốn reset mật khẩu  tài khoản này không ")){
			location.href="<c:url value='/manage/user/reset-password/'/>"+id;
		}
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
		$('#manageuserlistId').parents("li").addClass('active').siblings().removeClass("active");
		$('#manageuserlistId').addClass('current-page').siblings().removeClass("current-page");
		$('#manageuserlistId').parents().show();
	});
	
</script>



