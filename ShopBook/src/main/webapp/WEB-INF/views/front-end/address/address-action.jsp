<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <div class="cart-main-area  pb-100" style="margin-top: 40px;">
            <div class="container">
                <div class="row">                 	
                   	<jsp:include page="/WEB-INF/views/front-end/layout/menu.jsp"></jsp:include>
                    <div class="col-sm-10 col-md-10">
                   	 		<h3 class="page-title">${title}</h3>
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                            <div class="billing-information-wrapper">	
	                                            <form:form 	method="POST" modelAttribute="submitForm" servletRelativeAction="/account/address/save">
	                                            	<form:hidden path="id"/>
	                                            	<form:hidden path="createDate"/>
	                                            	<form:hidden path="updateDate"/>
	                                            	<form:hidden path="activeFlag"/>
	                                            	<form:hidden path="idUser"/>
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
	                                                            <label>Số điện thoại</label>
	                                                            <form:input path="phone"/>
	                                                            <div class="has-error">
	                                                            	<form:errors  path="phone" cssClass="help-block"/>
	                                                            </div>	                                                            
	                                                        </div>
	                                                    </div>
	                                                    <div class="col-lg-12 col-md-12">
	                                                        <div class="billing-info">
	                                                            <label>Tỉnh</label>
	                                                            <form:input path="province"/>
	                                                            <div class="has-error">
	                                                            	<form:errors  path="province" cssClass="help-block"/>
	                                                            </div>
	                                                        </div>
	                                                    </div>  
	                                                    <div class="col-lg-12 col-md-12">
	                                                        <div class="billing-info">
	                                                            <label>Huyện</label>
	                                                            <form:input path="district"/>
	                                                            <div class="has-error">
	                                                            	<form:errors  path="district" cssClass="help-block"/>
	                                                            </div>
	                                                        </div>
	                                                    </div>
	                                                    <div class="col-lg-12 col-md-12">
	                                                        <div class="billing-info">
	                                                            <label>Xã</label>
	                                                            <form:input path="commune"/>
	                                                            <div class="has-error">
	                                                            	<form:errors  path="commune" cssClass="help-block"/>
	                                                            </div>
	                                                        </div>
	                                                    </div>
	                                                    <div class="col-lg-12 col-md-12">
	                                                        <div class="billing-info">
	                                                            <label>Chi tiết</label>
	                                                            <form:textarea path="description" cols="10" rows="5"/>
	                                                            <div class="has-error">
	                                                            	<form:errors  path="description" cssClass="help-block"/>
	                                                            </div>
	                                                        </div>
	                                                    </div>      
	                                            	</div>    	     
	                                            </form:form>
	                                          <button class="btn btn-primary"  form="submitForm" type="submit">Cập nhật</button>
                                       	 </div>                                     
                                </div>                   
                    </div>       
                </div>
            </div>
        </div>
</div>