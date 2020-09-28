package com.tampro.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tampro.dto.AddressDTO;

@Component
public class AddressValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == AddressDTO.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "province", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "district", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commune", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "msg.required");
		
		AddressDTO addressDTO = (AddressDTO) target;
		if(!StringUtils.isEmpty(addressDTO.getPhone())) {
			if(!addressDTO.getPhone().matches("[0-9]+")) {
				errors.rejectValue("phone", "msg.wrong");
			}
		}
	}

}
