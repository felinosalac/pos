package com.fsalac.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.fsalac.form.web.model.CustomerFormModel;

@Component
public class CustomerFormValidator extends BaseValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return CustomerFormModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CustomerFormModel model = (CustomerFormModel) target;
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
	}

}
