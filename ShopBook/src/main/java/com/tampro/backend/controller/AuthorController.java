package com.tampro.backend.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tampro.dto.AuthorDTO;
import com.tampro.dto.Paging;
import com.tampro.report.ReportAuthor;
import com.tampro.service.AuthorService;
import com.tampro.utils.Constant;
import com.tampro.validator.AuthorValidator;

@Controller
@RequestMapping("/manage/author")
public class AuthorController {
		@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			if(dataBinder.getTarget() == null) {
				return;
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
			if(dataBinder.getTarget().getClass() == AuthorDTO.class) {
				dataBinder.setValidator(authorValidator);
			}
		}
		@Autowired
		AuthorValidator authorValidator;
		@Autowired
		AuthorService authorService;
		
		@GetMapping(value = {"/list","/list/"})
		public String index() {
			return "redirect:/manage/author/list/1";
		}
		
		@RequestMapping(value = "/list/{page}")
		public String showAuthorList(Model model,@PathVariable("page") int page,@ModelAttribute("searchForm") AuthorDTO authorDTO,HttpSession session) {
			Paging paging = new Paging(6);
			paging.setPageIndex(page);
			List<AuthorDTO> list = authorService.getAll(authorDTO, paging);
			model.addAttribute("pageInfo", paging);
			model.addAttribute(Constant.LIST_PRODUCT, list);
			if(session.getAttribute(Constant.MSG_SUCCESS) != null) {
				model.addAttribute(Constant.MSG_SUCCESS, session.getAttribute(Constant.MSG_SUCCESS));
				session.removeAttribute(Constant.MSG_SUCCESS);
			}
			if(session.getAttribute(Constant.MSG_ERROR) != null) {
				model.addAttribute(Constant.MSG_ERROR, session.getAttribute(Constant.MSG_ERROR));
				session.removeAttribute(Constant.MSG_ERROR);
			}
			return "manage/author-list";
		}
		@GetMapping(value = {"/view/{id}"})
		public String viewAuthor(Model model,@PathVariable("id") int id) {
			AuthorDTO authorDTO = authorService.findById(id);
			model.addAttribute("title", "View");
			model.addAttribute("viewOnly", true);
			model.addAttribute("submitForm", authorDTO);
			return "manage/author-action";
		}
		@GetMapping(value = {"/edit/{id}"})
		public String editAuthor(Model model,@PathVariable("id") int id) {
			AuthorDTO authorDTO = authorService.findById(id);
			model.addAttribute("title", "Edit");
			model.addAttribute("viewOnly", false);
			model.addAttribute("submitForm", authorDTO);
			return "manage/author-action";
		}
		@PostMapping(value = {"/delete"})
		public String deleteAuthor(Model model,@RequestParam("id")int id,HttpSession session) {
			AuthorDTO authorDTO = authorService.findById(id);
			try {
				authorService.delete(authorDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Xóa thành công");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Xóa thất bại");
			}
	
			return "redirect:/manage/author/list/1";
		}
		@GetMapping(value = {"/add"})
		public String addAuthor(Model model) {
			model.addAttribute("title", "Add");
			model.addAttribute("viewOnly", false);
			model.addAttribute("submitForm", new AuthorDTO());
			return "manage/author-action";
		}
		@RequestMapping(value = {"/save"})
		public String saveAuthor(Model model,@ModelAttribute("submitForm") @Validated AuthorDTO authorDTO ,BindingResult result,HttpSession session) {
			if(result.hasErrors()) {
				if(authorDTO.getId() != 0) {
					model.addAttribute("title", "Edit");
				}else {
					model.addAttribute("title", "Add");
				}
				model.addAttribute("viewOnly", false);
				return "manage/author-action";
			}
			if(authorDTO.getId() != 0) {
				try {
					authorService.update(authorDTO);
					session.setAttribute(Constant.MSG_SUCCESS, "Sửa thành công");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					session.setAttribute(Constant.MSG_ERROR, "Sửa thất bại");
				}
			}else {
				try {
					authorService.add(authorDTO);
					session.setAttribute(Constant.MSG_SUCCESS, "Thêm thành công");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					session.setAttribute(Constant.MSG_ERROR, "Thêm thất bại");
				}
			}
			return "redirect:/manage/author/list/1";
		}
		@GetMapping(value = {"/excel-file"})
		public ModelAndView report(Model model) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setView(new ReportAuthor());
			return modelAndView;
		}
		@PostMapping(value = {"/import-excel"})
		public String importAuthor(Model model,@RequestParam("file") MultipartFile file,HttpSession session) throws IOException  {
			HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
			HSSFSheet workSheet = workbook.getSheetAt(0);
			for(int i = 0 ; i < workSheet.getPhysicalNumberOfRows() ; i++) {
				if(i > 0 ) {
					AuthorDTO authorDTO = new AuthorDTO();
					HSSFRow row = workSheet.getRow(i);
					try {
						authorDTO.setName(row.getCell(0).getStringCellValue());
						authorDTO.setEmail(row.getCell(1).getStringCellValue());					
						authorDTO.setDescription(row.getCell(2).getStringCellValue());
						authorService.add(authorDTO);
						session.setAttribute(Constant.MSG_SUCCESS, "Import thành công");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						session.setAttribute(Constant.MSG_ERROR, "Import thất bại");
					}
				}
			}
			return "redirect:/manage/author/list/1";
		}
}
