<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <div class="cart-main-area  pb-100" style="margin-top: 40px;">
            <div class="container">
                <div class="row">                 	
                   	<jsp:include page="/WEB-INF/views/front-end/layout/menu.jsp"></jsp:include>
                    <div class="col-sm-10 col-md-10">
                   	 		<h3 class="page-title">Đổi mật khẩu</h3>
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                            <div class="billing-information-wrapper">	
	                                            <form:form 	method="POST" modelAttribute="submitForm" servletRelativeAction="/account/password/save">
	                                                <form:hidden path="idUser"/>
	                                                <div class="row">
	                                                	 <div class="col-lg-12 col-md-12">
	                                                        <div class="billing-info">
	                                                            <label>Mật khẩu</label>
	                                                            <form:password path="oldPassword"/>
	                                                            <div class="has-error">
	                                                            	<form:errors  path="oldPassword" cssClass="help-block"/>
	                                                            </div>
	                                                        </div>
	                                                    </div>
	                                                	<div class="col-lg-12 col-md-12">
	                                                        <div class="billing-info">
	                                                            <label>Mật khẩu</label>
	                                                            <form:password path="newPassword"/>
	                                                            <div class="has-error">
	                                                            	<form:errors  path="newPassword" cssClass="help-block"/>
	                                                            </div>
	                                                        </div>
	                                                    </div>
	                                                    <div class="col-lg-12 col-md-12">
	                                                        <div class="billing-info">
	                                                            <label>Nhập lại mật khẩu</label>
	                                                            <form:password path="repeatPassword"/>
	                                                            <div class="has-error">
	                                                            	<form:errors  path="repeatPassword" cssClass="help-block"/>
	                                                            </div>
	                                                        </div>
	                                                   </div>       
	                                            	</div>
	                                            </form:form>
	                                          <button class="btn btn-primary text-center"  form="submitForm" type="submit">Cập nhật</button>
                                       	 </div>
                                       
                                </div>
                    </div>
                    
                </div>
            </div>
        </div>
</div>