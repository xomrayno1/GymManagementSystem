package com.tampro.backend.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.tampro.dto.Paging;
import com.tampro.dto.PublisherDTO;
import com.tampro.service.PublisherService;
import com.tampro.utils.Constant;
import com.tampro.validator.PublisherValidator;

@Controller
@RequestMapping("/manage/publisher")
public class PublisherController {
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		if(dataBinder.getTarget() == null) {
			return;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		if(dataBinder.getTarget().getClass() == PublisherDTO.class) {
			dataBinder.setValidator(publisherValidator);
		}
	}
	@Autowired
	PublisherValidator publisherValidator;
	@Autowired
	PublisherService publisherService;
	
	@GetMapping(value = {"/list","/list/"})
	public String index() {
		return "redirect:/manage/publisher/list/1";
	}
	
	@RequestMapping(value = "/list/{page}")
	public String showPublisherList(Model model,@PathVariable("page") int page,@ModelAttribute("searchForm") PublisherDTO publisherDTO,HttpSession session) {
		Paging paging = new Paging(6);
		paging.setPageIndex(page);
		List<PublisherDTO> list = publisherService.getAll(publisherDTO, paging);
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
		return "manage/publisher-list";
	}
	@GetMapping(value = {"/view/{id}"})
	public String viewPublisher(Model model,@PathVariable("id") int id) {
		PublisherDTO publisherDTO = publisherService.findById(id);
		model.addAttribute("title", "View");
		model.addAttribute("viewOnly", true);
		model.addAttribute("submitForm", publisherDTO);
		return "manage/publisher-action";
	}
	@GetMapping(value = {"/edit/{id}"})
	public String editPublisher(Model model,@PathVariable("id") int id) {
		PublisherDTO publisherDTO = publisherService.findById(id);
		model.addAttribute("title", "Edit");
		model.addAttribute("viewOnly", false);
		model.addAttribute("submitForm", publisherDTO);
		return "manage/publisher-action";
	}
	@PostMapping(value = {"/delete"})
	public String deletePublisher(Model model,@RequestParam("id")int id,HttpSession session) {
		PublisherDTO publisherDTO = publisherService.findById(id);
		try {
			publisherService.delete(publisherDTO);
			session.setAttribute(Constant.MSG_SUCCESS, "Xóa thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Xóa thất bại");
		}

		return "redirect:/manage/publisher/list/1";
	}
	@GetMapping(value = {"/add"})
	public String addPublisher(Model model) {
		model.addAttribute("title", "Add");
		model.addAttribute("viewOnly", false);
		model.addAttribute("submitForm", new PublisherDTO());
		return "manage/publisher-action";
	}
	@RequestMapping(value = {"/save"})
	public String savePublisher(Model model,@ModelAttribute("submitForm") @Validated PublisherDTO publisherDTO ,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			if(publisherDTO.getId() != 0) {
				model.addAttribute("title", "Edit");
			}else {
				model.addAttribute("title", "Add");
			}
			model.addAttribute("viewOnly", false);
			return "manage/publisher-action";
		}
		if(publisherDTO.getId() != 0) {
			try {
				publisherService.update(publisherDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Sửa thành công");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Sửa thất bại");
			}
		}else {
			try {
				publisherService.add(publisherDTO);
				session.setAttribute(Constant.MSG_SUCCESS, "Thêm thành công");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute(Constant.MSG_ERROR, "Thêm thất bại");
			}
		}
		return "redirect:/manage/publisher/list/1";
	}
}
