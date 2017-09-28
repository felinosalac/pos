package com.fsalac.form.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import javax.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fsalac.form.model.LoginCredential;
import com.fsalac.form.validator.LoginValidator;

//http://www.tikalk.com/redirectattributes-new-feature-spring-mvc-31/
//https://en.wikipedia.org/wiki/Post/Redirect/Get
//http://www.oschina.net/translate/spring-mvc-flash-attribute-example
@Controller
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginValidator loginValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(loginValidator);
	}
	
	
	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public String index(Model model) {
		logger.debug("login()");
		
		LoginCredential loginCredential = new LoginCredential();

		model.addAttribute("loginCredentialForm", loginCredential);
		
		return "security/login";
	}
	
	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("loginCredentialForm") @Validated LoginCredential loginCredential,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("login() : {}", loginCredential);
		
		if (result.hasErrors()) {
			return "security/login";
		}
		
		return "redirect:/users";

	}

}