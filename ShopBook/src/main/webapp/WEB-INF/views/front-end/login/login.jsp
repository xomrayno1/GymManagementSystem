<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
        <div class="breadcrumb-area gray-bg">
            <div class="container">
                <div class="breadcrumb-content">
                    <ul>
                        <li><a href="index.html">Home</a></li>
                        <li class="active"> Login </li>
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
                               <h4> Đăng Nhập </h4>
                            </div>
                            <div class="tab-content">
                                <div id="lg1" class="tab-pane active">
                                    <div class="login-form-container">
                                        <div class="login-register-form">
                                            <form:form method="POST" servletRelativeAction="/processLogin" modelAttribute="submitForm" >
                                            	<form:input path="username" placeholder="Tài khoản"/>
	                                            	<div class="has-error">
	                                            		<form:errors path="username" cssClass="help-block"/>
	                                            	</div>
                                            	<form:password path="password" placeholder="Mật khẩu"/>
	                                            	<div class="has-error">
	                                            		<form:errors path="password" cssClass="help-block"/>
	                                            	</div>
                                            	 <div class="button-box">
                                                    <div class="login-toggle-btn">
                                                        <input type="checkbox">
                                                        <label>Remember me</label>
                                                        <a href="#">Quên mật khẩu</a>
                                                    </div>
                                                    <button  type="submit"><span>Đăng nhập</span></button>
                                                    <a style="margin-left: 20px" href='<c:url value="/register"></c:url>'>Chưa có tài khoản</a>
                                                </div>
                                                 
                                            </form:form>
                                        </div>
                                        <hr>
                                        <div>
                                        	 <button class="btn btn-primary"><i class="fa fa-facebook-square"> Facebook</i></button>
                                        </div>
                                        
                                    </div>
                                </div>	  
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       <script type="text/javascript">
       		var msgSuccess = '${msgSuccess}';
       		var msgError = '${msgError}';
			if(msgSuccess){
				alert(msgSuccess);
			}
			if(msgError){
				alert(msgError);
			}
       
		</script>