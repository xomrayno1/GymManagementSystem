package com.tampro.validator;

import java.util.Date;
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
public class UserValidator  implements Validator{
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
		UserDTO userDTO = (UserDTO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "msg.required");
		if(!StringUtils.isEmpty(userDTO.getUsername()) && !StringUtils.isEmpty(userDTO.getEmail()) ) {
			List<UserDTO> list = userService.getAllByProperty("username", userDTO.getUsername());
			List<UserDTO> listEmail = userService.getAllByProperty("email", userDTO.getEmail());
			if(userDTO.getId() != 0) {
				UserDTO dto = userService.findById(userDTO.getId());
				if(!dto.getEmail().equals(userDTO.getEmail())) {
					if(!listEmail.isEmpty())	{
						errors.rejectValue("email", "msg.exist");
					}
				}
				if(!dto.getUsername().equals(userDTO.getUsername())) {
					if(!list.isEmpty())	{
						errors.rejectValue("username", "msg.exist");
					}
				}
			}else {
				if(!list.isEmpty())	{
					errors.rejectValue("username", "msg.exist");
				}
				if(!listEmail.isEmpty())	{
					errors.rejectValue("email", "msg.exist");
				}
			}			
		}
		if(userDTO.getBirthDay() != null  ){
			if( !userDTO.getBirthDay().before( new Date()) ) {
				errors.rejectValue("birthDay", "msg.date.wrong");
			}
		}
	}
	

}
