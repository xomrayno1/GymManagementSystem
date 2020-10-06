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

import com.tampro.dto.Paging;
import com.tampro.dto.RoleDTO;
import com.tampro.service.RoleService;
import com.tampro.utils.Constant;
import com.tampro.validator.RoleValidator;

@Controller
@RequestMapping("/manage/role")
public class RoleController {
	@Autowired
	RoleService roleService;
	@Autowired
	RoleValidator roleValidator;
	@InitBinder
	public void binder(WebDataBinder dataBinder) {
		if(dataBinder.getTarget() == null) {
			return ; 
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		if(dataBinder.getTarget().getClass() == RoleDTO.class) {
			dataBinder.setValidator(roleValidator);
		}
	}

	@GetMapping(value = {"/list","/list/"})
	public String redirect() {
		return "redirect:/manage/role/list/1";
	}	
	@RequestMapping("/list/{page}")
	public String showRole(Model model,@PathVariable("page")int page,HttpSession session) {
		Paging paging = new Paging(10);
		paging.setPageIndex(page);
		List<RoleDTO> list = roleService.getAll(paging);
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", paging);
		if(session.getAttribute(Constant.MSG_SUCCESS) != null) {
			model.addAttribute(Constant.MSG_SUCCESS, session.getAttribute(Constant.MSG_SUCCESS));
			session.removeAttribute(Constant.MSG_SUCCESS);
		}
		if(session.getAttribute(Constant.MSG_ERROR) != null) {
			model.addAttribute(Constant.MSG_ERROR, session.getAttribute(Constant.MSG_ERROR));
			session.removeAttribute(Constant.MSG_ERROR);
		}
		return "manage/role-list";
	}
	@GetMapping(value = {"/delete/{id}"})
	public String deleteRole(Model model,@PathVariable("id")int id,HttpSession session) {
		RoleDTO roleDTO  = roleService.findById(id);
		try {
			roleService.delete(roleDTO);
			session.setAttribute(Constant.MSG_SUCCESS, "Xóa thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Xóa thất bại");
		}
		return "redirect:/manage/role/list/1";
	}	
	@GetMapping(value = {"/add"})
	public String addRole(Model model) {
		model.addAttribute("title", "Add");
		model.addAttribute("submitForm", new RoleDTO());
		model.addAttribute("viewOnly", false);
		return "manage/role-action";
	}	
	@GetMapping(value = {"/edit/{id}"})
	public String editRole(Model model,@PathVariable("id")int id) {
		RoleDTO roleDTO  = roleService.findById(id);
		model.addAttribute("title", "Edit");
		model.addAttribute("submitForm", roleDTO);
		model.addAttribute("viewOnly", false);
		return "manage/role-action";
	}
	
	@GetMapping(value = {"/view/{id}"})
	public String viewRole(Model model,@PathVariable("id")int id) {
		RoleDTO roleDTO  = roleService.findById(id);
		model.addAttribute("title", "View");
		model.addAttribute("submitForm", roleDTO);
		model.addAttribute("viewOnly", true);
		return "manage/role-action";
	}
	@PostMapping(value = {"/save"})
	public String viewRole(Model model,@ModelAttribute("submitForm") @Validated RoleDTO roleDTO,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			if(roleDTO.getId() != 0) {
				model.addAttribute("title", "Edit");
			}else {
				model.addAttribute("title", "Add");
			}
			model.addAttribute("viewOnly", false);
			return "manage/role-action";
		}
		try {
			roleService.add(roleDTO);
			session.setAttribute(Constant.MSG_SUCCESS, "Thêm thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Thêm thất bại");
		}
		try {
			roleService.update(roleDTO);
			session.setAttribute(Constant.MSG_SUCCESS, "Cập nhật thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Cập nhật thất bại");
		}
		return "redirect:/manage/role/list/1";
	}	
}



