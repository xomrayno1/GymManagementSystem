<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


              <ul class="pagination"> 
              	<c:forEach begin="1" end="${pageInfo.totalPage}" varStatus="i">
              		<c:choose>
              			<c:when test="${pageInfo.pageIndex == i.index}">
              				<li class="active"><a href="javascript:void(0)" >${pageInfo.pageIndex}</a></li>
              			</c:when>
              			<c:otherwise>
              				<li><a onclick="gotoPage(${i.index})">${i.index}</a></li>
              			</c:otherwise>
              		</c:choose>
              	</c:forEach>
              </ul>  