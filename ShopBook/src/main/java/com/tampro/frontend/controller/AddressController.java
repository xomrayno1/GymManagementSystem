package com.tampro.frontend.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.dto.AddressDTO;
import com.tampro.dto.UserDTO;
import com.tampro.service.AddressService;
import com.tampro.utils.Constant;
import com.tampro.validator.AddressValidator;

@Controller
@RequestMapping("/account/address")
public class AddressController {
	@Autowired
	AddressService addressService;
	@Autowired
	AddressValidator addressValidator;
	@InitBinder
	public void init(WebDataBinder binder){
		if(binder.getTarget() == null) {
			return ;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
		if(binder.getTarget().getClass() == AddressDTO.class){
			binder.setValidator(addressValidator);
		}
	}
	@GetMapping(value = {"/list"})
	public String showAddress(Model map,HttpSession session) {
		UserDTO userDTO = (UserDTO) session.getAttribute(Constant.USER_INFO);
		List<AddressDTO> list = addressService.getAllByProperty("user.id", userDTO.getId());
		map.addAttribute("list", list);
		return "address-list";
	}
	@GetMapping(value = {"/add"})
	public String addAddress(Model map) {
		map.addAttribute("submitForm", new AddressDTO());
		map.addAttribute("title", "Thêm địa chỉ");
		return "address-action";
	}
	@PostMapping(value = {"/save"})
	public String saveAddress(Model map,HttpSession session,@ModelAttribute("submitForm") @Validated AddressDTO addressDTO,BindingResult result) {
		if(result.hasErrors()) {
			if(addressDTO.getId() != 0) {
				map.addAttribute("title", "Sửa địa chỉ");
			}else {
				map.addAttribute("title", "Thêm địa chỉ");
			}
			return "address-action";
		}
		try {
			UserDTO userDTO = (UserDTO) session.getAttribute(Constant.USER_INFO);
			addressDTO.setIdUser(userDTO.getId());
			if(addressDTO.getId() != 0) {
				addressService.update(addressDTO);
			}else {
				addressService.add(addressDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/account/address/list";
	}
	@GetMapping(value = {"/edit"})
	public String editAddress(Model map,HttpSession session,@RequestParam("id") int id) {
		AddressDTO addressDTO = addressService.findById(id);
		map.addAttribute("title", "Sửa địa chỉ");
		map.addAttribute("submitForm", addressDTO);
		return "address-action";
	}
	@GetMapping(value = {"/delete"})
	public String deleteAddress(Model map,HttpSession session,@RequestParam("id") int id) {
		AddressDTO addressDTO = addressService.findById(id);
		try {
			addressService.delete(addressDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/account/address/list";
	}
	public static void main(String[] args) {
	}
}
