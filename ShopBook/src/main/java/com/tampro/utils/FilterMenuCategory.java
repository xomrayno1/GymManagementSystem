package com.tampro.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tampro.dto.CategoryDTO;
import com.tampro.service.CategoryService;

public class FilterMenuCategory implements HandlerInterceptor{
	@Autowired
	CategoryService categoryService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		List<CategoryDTO> list	= categoryService.getAll(null, null);
		List<CategoryDTO> listParent = new ArrayList<CategoryDTO>();
		List<CategoryDTO> listChild = new ArrayList<CategoryDTO>();
		
		for(CategoryDTO dto : list) {
			if(dto.getIdParent() == 0) {
				listParent.add(dto);
			}else {
				listChild.add(dto);
			}
		}
		for(CategoryDTO dto : listParent) {
			List<CategoryDTO> listChi = new ArrayList<CategoryDTO>();
			for(CategoryDTO item : listChild) {
				 if(dto.getId() == item.getIdParent()) {
					 listChi.add(item);
				 }
			}
			dto.setChildCategory(listChi);
		}
		request.setAttribute("menuInfo", listParent);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
