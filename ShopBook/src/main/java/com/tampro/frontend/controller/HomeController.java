package com.tampro.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.dto.CategoryDTO;
import com.tampro.dto.Paging;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.service.CategoryService;
import com.tampro.service.ProductInfoService;

@Controller
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductInfoService productInfoService;
	
	@RequestMapping(value = {"/","/index"})
	public String home(Model model) {

		model.addAttribute("listProdut",productInfoService.getProductNews());
			
		return "index";
	}
	@GetMapping(value = {"/{url}"})
	public String showProductDetail(Model model,@PathVariable("url") String url) {
		List<ProductInfoDTO> infoDTOs = productInfoService.getAllByProperty("url", url);
		if(infoDTOs !=null && !infoDTOs.isEmpty()) {
			model.addAttribute("product",infoDTOs.get(0));
			return "product-detail";
		}else {
			return "404";	
		}
	}
	@GetMapping(value = {"/the-loai/{url}","/the-loai/{url}/"})
	public String redirect(Model model,@PathVariable("url") String url) {
			return "redirect:/the-loai/"+url+"/1";
	}
	@GetMapping(value = {"/the-loai/{url}/{page}"})
	public String showProductByCategory(Model model,@PathVariable("url") String url,@PathVariable("page") int page,@RequestParam( name = "sortPrice",required = false) String sort) {
		Paging paging = new Paging(24);
		paging.setPageIndex(page);		
		List<CategoryDTO> cates = categoryService.getAllByProperty("url", url);
		if(cates !=null) {
			List<ProductInfoDTO> infoDTOs = productInfoService.getAllByPropertySort("category.id", cates.get(0).getId(),paging , sort);
			model.addAttribute("listProduct",infoDTOs);
			model.addAttribute("pageInfo", paging);
		}
		return "product-category-list";
	}

}
