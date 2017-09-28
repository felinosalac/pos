package com.fsalac.form.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fsalac.form.model.PosUser;
import com.fsalac.form.model.UserRole;
import com.fsalac.form.service.UserService;
import com.fsalac.form.validator.UserFormValidator;

//http://www.tikalk.com/redirectattributes-new-feature-spring-mvc-31/
//https://en.wikipedia.org/wiki/Post/Redirect/Get
//http://www.oschina.net/translate/spring-mvc-flash-attribute-example
@Controller
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserFormValidator userFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// list page
	@RequestMapping(value = "admin/users", method = RequestMethod.GET)
	public String showAllUsers(Model model) {

		logger.debug("showAllUsers()");
		model.addAttribute("users", userService.findAll());
		return "users/list";

	}
	
	// show user
	@RequestMapping(value = "admin/users/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") long id, Model model) {

		logger.debug("showUser() id: {}", id);

		PosUser user = userService.findById(id);
		if (user == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("user", user);

		return "users/show";
	}

	// save or update user
	@RequestMapping(value = "admin/users/add", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated PosUser user,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("saveOrUpdateUser() : {}", user);

		if (result.hasErrors()) {
			populateDefaultModel(model);
			return "users/userform";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if(user.isNew()){
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			}else{
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}
			
			//user.setUsername("dummy username");
			//user.setPassword("dummy password");
			//user.setFirstName("dummy firstName");
			//user.setLastName("dummy lastName");
			user.setGender("Male");
			//user.setAddress1("dummy address1");
			user.setCity("dummy city");
			user.setStatus("A");
			user.setDateCreated(new Date());
			user.setDateUpdated(new Date());
			userService.saveOrUpdate(user);
			
			// POST/REDIRECT/GET
			return "redirect:/users/" + user.getId();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	// show add user form
	@RequestMapping(value = "admin/users/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {

		logger.debug("showAddUserForm()");

//		User user = new User();
//
//		// set default value
//		user.setName("mkyong123");
//		user.setEmail("test@gmail.com");
//		user.setAddress("abc 88");
//		//user.setPassword("123");
//		//user.setConfirmPassword("123");
//		user.setNewsletter(true);
//		user.setSex("M");
//		user.setFramework(new ArrayList<String>(Arrays.asList("Spring MVC", "GWT")));
//		user.setSkill(new ArrayList<String>(Arrays.asList("Spring", "Grails", "Groovy")));
//		user.setCountry("SG");
//		user.setNumber(2);
//
//		model.addAttribute("userForm", user);
//
//		populateDefaultModel(model);
		
		PosUser user = new PosUser();

		// set default value
		user.setFirstName("mkyong123");
		user.setEmail("test@gmail.com");
		user.setAddress1("abc 88");
		user.setGender("M");
		//user.setPassword("123");
		//user.setConfirmPassword("123");
		//user.setNewsletter(true);
		//user.setFramework(new ArrayList<String>(Arrays.asList("Spring MVC", "GWT")));
		//user.setSkill(new ArrayList<String>(Arrays.asList("Spring", "Grails", "Groovy")));
		//user.setCountry("SG");
		//user.setNumber(2);
		
		List<String> userRoles = new ArrayList<String>();
		userRoles.add("Spring MVC");
		userRoles.add("Struts 2");
		userRoles.add("JSF 2");
		userRoles.add("GWT");
		userRoles.add("Play");
		userRoles.add("Apache Wicket");
		
		model.addAttribute("userRoles", userRoles);
		model.addAttribute("userForm", user);

		populateDefaultModel(model);

		return "users/userform";

	}

	// show update form
	@RequestMapping(value = "admin/users/{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") long id, Model model) {

		logger.debug("showUpdateUserForm() : {}", id);

		PosUser posUser = userService.findById(id);
		model.addAttribute("userForm", posUser);
		
		populateDefaultModel(model);
		
		return "users/userform";

	}

	private void populateDefaultModel(Model model) {

		List<String> frameworksList = new ArrayList<String>();
		frameworksList.add("Spring MVC");
		frameworksList.add("Struts 2");
		frameworksList.add("JSF 2");
		frameworksList.add("GWT");
		frameworksList.add("Play");
		frameworksList.add("Apache Wicket");
		model.addAttribute("frameworkList", frameworksList);

		Map<String, String> skill = new LinkedHashMap<String, String>();
		skill.put("Hibernate", "Hibernate");
		skill.put("Spring", "Spring");
		skill.put("Struts", "Struts");
		skill.put("Groovy", "Groovy");
		skill.put("Grails", "Grails");
		model.addAttribute("javaSkillList", skill);

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		model.addAttribute("numberList", numbers);

		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("CN", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		model.addAttribute("countryList", country);

	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {

		logger.debug("handleEmptyData()");
		logger.error("Request: {}, error ", req.getRequestURL(), ex);

		ModelAndView model = new ModelAndView();
		model.setViewName("user/show");
		model.addObject("msg", "user not found");

		return model;

	}

}