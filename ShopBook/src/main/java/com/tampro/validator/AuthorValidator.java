package com.tampro.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tampro.dto.AuthorDTO;
import com.tampro.service.AuthorService;

@Component
public class AuthorValidator  implements Validator{
	
	@Autowired
	AuthorService authorService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(AuthorDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "msg.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "msg.required");
		AuthorDTO authorDTO = (AuthorDTO) target;
		if(!StringUtils.isEmpty(authorDTO.getName())) {
			List<AuthorDTO> list = authorService.getAllByProperty("name", authorDTO.getName());
			if(authorDTO.getId() != 0) {
				AuthorDTO dto = authorService.findById(authorDTO.getId());
				if(!dto.getName().equals(authorDTO.getName())) {
					if(!list.isEmpty())	{
						errors.rejectValue("name", "msg.exist");
					}
				}
			}else {
				if(!list.isEmpty())	{
					errors.rejectValue("name", "msg.exist");
				}
			}
		}	
	}
}
