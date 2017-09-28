package com.fsalac.form.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BaseValidator{
	
	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;

}
