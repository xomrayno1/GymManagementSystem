package com.tampro.frontend.controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.dto.OrderDTO;
import com.tampro.dto.OrderDetailDTO;
import com.tampro.dto.Paging;
import com.tampro.dto.UserDTO;
import com.tampro.entity.Order;
import com.tampro.service.OrderDetailService;
import com.tampro.service.OrderService;
import com.tampro.utils.Constant;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailService orderDetailService;
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
			Collections.sort(list, new Comparator<OrderDTO>() {

				@Override
				public int compare(OrderDTO o1, OrderDTO o2) {
					// TODO Auto-generated method stub
					return o2.getId() - o1.getId();
				}
			});			
			model.addAttribute("list", list);
			model.addAttribute("pageInfo", paging);
		}
		return "order-list";
	}
	@GetMapping(value = {"/view/{id}"})
	public String orderView(Model model,@PathVariable("id") int id,@RequestParam(value = "page",defaultValue = "1",required = false) int page){
		OrderDTO orderDTO =	orderService.getById("id", id);
		Paging paging = new Paging(5);
		paging.setPageIndex(page);
		if(orderDTO != null) {
			List<OrderDetailDTO> listOrderDetailDTOs = orderDetailService.getAllByPropertyBySort("order.id", id, paging);
			orderDTO.setListDetailDTOs(listOrderDetailDTOs);
			model.addAttribute("order", orderDTO);
			model.addAttribute("pageInfo", paging);
			return "order-view";
		}else {
			return "redirect:/order/list/1";
		}
	}
	@GetMapping(value = {"/detail/delete/{id}"})
	public String orderDetailDelete(Model model,@PathVariable("id") int id){
		OrderDetailDTO orderDetailDTO = orderDetailService.findById(id);
		try {
			orderDetailService.delete(orderDetailDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "redirect:/order/view/"+orderDetailDTO.getIdOrder();
	}
	@GetMapping("/delete/{id}")
	public String orderCancel(Model model,@PathVariable("id")int id) {
		OrderDTO orderDTO = orderService.findById(id);
		try {
			orderService.delete(orderDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/order/list/1";
	}

}
