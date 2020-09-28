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
import org.springframework.web.bind.annotation.RequestMapping;

import com.tampro.dto.UserDTO;
import com.tampro.service.ProductInfoService;
import com.tampro.service.UserService;
import com.tampro.utils.Constant;
import com.tampro.utils.PasswordForm;
import com.tampro.validator.PasswordValidator;
import com.tampro.validator.UserValidator;

@Controller
@RequestMapping("/account")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	UserValidator userValidator;
	@Autowired
	PasswordValidator passwordValidator;

	
	
	@InitBinder
	public void init(WebDataBinder binder){
		if(binder.getTarget() == null) {
			return ;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
		if(binder.getTarget().getClass() == UserDTO.class){
			binder.setValidator(userValidator);
		}
		if(binder.getTarget().getClass() == PasswordForm.class) {
			binder.setValidator(passwordValidator);
		}
	}
	@GetMapping(value = {"/","","info"})
	public String showAccountInfo(Model map,HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute(Constant.USER_INFO);
		UserDTO userDTO = userService.findById(user.getId());
		map.addAttribute("submitForm", userDTO);
		return "info";
	}
	@GetMapping(value = {"/password"})
	public String accountPassword(Model map,HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute(Constant.USER_INFO);
		map.addAttribute("submitForm", new PasswordForm(user.getId()));
		return "password";
	}
	@PostMapping(value = {"/password/save"})
	public String savePassword(Model map,@ModelAttribute("submitForm") @Validated PasswordForm passwordForm
			, BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "password";
		}else {
			UserDTO userDTO = 	userService.findById(passwordForm.getIdUser());
			userDTO.setPassword(passwordForm.getNewPassword());
			userService.updatePassword(userDTO);
		}	
		return "redirect:/account/info";
	}
	@PostMapping("/save")
	public String saveInfo(Model map,HttpSession session,@ModelAttribute("submitForm") @Validated UserDTO userDTO,BindingResult result ) {
		if(result.hasErrors()) {
			return "info";
		}else {
			userDTO.setIdRole(Constant.ROLE_USER);
			userService.update(userDTO);
		}
		return "redirect:/account/info";
	}


	
}
