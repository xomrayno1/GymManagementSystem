<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<div class="cart-main-area  pb-100" style="margin-top: 40px;">
    <div class="container">
        <div class="row">                 	
             <div class="col-sm-12 col-md-12">
                <h3 class="page-title">Sổ địa chỉ</h3>
                <div class="panel panel-default">
                     <div class="panel-body">
                         <div class="billing-information-wrapper text-center">		                                    
                    </div>
                </div>
                <div class="row">
                <c:forEach items="${list}" var="item">
                	<div class="col-lg-6 col-md-6">
	                	 <div class="panel panel-default" >
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
			                        	<div class="action"  style="margin-top: 15px;">
			                        		<a href='<c:url value="/checkout/payment?id=${item.id}"></c:url>' class="btn btn-primary"> Giao đến địa chỉ này </a>
				                        	<!-- 
					                        	<a href='<c:url value="/account/address/edit?id=${item.id}"></c:url>' class="btn" style="border : 1px solid ;"> Chỉnh sửa </a>
					                        	<a href="javascript:void(0)" onclick="deleteAddress(${item.id})" class="delete"> Xóa </a>
				                        	 -->
			                        	</div> 
		                        	</div> 			                        
		                        </div>                               
		                    </div>
	                	</div>
                	</div>
                </c:forEach>
                </div>
            </div>
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
		</script>