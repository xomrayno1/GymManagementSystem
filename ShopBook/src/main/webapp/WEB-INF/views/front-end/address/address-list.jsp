<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<div class="cart-main-area  pb-100" style="margin-top: 40px;">
    <div class="container">
        <div class="row">                 	
             <jsp:include page="/WEB-INF/views/front-end/layout/menu.jsp"></jsp:include>
             <div class="col-sm-10 col-md-10">
                <h3 class="page-title">Sổ địa chỉ</h3>
                <div class="panel panel-default">
                     <div class="panel-body">
                         <div class="billing-information-wrapper text-center">		                        
	                         <a class="btn btn-primary" href='<c:url value="/account/address/add"></c:url>'>Thêm địa chỉ</a>
                         </div>            
                    </div>
                </div>
                <c:forEach items="${list}" var="item">
                	 <div class="panel panel-default">
	                     <div class="panel-body">
	                        <div class="item">
	                        	<div class="info">
		                        	<div class="name">
		                        		${item.name}
		                        	</div>
		                        	<div class="address">
		                        		<span>Địa chỉ : </span> ${item.fullAddress()}
		                        	</div>
		                        	<div class="phone">
		                        		<span>Điện thoại : </span>	${item.phone}
		                        	</div>
	                        	</div> 
		                        <div class="action">
		                        	<a href='<c:url value="/account/address/edit?id=${item.id}"></c:url>' class="edit"> Chỉnh sửa </a>
		                        	<a href="javascript:void(0)" onclick="deleteAddress(${item.id})" class="delete"> Xóa </a>
		                        </div> 
	                        </div>                               
	                    </div>
                	</div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
		<script type="text/javascript">
			function deleteAddress(id){
				console.log("click")
				var check = confirm("Bạn có thật sự muốn xóa");
				if(check){
					location.href="<c:url value='/account/address/delete?id='/>"+id;
				}
			}
			$(document).ready(function(){
				$('#address').parent('li').addClass('select').siblings().removeClass('select');
			});
		</script>