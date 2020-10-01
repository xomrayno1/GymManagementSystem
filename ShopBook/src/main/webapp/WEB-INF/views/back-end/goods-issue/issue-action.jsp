<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
	<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>${title}</h3>
						</div>
					</div>
		<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 ">
							<div class="x_panel">
								<div class="x_content">
									<br />
									<form:form servletRelativeAction="/manage/goods-issue/save"  modelAttribute="submitForm" method="POST" cssClass="form-horizontal form-label-left">
										<form:hidden path="id"/>
										<form:hidden path="activeFlag"/>
										<form:hidden path="createDate"/>
										<form:hidden path="updateDate"/>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="name">Chọn sản phẩm<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">												
												<form:select path="idProduct" cssClass="form-control">
													<c:forEach items="${listProduct}" var="product">
														<form:option value="${product.id}">${product.name}</form:option>
													</c:forEach>	
												</form:select>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="price">Đơn giá<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input path="price" cssClass="form-control" readonly="${viewOnly}"/>
												<div class="has-error">
													<form:errors path="price" cssClass="help-block"/>
												</div>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="quantity">Số lượng<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input path="quantity" cssClass="form-control" readonly="${viewOnly}"/>
												<div class="has-error">
													<form:errors path="quantity" cssClass="help-block"/>
												</div>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="totalPrice">Thành tiền<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input path="totalPrice" cssClass="form-control" readonly="${viewOnly}"/>
												<div class="has-error">
													<form:errors path="totalPrice" cssClass="help-block"/>
												</div>
											</div>
										</div>
									
										<div class="ln_solid"></div>
											<div class="item form-group">
												<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
												<c:if test="${!viewOnly}">
													<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-ok-circle"></i> Submit</button>
													<button class="btn btn-primary" type="reset"><i class="glyphicon glyphicon-refresh"></i> Reset</button>	
												</c:if>			
												<a href='<c:url value="/manage/goods-issue/list/1"></c:url>'><button class="btn btn-primary" type="button"><i class="glyphicon glyphicon-minus-sign"></i> Cancel</button></a>																					
												</div>
											</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#managegoods-issuelistId').addClass('current-page').siblings().removeClass("current-page");
			$("#managegoods-issuelistId").parents("li").addClass("active").siblings().removeClass("active");
			$("#managegoods-issuelistId").parents().show();
			
		});	
	</script>