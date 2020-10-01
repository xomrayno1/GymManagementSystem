package com.tampro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.ReviewsDAO;
import com.tampro.dto.ReviewDTO;
import com.tampro.entity.ProductInfo;
import com.tampro.entity.Reviews;
import com.tampro.entity.User;
import com.tampro.utils.ConvertToDTO;

@Service
public class ReviewsService {
	@Autowired
	ReviewsDAO<Reviews> reviewsDAO;
	public ReviewDTO findById(int id) {
		Reviews reviews = reviewsDAO.findById(Reviews.class, id);
		ReviewDTO reviewDTO = ConvertToDTO.convertReviewEntity(reviews);
		return reviewDTO;
	}
	public List<ReviewDTO> getAllByProperty(String property,  Object object){
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		for(Reviews reviews : reviewsDAO.findByProperty(property, object)) {
			ReviewDTO reviewDTO  = ConvertToDTO.convertReviewEntity(reviews);
			list.add(reviewDTO);
		}
		return list;
	}
	public void add(ReviewDTO reviewDTO) {
		Reviews reviews = new Reviews(); 
		reviews.setActiveFlag(1);
		reviews.setContent(reviewDTO.getContent());
		reviews.setCreateDate(new Date());
		reviews.setEmail(reviewDTO.getEmail());
		reviews.setName(reviewDTO.getName());
		reviews.setProductInfo(new ProductInfo(reviewDTO.getIdProduct()));
		reviews.setRating(reviewDTO.getRating());
		reviews.setUpdateDate(new Date());
		if(reviewDTO.getIdUser() != 0) {
			reviews.setUser(new User(reviewDTO.getIdUser()));
		}
	}
}
