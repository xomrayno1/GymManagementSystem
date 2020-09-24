package com.tampro.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tampro.dto.AuthDTO;
import com.tampro.dto.MenuDTO;
import com.tampro.dto.RoleDTO;
import com.tampro.dto.UserDTO;
import com.tampro.dto.UserRoleDTO;
import com.tampro.service.UserService;
import com.tampro.utils.Constant;

public class FilterSystem  implements HandlerInterceptor{
	@Autowired
	UserService userService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println(request.getServletPath());		
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute(Constant.USER_INFO);
		if(userDTO == null) {
			response.sendRedirect(request.getContextPath() + "/manage/login");
			return false;
		}else {
			String url = request.getServletPath();
			System.out.println(url);
			boolean check =  hasPermission(url,userDTO);
			if(!check) {
				System.out.println("false");
				response.sendRedirect(request.getContextPath() + "/manage/access-denied");
				return false;
			}
			return true;
		}
	}

	private boolean hasPermission(String url, UserDTO userDTO) {
		// TODO Auto-generated method stub
		if(url.contains("/manage/index")) {
			return true;
		}
		UserRoleDTO userRole = userDTO.getUserRoleDTOs().iterator().next();
		RoleDTO roleDTO = userRole.getRoleDTO();
		for(AuthDTO authDTO : roleDTO.getAuths()) {
			MenuDTO menuDTO  = authDTO.getMenuDTO();
			if(url.contains(menuDTO.getUrl())) {
				return authDTO.getPermission() == 1 ? true : false;
			}
		}
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
