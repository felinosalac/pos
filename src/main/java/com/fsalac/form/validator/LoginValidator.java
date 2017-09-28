package com.fsalac.form.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fsalac.form.model.LoginCredential;
import com.fsalac.form.service.UserService;

@Component
public class LoginValidator implements Validator {

	@Autowired
	UserService userService;
	
	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;

	public boolean supports(Class<?> clazz) {
		return LoginCredential.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		LoginCredential loginCredential = (LoginCredential) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");

		if(!emailValidator.valid(loginCredential.getEmail())){
			errors.rejectValue("email", "Pattern.userForm.email");
		}
	}

}