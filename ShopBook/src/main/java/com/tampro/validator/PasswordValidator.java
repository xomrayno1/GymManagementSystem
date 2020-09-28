package com.tampro.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tampro.dto.UserDTO;
import com.tampro.service.UserService;
import com.tampro.utils.PasswordForm;

@Component
public class PasswordValidator  implements Validator{
	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == PasswordForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "oldPassword", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatPassword", "msg.required");
		PasswordForm passwordForm = (PasswordForm) target;
		if(passwordForm != null) {
			if(passwordForm.getIdUser() != 0) {
				UserDTO userDTO = userService.findById(passwordForm.getIdUser());
				if(!StringUtils.isEmpty(passwordForm.getOldPassword())) {
					if(!passwordForm.getOldPassword().equals(userDTO.getPassword())) {
						errors.rejectValue("oldPassword","msg.password.wrong");
					}
				}
				if(!StringUtils.isEmpty(passwordForm.getRepeatPassword())) {
					if(!passwordForm.getNewPassword().equals(passwordForm.getRepeatPassword())) {
						errors.rejectValue("repeatPassword","msg.password.wrong");
					}
				}
			}
		}
		
	}

}
