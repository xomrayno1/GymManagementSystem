package com.tampro.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tampro.dto.UserDTO;
import com.tampro.service.UserService;
import com.tampro.utils.Constant;
import com.tampro.validator.LoginValidator;
@Controller
public class LoginController {
	@Autowired
	LoginValidator loginValidator;
	@Autowired
	UserService userService;
	@InitBinder
	public void init(WebDataBinder binder) {
		if(binder.getTarget() == null) {
			return;
		}
		if(binder.getTarget().getClass() == UserDTO.class) {
			binder.setValidator(loginValidator);
		}
	}

	@GetMapping(value = {"/login"})
	public String login(Model model,HttpSession session) {
		if(session.getAttribute(Constant.USER_INFO) != null) {
			return "redirect:/index";
		}else {
			if(session.getAttribute(Constant.MSG_SUCCESS) != null) {
				model.addAttribute(Constant.MSG_SUCCESS, session.getAttribute(Constant.MSG_SUCCESS));
				session.removeAttribute(Constant.MSG_SUCCESS);
			}
			if(session.getAttribute(Constant.MSG_ERROR) != null) {
				model.addAttribute(Constant.MSG_ERROR, session.getAttribute(Constant.MSG_ERROR));
				session.removeAttribute(Constant.MSG_ERROR);
			}
			model.addAttribute("submitForm", new UserDTO());
			return "login";
		}
	}
	@PostMapping(value = "/processLogin")
	public String processLogin(Model model,@ModelAttribute("submitForm") @Validated UserDTO userDTO,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "login";
		}
		List<UserDTO> list   =  userService.getAllByProperty("username", userDTO.getUsername());
		if(!list.isEmpty()) {
			session.setAttribute(Constant.USER_INFO, list.get(0));
		}
		return "redirect:/index";
	}
	@GetMapping(value = {"/logout"})
	public String logout(Model model,HttpSession session) {
		session.removeAttribute(Constant.USER_INFO);
		return "redirect:/index";
	}
	
}
