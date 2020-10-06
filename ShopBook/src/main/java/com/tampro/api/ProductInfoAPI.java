package com.tampro.api;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.dto.ProductInfoDTO;
import com.tampro.service.ProductInfoService;

@RestController
@RequestMapping("/api")
public class ProductInfoAPI {
	@Autowired
	ProductInfoService productInfoService;
	
	@GetMapping(value = "/product/price/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public BigDecimal showPrice(@PathVariable("id") int id) {
		ProductInfoDTO productInfoDTO = productInfoService.findById(id);
		return productInfoDTO.getPrice();
 	}
}
