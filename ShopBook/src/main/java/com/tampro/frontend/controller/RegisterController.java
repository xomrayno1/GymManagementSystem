package com.tampro.frontend.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.bind.annotation.PostMapping;

import com.tampro.dto.UserDTO;
import com.tampro.service.UserService;
import com.tampro.utils.Constant;
import com.tampro.validator.UserValidator;

@Controller
public class RegisterController {
	@Autowired
	UserValidator userValidator;
	@Autowired
	UserService userService;
	@InitBinder
	public void init(WebDataBinder binder) {
		if(binder.getTarget() == null) {
			return;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		if(binder.getTarget().getClass() == UserDTO.class) {
			binder.setValidator(userValidator);
		}
	}
	@GetMapping(value = {"/register"})
	public String register(Model model) {
		model.addAttribute("submitForm", new UserDTO());
		return "register";
	}
	@PostMapping(value = {"/processRegister"})
	public String processRegister(Model model,@ModelAttribute("submitForm") @Validated UserDTO userDTO,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "register";
		}
		try {
			userDTO.setIdRole(Constant.ROLE_USER);
			userService.add(userDTO);
			session.setAttribute(Constant.MSG_SUCCESS, "Đăng kí thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute(Constant.MSG_ERROR, "Đăng kí thất bại");
		}
		return "redirect:/login";
	}
}
