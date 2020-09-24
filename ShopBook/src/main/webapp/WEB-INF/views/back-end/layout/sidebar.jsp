<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
	<div class="menu_section">
		<h3>General</h3>
		<c:forEach items="${menuSession}" var="menu">
			<ul class="nav side-menu" id="${menu.idMenu}">
				<li><a><i class="fa fa-home"></i> ${menu.name} <span
					class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<c:forEach items="${menu.childMenu}" var="menuChild">	
								<li id="${menuChild.idMenu}"><a href='<c:url value="${menuChild.url}"></c:url>'>${menuChild.name}</a></li>
							</c:forEach>						
						</ul>
				</li>
			</ul>
		</c:forEach>
	</div>
</div>