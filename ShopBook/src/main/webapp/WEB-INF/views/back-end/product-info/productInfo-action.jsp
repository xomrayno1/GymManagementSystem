<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
									<form:form servletRelativeAction="/manage/product-info/save" enctype="multipart/form-data" modelAttribute="submitForm" method="POST" cssClass="form-horizontal form-label-left">
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
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="ISBN">ISBN<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input path="ISBN" cssClass="form-control" readonly="${viewOnly}"/>
												<div class="has-error">
													<form:errors path="ISBN" cssClass="help-block"/>
												</div>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="price">Giá tiền<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input path="price" cssClass="form-control" readonly="${viewOnly}"/>
												<div class="has-error">
													<form:errors path="price" cssClass="help-block"/>
												</div>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="dateOfPublication">Ngày phát hành<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input type="date" path="dateOfPublication" cssClass="form-control" readonly="${viewOnly}"/>
												<div class="has-error">
													<form:errors path="dateOfPublication" cssClass="help-block"/>
												</div>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="size">Kích cỡ<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input path="size" cssClass="form-control" readonly="${viewOnly}"/>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="pageNumber">Số trang<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input path="pageNumber" cssClass="form-control" readonly="${viewOnly}"/>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="idCategory">Danh mục<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<c:choose>
													<c:when test="${!viewOnly }">
														<form:select path="idCategory" cssClass="form-control">
															<form:option value="0">--Chọn--</form:option>
															<form:options items="${categories}" />
														</form:select>
														<div class="has-error">
															<form:errors path="idCategory" cssClass="help-block"/>
														</div>
													</c:when>
													<c:otherwise>
														<input type="text"  class="form-control" value="${submitForm.categoryDTO.name}" readonly="readonly">
													</c:otherwise>
												</c:choose>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="idAuthor">Tác giả<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<c:choose>
													<c:when test="${!viewOnly }">
														<form:select path="idAuthor" cssClass="form-control">
															<form:option value="0">--Chọn--</form:option>
															<form:options items="${authors}" />
														</form:select>
														<div class="has-error">
															<form:errors path="idAuthor" cssClass="help-block"/>
														</div>
													</c:when>
													<c:otherwise>
														<input type="text"  class="form-control" value="${submitForm.authorDTO.name}" readonly="readonly">
													</c:otherwise>
												</c:choose>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="idPublisher">Nhà xuất bản<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<c:choose>
													<c:when test="${!viewOnly }">
														<form:select path="idPublisher" cssClass="form-control">
															<form:option value="0">--Chọn--</form:option>
															<form:options items="${publisher}" />
														</form:select>
														<div class="has-error">
															<form:errors path="idPublisher" cssClass="help-block"/>
														</div>
													</c:when>
													<c:otherwise>
														<input type="text"  class="form-control" value="${submitForm.publisherDTO.name}" readonly="readonly">
													</c:otherwise>
												</c:choose>												
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-3 col-sm-3 label-align" for="description">Chi tiết<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">												
												<form:textarea path="description"  cols="10" rows="5" cssClass="form-control" readonly="${viewOnly}"/>
											</div>
										</div>
										<div class="ln_solid"></div>
											<div class="item form-group">
												<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
												<c:if test="${!viewOnly}">
													<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-ok-circle"></i> Submit</button>
													<button class="btn btn-primary" type="reset"><i class="glyphicon glyphicon-refresh"></i> Reset</button>	
												</c:if>			
												<a href='<c:url value="/manage/product-info/list/1"></c:url>'><button class="btn btn-primary" type="button"><i class="glyphicon glyphicon-minus-sign"></i> Cancel</button></a>																					
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
			$('#manageproduct-infolistId').addClass('current-page').siblings().removeClass("current-page");
			$("#manageproduct-infolistId").parents("li").addClass("active").siblings().removeClass("active");
			$("#manageproduct-infolistId").parents().show();
			
		});	
	</script>