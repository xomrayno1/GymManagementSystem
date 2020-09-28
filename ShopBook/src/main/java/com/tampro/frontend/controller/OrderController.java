package com.tampro.frontend.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tampro.dto.OrderDTO;
import com.tampro.dto.Paging;
import com.tampro.dto.UserDTO;
import com.tampro.service.OrderService;
import com.tampro.utils.Constant;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	@InitBinder
	public void init(WebDataBinder binder){
		if(binder.getTarget() == null) {
			return ;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
	}
	
	@GetMapping(value = {"/list/","/list"})
	public String showOrderList(Model model){
		return "redirect:/order/list/1";
	}
	@RequestMapping("/list/{page}")
	public String showOrderList(Model model,@ModelAttribute("searchOrderForm") OrderDTO orderDTO
			,@PathVariable("page") int page,HttpSession session) {
		Paging paging = new Paging(10);
		paging.setPageIndex(page);
		UserDTO userDTO	 = (UserDTO) session.getAttribute(Constant.USER_INFO);
		if(userDTO != null) {
			orderDTO.setIdUser(userDTO.getId());
			List<OrderDTO>  list = orderService.getAllOrderByProperty(orderDTO, paging);
			model.addAttribute("list", list);
			model.addAttribute("pageInfo", paging);
		}
		return "order-list";
	}

}
