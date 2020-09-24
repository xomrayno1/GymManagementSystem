package com.tampro.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tampro.dto.UserDTO;
import com.tampro.service.UserService;

@Component
public class LoginValidator  implements Validator{
	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(UserDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "msg.required");
		UserDTO userDTO = (UserDTO) target;
		
		if(!StringUtils.isEmpty(userDTO.getUsername()) && !StringUtils.isEmpty(userDTO.getPassword())) {
			List<UserDTO> userDTOs =  userService.getAllByProperty("username",userDTO.getUsername());
			if(!userDTOs.isEmpty()) {				
				if(!userDTOs.get(0).getPassword().equals(userDTO.getPassword())) {
					errors.rejectValue("password", "msg.password.wrong");
				}
			}else {
				errors.rejectValue("password", "msg.password.wrong");
			}
			
		}
		
		
	}

}
