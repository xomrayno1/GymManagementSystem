package com.tampro.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.dto.ReviewDTO;
import com.tampro.service.ReviewsService;
import com.tampro.validator.ReviewsValidator;

@RestController
@RequestMapping("/api/review")
public class ReviewsAPI {	
	@Autowired
	ReviewsService reviewService;
	@Autowired
	ReviewsValidator reviewValidator;
//	@InitBinder
//	public void binder(WebDataBinder dataBinder) {
//		if(dataBinder.getTarget() == null) {
//			return ;
//		}
//		if(dataBinder.getTarget().getClass() == ReviewDTO.class) {
//			dataBinder.setValidator(reviewValidator);
//		}
//	}
	@GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<ReviewDTO> showReviews(@PathVariable("id") int id) {
		List<ReviewDTO> list = reviewService.getAllByProperty("productInfo.id", id);
		return list;
 	}
	@PostMapping(value = "/add",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void reviewsAdd(@RequestBody ReviewDTO reviewDTO) {

		reviewService.add(reviewDTO);
 	}
}
