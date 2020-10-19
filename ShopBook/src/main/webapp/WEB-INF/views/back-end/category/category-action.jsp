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
									<form:form servletRelativeAction="/manage/category/save" enctype="multipart/form-data" modelAttribute="submitForm" method="POST" cssClass="form-horizontal form-label-left">
										<form:hidden path="id"/>
										<form:hidden path="activeFlag"/>
										<form:hidden path="createDate"/>
										<form:hidden path="updateDate"/>
										<form:hidden path="imgUrl"/>
										<form:hidden path="url"/>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="name">Name<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">												
												<form:input path="name" cssClass="form-control" readonly="${viewOnly}"/>
												<div class="has-error">
													<form:errors path="name" cssClass="help-block"/>
												</div>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="code">Code<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input path="code" cssClass="form-control" readonly="${viewOnly}"/>
												<div class="has-error">
													<form:errors path="code" cssClass="help-block"/>
												</div>
											</div>
										</div>
										<c:if test="${!viewOnly }">
											<div class="item form-group">
												<label class="col-form-label col-md-3 col-sm-3 label-align" for="upload">Upload<span class="required">*</span>
												</label>
												<div class="col-md-6 col-sm-6 ">
													<form:input type="file" path="multipartFile" cssClass="form-control" readonly="${viewOnly}"/>
													<div class="has-error">
														<form:errors path="multipartFile" cssClass="help-block"/>
													</div>
												</div>
											</div>
										</c:if>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="upload">Danh Muc Cha<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<c:choose>
													<c:when test="${!viewOnly }">
														<form:select path="idParent" cssClass="form-control">
															<form:option value="0">--Chọn--</form:option>
															<form:options items="${categories}" />
														</form:select>
													</c:when>
													<c:otherwise>
														<c:forEach items="${categories}" var="entry">
															<c:if test="${entry.key == submitForm.idParent }">
																<input value="${entry.value}" type="text"  readonly="readonly" class="form-control">
															</c:if>
														</c:forEach>
													</c:otherwise>
												</c:choose>
											</div>
										</div>
									
										<div class="ln_solid"></div>
											<div class="item form-group">
												<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
												<c:if test="${!viewOnly}">
													<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-ok-circle"></i> Submit</button>
													<button class="btn btn-primary" type="reset"><i class="glyphicon glyphicon-refresh"></i> Reset</button>	
												</c:if>			
												<a href='<c:url value="/manage/category/list/1"></c:url>'><button class="btn btn-primary" type="button"><i class="glyphicon glyphicon-minus-sign"></i> Cancel</button></a>																					
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
			$('#managecategorylistId').addClass('current-page').siblings().removeClass("current-page");
			$("#managecategorylistId").parents("li").addClass("active").siblings().removeClass("active");
			$("#managecategorylistId").parents().show();
			
		});	
	</script>