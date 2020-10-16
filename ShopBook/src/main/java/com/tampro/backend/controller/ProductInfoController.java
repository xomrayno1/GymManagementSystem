package com.tampro.backend.controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.dto.AuthorDTO;
import com.tampro.dto.CategoryDTO;
import com.tampro.dto.Paging;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.dto.PublisherDTO;
import com.tampro.service.AuthorService;
import com.tampro.service.CategoryService;
import com.tampro.service.ProductInfoService;
import com.tampro.service.PublisherService;
import com.tampro.utils.Constant;
import com.tampro.validator.ProductInfoValidator;

@Controller
@RequestMapping("/manage/product-info")
public class ProductInfoController {


	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		if(dataBinder.getTarget() == null) {
			return;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		if(dataBinder.getTarget().getClass() == ProductInfoDTO.class) {
			dataBinder.setValidator(productInfoValidator);
		}
	}
	@Autowired
	ProductInfoValidator productInfoValidator;
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AuthorService authorService;
	@Autowired
	PublisherService publisherService;
	
	@GetMapping(value = {"/list","/list/"})
	public String index() {
		return "redirect:/manage/product-info/list/1";
	}
	
	@RequestMapping(value = "/list/{page}")
	public String showProductInfoList(Model model,@PathVariable("page") int page,@ModelAttribute("searchForm") ProductInfoDTO productInfoDTO,HttpSession session) {
		Paging paging = new Paging(6);
		paging.setPageIndex(page);	
		List<ProductInfoDTO> list = productInfoService.getAll(productInfoDTO, paging);
		model.addAttribute(Constant.LIST_PRODUCT, list);
		model.addAttribute("pageInfo", paging);
		if(session.getAttribute(Constant.MSG_SUCCESS) != null) {
			model.addAttribute(Constant.MSG_SUCCESS, session.getAttribute(Constant.MSG_SUCCESS));
			session.removeAttribute(Constant.MSG_SUCCESS);
		}
		if(session.getAttribute(Constant.MSG_ERROR) != null) {
			model.addAttribute(Constant.MSG_ERROR, session.getAttribute(Constant.MSG_ERROR));
			session.removeAttribute(Constant.MSG_ERROR);
		}
		return "manage/productInfo-list";
	}
	@GetMapping(value = {"/view/{id}"})
	public String viewProductInfo(Model model,@PathVariable("id") int id) {
		ProductInfoDTO productInfoDTO = productInfoService.findById(id);
		model.addAttribute("title", "View");
		model.addAttribute("viewOnly", true);
		model.addAttribute("submitForm", productInfoDTO);
		initSelect(model);
		return "manage/productInfo-action";
	}
	@GetMapping(value = {"/edit/{id}"})
	public String editProductInfo(Model model,@PathVariable("id") int id) {
		ProductInfoDTO productInfoDTO = productInfoService.findById(id);
		model.addAttribute("title", "Edit");
		model.addAttribute("viewOnly", false);
		model.addAttribute("submitForm", productInfoDTO);
		initSelect(model);
		return "manage/productInfo-action";
	}
	@PostMapping(value = {"/delete"})
	public String deleteProductInfo(Model model,@RequestParam("id")int id,HttpSession session) {
		ProductInfoDTO productInfoDTO = productInfoService.findById(id);
		try {
			productInfoService.delete(productInfoDTO);
			session.setAttribute(Constant.MSG_SUCCESS, "Xóa thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Xóa thất bại");
		}

		return "redirect:/manage/product-info/list/1";
	}
	@GetMapping(value = {"/add"})
	public String addProductInfo(Model model) {
		model.addAttribute("title", "Add");
		model.addAttribute("viewOnly", false);
		model.addAttribute("submitForm", new ProductInfoDTO());
		initSelect(model);
		return "manage/productInfo-action";
	}
	@RequestMapping(value = {"/save"})
	public String saveProductInfo(Model model,@ModelAttribute("submitForm") @Validated ProductInfoDTO productInfoDTO ,BindingResult result,HttpSession session)  {		
		if(result.hasErrors()) {
			if(productInfoDTO.getId() != 0) {
				model.addAttribute("title", "Edit");
			}else {
				model.addAttribute("title", "Add");
			}
			initSelect(model);
			model.addAttribute("viewOnly", false);
			return "manage/productInfo-action";
		}
		System.out.println(productInfoDTO.getDescription());
		if(productInfoDTO.getId() != 0) {
			try {
				productInfoService.update(productInfoDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Sửa thành công");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Sửa thất bại");
			}
		}else {
			try {
				productInfoService.add(productInfoDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Thêm thành công");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Thêm thất bại");
			}
		}
		return "redirect:/manage/product-info/list/1";
	}
	public void initSelect(Model model) {
		List<CategoryDTO> listCategory  = categoryService.getAll(null, null);
		Collections.sort(listCategory,new Comparator<CategoryDTO>() {
			@Override
			public int compare(CategoryDTO o1, CategoryDTO o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		Map<Integer,String> mapCategory = new HashedMap();
		for(CategoryDTO categoryDTO : listCategory) {
			if(categoryDTO.getIdParent() != 0) {
				mapCategory.put(categoryDTO.getId(), categoryDTO.getName());
			}
		}		
		model.addAttribute("categories", mapCategory);
		
		List<AuthorDTO> listAuthor  = authorService.getAll(null, null);
		Collections.sort(listAuthor,new Comparator<AuthorDTO>() {
			@Override
			public int compare(AuthorDTO o1, AuthorDTO o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		Map<Integer,String> mapAuthor = new HashedMap();
		for(AuthorDTO authorDTO : listAuthor) {
			mapAuthor.put(authorDTO.getId(), authorDTO.getName());
		}		
		model.addAttribute("authors", mapAuthor);
		
		List<PublisherDTO> listPublisher  = publisherService.getAll(null, null);
		Collections.sort(listPublisher,new Comparator<PublisherDTO>() {
			@Override
			public int compare(PublisherDTO o1, PublisherDTO o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		Map<Integer,String> mapPublisher = new HashedMap();
		for(PublisherDTO publisherDTO : listPublisher) {
			mapPublisher.put(publisherDTO.getId(), publisherDTO.getName());
		}		
		model.addAttribute("publisher", mapPublisher);
		
	}

}
