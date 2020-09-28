package com.tampro.backend.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import org.springframework.web.bind.annotation.RequestMapping;

import com.tampro.dto.AuthDTO;
import com.tampro.dto.MenuDTO;
import com.tampro.dto.RoleDTO;
import com.tampro.dto.UserDTO;
import com.tampro.dto.UserRoleDTO;
import com.tampro.service.UserService;
import com.tampro.utils.Constant;
import com.tampro.validator.LoginValidator;

@Controller
@RequestMapping(value = "/manage")
public class LoginAdminController {
	@Autowired
	LoginValidator loginValidator;
	@Autowired
	UserService userService;
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		if(dataBinder.getTarget() == null) {
			return;
		}
		if(dataBinder.getTarget().getClass() == UserDTO.class) {
			dataBinder.setValidator(loginValidator);
		}
	}
	
	@GetMapping("/login")
	public String login(Model model,HttpSession session) {
		if(session.getAttribute(Constant.USER_INFO) != null) {
			return "redirect:/manage/index";
		}
		model.addAttribute("loginForm", new UserDTO());
		return "manage/login";
	}
	@PostMapping("/processLogin")
	public String processLogin(Model model,@ModelAttribute("loginForm") @Validated  UserDTO userDTO,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "manage/login";
		}
		UserDTO user = userService.getAllByProperty("username", userDTO.getUsername()).get(0);
		UserRoleDTO userRoleDTO  = user.getUserRoleDTOs().iterator().next();
		RoleDTO roleDTO = userRoleDTO.getRoleDTO();
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		for(AuthDTO auth  : roleDTO.getAuths()) {
			MenuDTO menuDTO = auth.getMenuDTO();
			if(menuDTO.getActiveFlag() == 1 && menuDTO.getOrderIndex() != -1) {
				menuDTO.setIdMenu(menuDTO.getUrl().replace("/", "")+"Id");
				list.add(menuDTO);
			}
		}
		List<MenuDTO> listParent = new ArrayList<MenuDTO>();
		List<MenuDTO> listChild = new ArrayList<MenuDTO>();
		for(MenuDTO menuDTO : list) {
			if(menuDTO.getIdParent() == 0) {
				listParent.add(menuDTO);
			}else {
				listChild.add(menuDTO);
			}
		}
		for(MenuDTO menuDTO : listParent) {
			List<MenuDTO> listM = new ArrayList<MenuDTO>();
			for(MenuDTO item : listChild) {
				if(menuDTO.getId() == item.getIdParent()) {
					listM.add(item);
				}
			}
			menuDTO.setChildMenu(listM);
		}	
		sortMenu(listParent);
		for(MenuDTO menuDTO : listParent) {
			sortMenu(menuDTO.getChildMenu());
		}
		session.setAttribute(Constant.MENU_STRING, listParent);
		session.setAttribute(Constant.USER_INFO, user);
		return "redirect:/manage/index";
	}
	@GetMapping("/index")
	public String index(Model model) {
		
		return "manage/index";
	}
	@GetMapping("/logout")
	public String logout(Model model,HttpSession session) {
		session.removeAttribute(Constant.USER_INFO);
		return "redirect:/manage/login";
	}
	@GetMapping("/access-denied")
	public String accessDenied(Model model) {
		model.addAttribute("loginForm", new UserDTO());
		return "manage/access-denied";
	}
	public void sortMenu(List<MenuDTO> list) {
		Collections.sort(list, new Comparator<MenuDTO>() {

			@Override
			public int compare(MenuDTO o1, MenuDTO o2) {
				// TODO Auto-generated method stub
				return o1.getOrderIndex() - o2.getOrderIndex();
			}
		});
	}
}
