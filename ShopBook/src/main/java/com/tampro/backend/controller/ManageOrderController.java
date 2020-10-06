package com.tampro.backend.controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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
import com.tampro.dto.ProductInfoDTO;
import com.tampro.service.OrderDetailService;
import com.tampro.service.OrderService;
import com.tampro.service.ProductInfoService;

@Controller
@RequestMapping("/manage/order")
public class ManageOrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	ProductInfoService productInfoService;
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		if(dataBinder.getTarget() == null) {
			return;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@GetMapping(value = {"/list/","/list"})
	public String redirect() {
		return "redirect:/manage/order/list/1";
	}
	@RequestMapping( value = "/list/{page}")
	public String showOrderList(Model model,@ModelAttribute("searchForm") OrderDTO orderDTO,@PathVariable("page")int page) {
		Paging paging = new Paging(10);
		paging.setPageIndex(page);
		List<OrderDTO> list = orderService.getAll(orderDTO, paging);
		Collections.sort(list, new Comparator<OrderDTO>() {

			@Override
			public int compare(OrderDTO o1, OrderDTO o2) {
				// TODO Auto-generated method stub
				return o2.getStatus() - o1.getStatus();
			}
		});
		model.addAttribute("deleteForm", new OrderDTO());
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", paging);
		return "manage/order-list";
	}
	@GetMapping("/view/{id}")
	public String orderView(Model model,@PathVariable("id")int id) {
		OrderDTO orderDTO = orderService.getById("id", id);
		if(orderDTO != null) {
			List<OrderDetailDTO> list = orderDetailService.getAllByProperty("order.id", id);
			orderDTO.setListDetailDTOs(list);
			model.addAttribute("order", orderDTO);
			return "manage/order-view";
		}else {
			return "redirect:/manage/order/list/1";
		}
	}
	@GetMapping("/add")
	public String orderAdd(Model model) {
		model.addAttribute("submitForm", new OrderDTO());
		initSelect(model);
		return "manage/order-action";
	}

	@GetMapping("/detail/delete/{id}")
	public String orderDeleteDetail(Model model,@PathVariable("id")int id) {
		OrderDetailDTO orderDetailDTO = orderDetailService.findById(id);
		try {
			orderDetailService.delete(orderDetailDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/manage/order/view/"+orderDetailDTO.getIdOrder();
	}
	@GetMapping("/update-status/{id}")
	public String updateStatus(Model model,@PathVariable("id")int id,@RequestParam("status") int status) {
		OrderDTO orderDTO = orderService.getById("id", id);	
		orderDTO.setStatus(status);
		try {
			orderService.update(orderDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/manage/order/view/"+id;
	}
	public void initSelect(Model model) {
		List<ProductInfoDTO> list = productInfoService.getAll(null, null);
		Collections.sort(list,new Comparator<ProductInfoDTO>() {

			@Override
			public int compare(ProductInfoDTO o1, ProductInfoDTO o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		model.addAttribute("listProduct", list);
	}
}
