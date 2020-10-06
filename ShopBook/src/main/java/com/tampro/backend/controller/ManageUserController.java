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
import com.tampro.dto.UserDTO;
import com.tampro.service.RoleService;
import com.tampro.service.UserService;
import com.tampro.utils.Constant;
import com.tampro.validator.UserValidator;

@Controller
@RequestMapping("/manage/user")
public class ManageUserController {
	@Autowired
	UserService userService;
	@Autowired
	UserValidator userValidator;
	@Autowired
	RoleService roleService;
	@InitBinder
	public void binder(WebDataBinder dataBinder) {
		if(dataBinder.getTarget() == null) {
			return ; 
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		if(dataBinder.getTarget().getClass() == UserDTO.class) {
			dataBinder.setValidator(userValidator);
		}
	}

	@GetMapping(value = {"/list","/list/"})
	public String redirect() {
		return "redirect:/manage/user/list/1";
	}	
	@RequestMapping("/list/{page}")
	public String showUser(Model model,@PathVariable("page")int page,@ModelAttribute("searchForm") UserDTO userDTO,HttpSession session) {
		Paging paging = new Paging(10);
		paging.setPageIndex(page);
		List<UserDTO> list = userService.getAll(userDTO, paging);
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
		return "manage/user-list";
	}
	@GetMapping(value = {"/delete/{id}"})
	public String deleteUser(Model model,@PathVariable("id")int id,HttpSession session) {
		UserDTO userDTO  = userService.findById(id);
		try {
			userService.delete(userDTO);
			session.setAttribute(Constant.MSG_SUCCESS, "Xóa thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Xóa thất bại");
		}
		return "redirect:/manage/user/list/1";
	}	
	@GetMapping(value = {"/add"})
	public String addUser(Model model) {
		model.addAttribute("title", "Add");
		model.addAttribute("submitForm", new UserDTO());
		model.addAttribute("viewOnly", false);
		initSelect(model);
		return "manage/user-action";
	}	
	@GetMapping(value = {"/edit/{id}"})
	public String editUser(Model model,@PathVariable("id")int id) {
		UserDTO userDTO  = userService.findById(id);
		model.addAttribute("title", "Edit");
		model.addAttribute("submitForm", userDTO);
		model.addAttribute("viewOnly", false);
		initSelect(model);
		return "manage/user-action";
	}
	
	@GetMapping(value = {"/view/{id}"})
	public String viewUser(Model model,@PathVariable("id")int id) {
		UserDTO userDTO  = userService.findById(id);
		model.addAttribute("title", "View");
		model.addAttribute("submitForm", userDTO);
		model.addAttribute("viewOnly", true);
		return "manage/user-action";
	}
	@PostMapping(value = {"/save"})
	public String viewUser(Model model,@ModelAttribute("submitForm") @Validated UserDTO userDTO,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			if(userDTO.getId() != 0) {
				model.addAttribute("title", "Edit");
			}else {
				model.addAttribute("title", "Add");
			}
			initSelect(model);
			model.addAttribute("viewOnly", false);
			return "manage/user-action";
		}
		try {
			userService.add(userDTO);
			session.setAttribute(Constant.MSG_SUCCESS, "Thêm thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Thêm thất bại");
		}
		try {
			userService.update(userDTO);
			session.setAttribute(Constant.MSG_SUCCESS, "Cập nhật thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Cập nhật thất bại");
		}
		return "redirect:/manage/user/list/1";
	}	
	@GetMapping(value = {"/reset-password/{id}"})
	public String resetUser(Model model,@PathVariable("id")int id,HttpSession session) {
		UserDTO userDTO  = userService.findById(id);
		try {
			userDTO.setPassword("55555");
			userService.updatePassword(userDTO);
			session.setAttribute(Constant.MSG_SUCCESS, "Reset thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Reset thất bại");
		}
		return "redirect:/manage/user/list/1";
	}	
	public void initSelect(Model model) {
		List<RoleDTO> list = roleService.getAll(null);
		model.addAttribute("listRole", list);
	}

}
