package com.tampro.backend.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import com.tampro.dto.CategoryDTO;
import com.tampro.dto.Paging;
import com.tampro.report.ReportCategory;
import com.tampro.service.CategoryService;
import com.tampro.utils.Constant;
import com.tampro.validator.CategoryValidator;

@Controller
@RequestMapping("/manage/category")
public class CategoryController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		if(dataBinder.getTarget() == null) {
			return;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		if(dataBinder.getTarget().getClass() == CategoryDTO.class) {
			dataBinder.setValidator(categoryValidator);
		}
	}
	@Autowired
	CategoryValidator categoryValidator;
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(value = {"/list","/list/"})
	public String index() {
		return "redirect:/manage/category/list/1";
	}
	
	@RequestMapping(value = "/list/{page}")
	public String showCategoryList(Model model,@PathVariable("page") int page,@ModelAttribute("searchForm") CategoryDTO categoryDTO,HttpSession session) {
		Paging paging = new Paging(6);
		paging.setPageIndex(page);
		List<CategoryDTO> list = categoryService.getAll(categoryDTO, paging);
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
		return "manage/category-list";
	}
	@GetMapping(value = {"/view/{id}"})
	public String viewCategory(Model model,@PathVariable("id") int id) {
		CategoryDTO categoryDTO = categoryService.findById(id);
		model.addAttribute("title", "View");
		model.addAttribute("viewOnly", true);
		model.addAttribute("submitForm", categoryDTO);
		initSelect(model);
		return "manage/category-action";
	}
	@GetMapping(value = {"/edit/{id}"})
	public String editCategory(Model model,@PathVariable("id") int id) {
		CategoryDTO categoryDTO = categoryService.findById(id);
		model.addAttribute("title", "Edit");
		model.addAttribute("viewOnly", false);
		model.addAttribute("submitForm", categoryDTO);
		initSelect(model);
		return "manage/category-action";
	}
	@PostMapping(value = {"/delete"})
	public String deleteCategory(Model model,@RequestParam("id")int id,HttpSession session) {
		CategoryDTO categoryDTO = categoryService.findById(id);
		try {
			categoryService.delete(categoryDTO);
			session.setAttribute(Constant.MSG_SUCCESS, "Xóa thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Xóa thất bại");
		}

		return "redirect:/manage/category/list/1";
	}
	@GetMapping(value = {"/add"})
	public String addCategory(Model model) {
		model.addAttribute("title", "Add");
		model.addAttribute("viewOnly", false);
		model.addAttribute("submitForm", new CategoryDTO());
		initSelect(model);
		return "manage/category-action";
	}
	@RequestMapping(value = {"/save"})
	public String saveCategory(Model model,@ModelAttribute("submitForm") @Validated CategoryDTO categoryDTO ,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			if(categoryDTO.getId() != 0) {
				model.addAttribute("title", "Edit");
			}else {
				model.addAttribute("title", "Add");
			}
			initSelect(model);
			model.addAttribute("viewOnly", false);
			return "manage/category-action";
		}
		if(categoryDTO.getId() != 0) {
			try {
				categoryService.update(categoryDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Sửa thành công");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Sửa thất bại");
			}
		}else {
			try {
				categoryService.add(categoryDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Thêm thành công");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Thêm thất bại");
			}
		}
		return "redirect:/manage/category/list/1";
	}
	@GetMapping(value = {"/excel-file"})
	public ModelAndView excelFile(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new ReportCategory());
		return modelAndView;
	}
	@PostMapping(value = {"/import-excel"})
	public String importAuthor(Model model,@RequestParam("file") MultipartFile file,HttpSession session) throws IOException  {
		HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
		HSSFSheet workSheet = workbook.getSheetAt(0);
		for(int i = 0 ; i < workSheet.getPhysicalNumberOfRows() ; i++) {
			if(i > 0 ) {
				CategoryDTO categoryDTO = new CategoryDTO();
				HSSFRow row = workSheet.getRow(i);
				try {
					categoryDTO.setName(row.getCell(0).getStringCellValue());
					categoryDTO.setCode(row.getCell(1).getStringCellValue());
					categoryDTO.setMultipartFile(null);
					if(row.getCell(2) != null) {
						categoryDTO.setIdParent(new Double(row.getCell(2).getNumericCellValue()).intValue());
					}else {
						categoryDTO.setIdParent(0);
					}
					categoryService.add(categoryDTO);
					session.setAttribute(Constant.MSG_SUCCESS, "Import thành công");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					session.setAttribute(Constant.MSG_ERROR, "Import thất bại");
				}
			}
		}
		return "redirect:/manage/category/list/1";
	}
	public void initSelect(Model model) {
		List<CategoryDTO> list  = categoryService.getAllByProperty("idParent", 0);
		Collections.sort(list,new Comparator<CategoryDTO>() {
			@Override
			public int compare(CategoryDTO o1, CategoryDTO o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		Map<Integer,String> map = new HashedMap();
		for(CategoryDTO categoryDTO : list) {
			map.put(categoryDTO.getId(), categoryDTO.getName());
		}		
		model.addAttribute("categories", map);
	}
	
}
