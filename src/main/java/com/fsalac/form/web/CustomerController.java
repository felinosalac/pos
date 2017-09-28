package com.fsalac.form.web;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fsalac.form.model.PosCustomer;
import com.fsalac.form.validator.CustomerFormValidator;
import com.fsalac.form.web.model.CustomerFormModel;

@Controller
public class CustomerController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerFormValidator customerFormValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(customerFormValidator);
	}

	@RequestMapping(value = "admin/customers", method = RequestMethod.GET)
	public String showAllUsers(Model model) {
		logger.debug("showAllCustomers()");
		model.addAttribute("customers", customerService.findAll());
		return "customers/customer-list";
	}
	
	@RequestMapping(value = "admin/customers/search", method = RequestMethod.GET)
	public String showAllUsers(Model model, @RequestParam Map<String, String> searchCriteria) {
		logger.debug("showAllCustomers()");
		model.addAttribute("customers", customerService.search(searchCriteria));
		
		model.addAttribute("id", searchCriteria.get("id"));
		model.addAttribute("firstName", searchCriteria.get("firstName"));
		model.addAttribute("lastName", searchCriteria.get("lastName"));
		model.addAttribute("phoneNumber",searchCriteria.get("phoneNumber"));
		model.addAttribute("maximumCreditLine", searchCriteria.get("maximumCreditLine"));
		model.addAttribute("creditTerm", searchCriteria.get("creditTerm"));
		model.addAttribute("registrationDate", searchCriteria.get("registrationDate"));
		
		return "customers/customer-list";
	}

	@RequestMapping(value = "admin/customers/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {
		logger.debug("showAddCustomerForm()");
		CustomerFormModel customer = new CustomerFormModel();
		
		Map<String, String> creditTerm = new LinkedHashMap<String, String>();
		creditTerm.put("1", "Cash");
		creditTerm.put("2", "Credit");
		
		model.addAttribute("creditTerms", creditTerm);
		model.addAttribute("customer", customer);
		
		return "customers/customer-form";
	}
	
	@RequestMapping(value = "admin/customers/add", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("customer") @Validated CustomerFormModel customerFormModel,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("saveOrUpdateCustomer() : {}", customerFormModel);

		if (result.hasErrors()) {
			populateDefaultModel(model);
			return "customers/customer-form";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if(customerFormModel.isNew()){
				redirectAttributes.addFlashAttribute("msg", "Customer added successfully!");
			}else{
				redirectAttributes.addFlashAttribute("msg", "Customer updated successfully!");
			}
			
			PosCustomer posCustomer = convertToDatabaseModel(customerFormModel);
			posCustomer.setCreatedBy(getUserInSession());
			
			customerService.saveOrUpdate(posCustomer);

			return "redirect:/admin/customers/" + posCustomer.getId();
		}

	}
	
	// show customer
	@RequestMapping(value = "admin/customers/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") long id, Model model) {

		logger.debug("showCustomer() id: {}", id);

		PosCustomer posCustomer = customerService.findById(id);
		
		if (posCustomer == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		
		CustomerFormModel customerFormModel = convertToFormModel(posCustomer);
		
		model.addAttribute("customer", customerFormModel);

		return "customers/customer-details";
	}

	// show update form
	@RequestMapping(value = "admin/customers/{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") long id, Model model) {

		logger.debug("showUpdateCustomerForm() : {}", id);

		PosCustomer posCustomer = customerService.findById(id);
		
		if (posCustomer == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		
		CustomerFormModel customerFormModel = convertToFormModel(posCustomer);
		
		Map<String, String> creditTerm = new LinkedHashMap<String, String>();
		creditTerm.put("1", "Cash");
		creditTerm.put("2", "Credit");
		
		model.addAttribute("creditTerms", creditTerm);
		model.addAttribute("customer", customerFormModel);

		return "customers/customer-form";

	}

	
	private void populateDefaultModel(Model model) {

		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("CN", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		model.addAttribute("countryList", country);
	}
	
	private PosCustomer convertToDatabaseModel(CustomerFormModel customerFormModel){
		
		//convert
		PosCustomer posCustomer = new PosCustomer();
		
		if(!StringUtils.isEmpty(customerFormModel.getId())){
			Long id = Long.valueOf(customerFormModel.getId());
			posCustomer = customerService.findById(id);
		}
		
		posCustomer.setFirstName(customerFormModel.getFirstName());
		posCustomer.setLastName(customerFormModel.getLastName());
		posCustomer.setAddress(customerFormModel.getAddress());
		posCustomer.setPhoneNumber(customerFormModel.getPhoneNumber());
		posCustomer.setMaximumCreditLine(Long.valueOf(customerFormModel.getMaximumCreditLine()));
		posCustomer.setCreditTerm(Long.valueOf(customerFormModel.getCreditTerm()));
		posCustomer.setRegistrationDate(convertToDate(customerFormModel.getRegistrationDate()));
		
		return posCustomer;
	}
	
	public static CustomerFormModel convertToFormModel(PosCustomer posCustomer){
		
		//convert
		CustomerFormModel customerFormModel = new CustomerFormModel();
		customerFormModel.setId(posCustomer.getId() + "");
		customerFormModel.setFirstName(posCustomer.getFirstName());
		customerFormModel.setLastName(posCustomer.getLastName());
		customerFormModel.setAddress(posCustomer.getAddress());
		customerFormModel.setPhoneNumber(posCustomer.getPhoneNumber());
		customerFormModel.setMaximumCreditLine(posCustomer.getMaximumCreditLine() + "");
		customerFormModel.setCreditTerm(posCustomer.getCreditTerm() + "");
		customerFormModel.setRegistrationDate(formatDate(posCustomer.getRegistrationDate()));
		customerFormModel.setProfilePicture(posCustomer.getProfilePicture());
		customerFormModel.setSignature(posCustomer.getSignature());
		
		return customerFormModel;
	}

}