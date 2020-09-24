package com.tampro.validator;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tampro.dto.ProductInfoDTO;
import com.tampro.service.ProductInfoService;

@Component
public class ProductInfoValidator implements Validator {
	@Autowired
	ProductInfoService productInfoService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(ProductInfoDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ISBN", "msg.required");
		ProductInfoDTO productInfoDTO = (ProductInfoDTO) target;
		if(!StringUtils.isEmpty(productInfoDTO.getCode()) && !StringUtils.isEmpty(productInfoDTO.getISBN()) ) {
			List<ProductInfoDTO> list = productInfoService.getAllByProperty("code", productInfoDTO.getCode());
			List<ProductInfoDTO> listISBN = productInfoService.getAllByProperty("ISBN", productInfoDTO.getISBN());
			if(productInfoDTO.getId() != 0) {
				ProductInfoDTO dto = productInfoService.findById(productInfoDTO.getId());
				if(!dto.getCode().equals(productInfoDTO.getCode())) {
					if(!list.isEmpty())	{
						errors.rejectValue("code", "msg.exist");
					}
				}
				if(!dto.getISBN().equals(productInfoDTO.getISBN())) {
					if(!list.isEmpty())	{
						errors.rejectValue("ISBN", "msg.exist");
					}
				}
			}else {
				if(!list.isEmpty())	{
					errors.rejectValue("code", "msg.exist");
				}
				if(!listISBN.isEmpty())	{
					errors.rejectValue("ISBN", "msg.exist");
				}
			}			
		}
		if(productInfoDTO.getIdAuthor() == 0 ) {
			errors.rejectValue("idAuthor", "msg.required");
		}
		if(productInfoDTO.getIdPublisher() == 0 ) {
			errors.rejectValue("idPublisher", "msg.required");
		}
		if(productInfoDTO.getIdCategory() == 0 ) {
			errors.rejectValue("idCategory", "msg.required");
		}
		if(productInfoDTO.getId() == 0) {
			if(productInfoDTO.getMultipartFile().getOriginalFilename().isEmpty())	{
				errors.rejectValue("multipartFile", "msg.required");
			}
		}
		if(productInfoDTO.getDateOfPublication() != null) {
			Date dateCurrent = new Date();
			if(!dateCurrent.after(productInfoDTO.getDateOfPublication())) {
				errors.rejectValue("dateOfPublication", "msg.date.wrong");
			}
		}
	}

}
