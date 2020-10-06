package com.tampro.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.dto.ReviewDTO;
import com.tampro.dto.UserDTO;
import com.tampro.service.ProductInfoService;
import com.tampro.service.ReviewsService;
import com.tampro.utils.Constant;
import com.tampro.validator.ReviewsValidator;

@RestController
@RequestMapping("/api")
public class ReviewsAPI {	
	@Autowired
	ReviewsService reviewService;
	@Autowired
	ReviewsValidator reviewValidator;
	@Autowired
	ProductInfoService productInfoService;
//	@InitBinder
//	public void binder(WebDataBinder dataBinder) {
//		if(dataBinder.getTarget() == null) {
//			return ;
//		}
//		if(dataBinder.getTarget().getClass() == ReviewDTO.class) {
//			dataBinder.setValidator(reviewValidator);
//		}
//	}
	@GetMapping(value = "/review/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<ReviewDTO> showReviews(@PathVariable("id") int id) {
		List<ReviewDTO> list = reviewService.getAllByProperty("productInfo.id", id);
		return list;
 	}
	@PostMapping(value = "/review/add",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> reviewsAdd(@RequestBody  ReviewDTO reviewDTO,HttpSession session) {
		UserDTO userDTO = (UserDTO) session.getAttribute(Constant.USER_INFO);
		if(userDTO != null) {
			reviewDTO.setIdUser(userDTO.getId());
			reviewDTO.setName(userDTO.getName());
			reviewDTO.setEmail(userDTO.getEmail());
		}
		reviewService.add(reviewDTO);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
 	}

}
