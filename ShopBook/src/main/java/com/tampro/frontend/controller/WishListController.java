package com.tampro.frontend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.dto.Paging;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.dto.UserDTO;
import com.tampro.dto.WishListDTO;
import com.tampro.service.ProductInfoService;
import com.tampro.service.WishListService;
import com.tampro.utils.Constant;

@Controller
@RequestMapping("/account/wishlist")
public class WishListController {
	@Autowired
	WishListService wishListService;
	@Autowired
	ProductInfoService productInfoService;
	
	@GetMapping(value = {"/",""})
	public String showWishList(Model map,HttpSession session,@RequestParam(value =  "page",required = false,defaultValue = "1") int page) {
		Paging paging = new Paging(5);
		paging.setPageIndex(page);
		UserDTO userDTO = (UserDTO) session.getAttribute(Constant.USER_INFO);
		if(userDTO != null) {
			WishListDTO dto  = new WishListDTO();
			dto.setIdUser(userDTO.getId());
			List<WishListDTO> 	wishListDTOs	= wishListService.getAll(dto, paging);
			if(!wishListDTOs.isEmpty()) {
				map.addAttribute("list", wishListDTOs);
				map.addAttribute("pageInfo", paging);
			}
		}
		return "wishlist";
	}
	@GetMapping(value = {"/add-to-wishlist"})
	public String addWishList(Model map,HttpSession session,@RequestParam("id") int id) {
		UserDTO userDTO = (UserDTO) session.getAttribute(Constant.USER_INFO);
		try {
			ProductInfoDTO infoDTO = productInfoService.findById(id);
			wishListService.add(userDTO.getId(),infoDTO.getId());
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/account/wishlist";
	}
	@GetMapping(value = {"/delete"})
	public String deleteWishList(Model map,HttpSession session,@RequestParam("id") int id) {		
		try {
			WishListDTO wishListDTO = wishListService.findById(id);
			wishListService.delete(wishListDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/account/wishlist";
	}

}
