package com.tampro.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.dto.OrderDTO;
import com.tampro.dto.UserDTO;
import com.tampro.service.OrderService;
import com.tampro.utils.Constant;

@RestController
@RequestMapping("/api/order")
public class OrderAPI {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping(value="/save", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> addOrder(@RequestBody OrderDTO orderDTO,HttpSession session) {
		UserDTO userDTO  = (UserDTO) session.getAttribute(Constant.USER_INFO);
		try {
			orderDTO.setIdUser(userDTO.getId());
			orderDTO.getShipmentDetails().setIdUser(userDTO.getId());
			orderService.add(orderDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
//	@PostMapping(value = "/review/add",produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<Void> reviewsAdd(@RequestBody  ReviewDTO reviewDTO,HttpSession session) {
//		UserDTO userDTO = (UserDTO) session.getAttribute(Constant.USER_INFO);
//		if(userDTO != null) {
//			reviewDTO.setIdUser(userDTO.getId());
//			reviewDTO.setName(userDTO.getName());
//			reviewDTO.setEmail(userDTO.getEmail());
//		}
//		reviewService.add(reviewDTO);
//		return new ResponseEntity<Void>(HttpStatus.CREATED);
// 	}
}
