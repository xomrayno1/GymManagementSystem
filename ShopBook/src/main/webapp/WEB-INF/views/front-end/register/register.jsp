<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
        <div class="breadcrumb-area gray-bg">
            <div class="container">
                <div class="breadcrumb-content">
                    <ul>
                        <li><a href="index.html">Home</a></li>
                        <li class="active"> Register </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="login-register-area pt-95 pb-100">
            <div class="container">
                <div class="row">
                    <div class="col-lg-7 col-md-12 ml-auto mr-auto">
                        <div class="login-register-wrapper">
                            <div class="login-register-tab-list nav">
                                <h4> Đăng Kí </h4>
                            </div>
                            <div class="tab-content">
                                <div  class="tab-pane active">
                                    <div class="login-form-container">
                                        <div class="login-register-form">
                                           <form:form method="POST" servletRelativeAction="/processRegister" modelAttribute="submitForm" >
                                            	<form:input path="username" placeholder="Tài khoản"/>
                                            	<div class="has-error">
                                            		<form:errors path="username" cssClass="help-block" />
                                            	</div>
                                            	<form:password path="password" placeholder="Mật khẩu"/>
                                            	<div class="has-error">
                                            		<form:errors path="password"  cssClass="help-block"/>
                                            	</div>
                                            	<form:input path="name" placeholder="Tên"/>
                                            	<div class="has-error">
                                            		<form:errors path="name" cssClass="help-block" />
                                            	</div>
                                            	<form:input path="email" placeholder="Email"/>
                                            	<div class="has-error">
                                            		<form:errors path="email"  cssClass="help-block"/>
                                            	</div>
                                            	<form:input path="phone" placeholder="Số điện thoại"/> 
                                                <div class="button-box">
                                                	<div class="login-toggle-btn">
	                                                    <button type="submit"><span>Register</span></button>
	                                                    <a href='<c:url value="/login"></c:url>'>Quay lại trang đăng nhập</a>
	                                                </div>    
                                                </div>
                                           </form:form>
                                        </div>
                                    </div>
                                </div>	  
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>