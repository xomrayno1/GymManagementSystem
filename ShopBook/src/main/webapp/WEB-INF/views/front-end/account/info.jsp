<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <div class="cart-main-area  pb-100" style="margin-top: 40px;">
            <div class="container">
                <div class="row">                 	
                   <jsp:include page="/WEB-INF/views/front-end/layout/menu.jsp"></jsp:include>
                    <div class="col-sm-10 col-md-10">
                   	 		<h3 class="page-title">Thông tin tài khoản</h3>
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                            <div class="billing-information-wrapper">	
	                                            <form:form 	method="POST" modelAttribute="submitForm" servletRelativeAction="/account/save">
	                                            	<form:hidden path="id"/>
	                                            	<form:hidden path="createDate"/>
	                                            	<form:hidden path="updateDate"/>
	                                            	<form:hidden path="username"/>
	                                            	<form:hidden path="password"/>
	                                            	<form:hidden path="activeFlag"/>
	                                                <div class="row">
	                                                	<div class="col-lg-12 col-md-12">
	                                                        <div class="billing-info">
	                                                            <label>Họ Tên</label>
	                                                            <form:input path="name"/>
	                                                            <div class="has-error">
	                                                            	<form:errors  path="name" cssClass="help-block"/>
	                                                            </div>
	                                                        </div>
	                                                    </div>
	                                                    <div class="col-lg-12 col-md-12">
	                                                        <div class="billing-info">
	                                                            <label>Email</label>
	                                                            <form:input path="email"/>
	                                                            <div class="has-error">
	                                                            	<form:errors  path="email" cssClass="help-block"/>
	                                                            </div>
	                                                        </div>
	                                                   </div>     
	                                                <div class="col-lg-6 col-md-6">
	                                                        <div class="billing-info">
	                                                            <label>Ngày sinh</label>
	                                                             <form:input path="birthDay" type="date"/>
	                                                             <div class="has-error">
	                                                            	<form:errors  path="birthDay" cssClass="help-block"/>
	                                                            </div>
	                                                        </div>
	                                                    </div>
	                                                    <div class="col-lg-6 col-md-6">
	                                                        <div class="billing-info">
	                                                            <label>Số điện thoại</label>
	                                                            <form:input path="phone"/>
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
	<script type="text/javascript">
		$(document).ready(function(){
			$('#account').parent('li').addClass('select').siblings().removeClass('select');
		});
	</script>

