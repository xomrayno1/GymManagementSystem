package com.tampro.frontend.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.dto.OrderDTO;
import com.tampro.dto.OrderDetailDTO;
import com.tampro.dto.ProductInfoDTO;
import com.tampro.service.ProductInfoService;
import com.tampro.utils.Constant;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	ProductInfoService productInfoService;

	@GetMapping("/list")
	public String showCart(Model model , HttpSession session) {
		OrderDTO orderDTO = (OrderDTO) session.getAttribute(Constant.CART_INFO);
		if(orderDTO!=null) {
			BigDecimal totalPrice = new BigDecimal(0);
			for(OrderDetailDTO dto : orderDTO.getListDetailDTOs()) {
				totalPrice = totalPrice.add(dto.getTotalPrice());
			}
			orderDTO.setTotalPrice(totalPrice);
			orderDTO.setSales(0);
			orderDTO.setVat(0);
			session.setAttribute(Constant.CART_INFO, orderDTO);
		}
		return "cart-list";
	}

	@GetMapping("/add-to-cart")
	public String addCart(Model model,@RequestParam("id") int id,
			@RequestParam(value = "qty",defaultValue = "1",required = false) int qty,HttpSession session) {		
		OrderDTO orderDTO = (OrderDTO) session.getAttribute(Constant.CART_INFO);
		ProductInfoDTO productInfoDTO = productInfoService.findById(id);
		if(orderDTO == null ) {
			orderDTO = new OrderDTO();
			OrderDetailDTO orderDetailDTO = addToCart(productInfoDTO,qty);
			ArrayList<OrderDetailDTO> list  = new ArrayList<OrderDetailDTO>();
			list.add(orderDetailDTO);
			orderDTO.setListDetailDTOs(list);
		}else {
			boolean check = true;
			for(OrderDetailDTO detailDTO : orderDTO.getListDetailDTOs()) {
				if(detailDTO.getProductInfoDTO().getId() == id) {
					detailDTO.setPrice(detailDTO.getPrice());
					detailDTO.setQuantity(detailDTO.getQuantity() + qty);
					detailDTO.setTotalPrice(detailDTO.getPrice().multiply(new BigDecimal(detailDTO.getQuantity())));
					check = false;
					break;
				}
			}
			if(check) {
				OrderDetailDTO detailDTO = addToCart(productInfoDTO, qty);
				orderDTO.getListDetailDTOs().add(detailDTO);
			}
		}
		session.setAttribute(Constant.CART_INFO, orderDTO);
		return "redirect:/cart/list";
	}
	public OrderDetailDTO addToCart(ProductInfoDTO productInfoDTO, int qty) {
		OrderDetailDTO dto = new OrderDetailDTO();
		dto.setPrice(productInfoDTO.getPrice());
		dto.setProductInfoDTO(productInfoDTO);
		dto.setQuantity(qty);
		dto.setTotalPrice(productInfoDTO.getPrice().multiply(new BigDecimal(dto.getQuantity())));
		return dto;
	}
	@GetMapping("/delete")
	public String deleteCart(HttpSession session,@RequestParam("id") int id) {
		OrderDTO orderDTO = (OrderDTO) session.getAttribute(Constant.CART_INFO);
		if(orderDTO != null) {
			if(!orderDTO.getListDetailDTOs().isEmpty()) {
				for(OrderDetailDTO  detailDTO : orderDTO.getListDetailDTOs()) {
					if(detailDTO.getProductInfoDTO().getId() ==  id) {
						orderDTO.getListDetailDTOs().remove(detailDTO);
						break;
					}
				}
			}
		}
		session.setAttribute(Constant.CART_INFO, orderDTO);
		return  "redirect:/cart/list";
	}
	@GetMapping("/update")
	public String updateCart(HttpSession session ,@RequestParam("id") int id, @RequestParam("qty") int qty) {
		OrderDTO orderDTO = (OrderDTO) session.getAttribute(Constant.CART_INFO);
		if(orderDTO != null) {
			if(!orderDTO.getListDetailDTOs().isEmpty()) {
				for(OrderDetailDTO  detailDTO : orderDTO.getListDetailDTOs()) {
					if(detailDTO.getProductInfoDTO().getId() ==  id) {
						detailDTO.setQuantity(qty);
						detailDTO.setTotalPrice(detailDTO.getPrice().multiply(new BigDecimal(detailDTO.getQuantity())));
						break;
					}
				}
			}
		}
		session.setAttribute(Constant.CART_INFO, orderDTO);		
		return "redirect:/cart/list";
	}
	@GetMapping("/clear")
	public String clearCart(HttpSession session ) {
		session.removeAttribute(Constant.CART_INFO);	
		return "redirect:/cart/list";
	}
}
