package com.tampro.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tampro.dto.AddressDTO;
import com.tampro.dto.OrderDTO;
import com.tampro.dto.ShipmentDetailsDTO;
import com.tampro.dto.UserDTO;
import com.tampro.service.AddressService;
import com.tampro.service.OrderService;
import com.tampro.utils.Constant;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {	
	@Autowired
	AddressService addressService;
	@Autowired
	OrderService orderService;
	
	@GetMapping(value = {"/shipping"})
	public String shipping(Model model,HttpSession session) {
		UserDTO userDTO = (UserDTO) session.getAttribute(Constant.USER_INFO);
		List<AddressDTO> list = addressService.getAllByProperty("user.id", userDTO.getId());
		model.addAttribute("list", list);
		return "shipping";
	}
	@GetMapping(value = {"/payment"})
	public String payment(Model model,HttpSession session,@RequestParam("id") int id) {
		UserDTO userDTO =	(UserDTO) session.getAttribute(Constant.USER_INFO);
		AddressDTO addressDTO = addressService.findById(id);
		OrderDTO orderDTO = (OrderDTO) session.getAttribute(Constant.CART_INFO);
		ShipmentDetailsDTO shipmentDetailsDTO = 	mapShipment(addressDTO);
		orderDTO.setShipmentDetails(shipmentDetailsDTO);
		orderDTO.setIdUser(userDTO.getId());
		session.setAttribute(Constant.CART_INFO, orderDTO);
		return "payment";
	}
	
	public ShipmentDetailsDTO mapShipment(AddressDTO dto) {
		ShipmentDetailsDTO shipmentDetailsDTO = new ShipmentDetailsDTO();
		shipmentDetailsDTO.setProvince(dto.getProvince());
		shipmentDetailsDTO.setDistrict(dto.getDistrict());
		shipmentDetailsDTO.setCommune(dto.getCommune());
		shipmentDetailsDTO.setName(dto.getName());
		shipmentDetailsDTO.setPhone(dto.getPhone());
		shipmentDetailsDTO.setDescription(dto.getDescription());
		shipmentDetailsDTO.setIdUser(dto.getIdUser());
		return shipmentDetailsDTO;
	}
	@GetMapping(value = {"/order"})
	public String buy(Model model,HttpSession session) {		
		OrderDTO orderDTO = (OrderDTO) session.getAttribute(Constant.CART_INFO);
		try {
			orderService.add(orderDTO);
			System.out.println("Thanh toán thành công");
			session.removeAttribute(Constant.CART_INFO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Thanh toán thất bại");
		}
		return "redirect:/cart/list";
	}

}
