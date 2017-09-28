package com.fsalac.form.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fsalac.form.model.PosSupplier;
import com.fsalac.form.web.model.SupplierFormModel;

@Controller
public class SupplierController extends BaseController{
	
	private final Logger logger = LoggerFactory.getLogger(SupplierController.class);
	
	@RequestMapping(value = "admin/suppliers", method = RequestMethod.GET)
	public String showAllUsers(Model model) {
		logger.debug("showAllSuppliers()");
		model.addAttribute("suppliers", supplierService.findAll());
		return "suppliers/supplier-list";
	}
	
	@RequestMapping(value = "admin/suppliers/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {
		
		logger.debug("showAddSupplierForm()");
		SupplierFormModel supplier = new SupplierFormModel();
		
		model.addAttribute("supplier", supplier);
		
		return "suppliers/supplier-form";
	}
	
	@RequestMapping(value = "admin/suppliers/add", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("customer") @Validated SupplierFormModel supplierFormModel,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("saveOrUpdateSupplier() : {}", supplierFormModel);

		if (result.hasErrors()) {
			populateDefaultModel(model);
			return "suppliers/customer-form";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if(supplierFormModel.isNew()){
				redirectAttributes.addFlashAttribute("msg", "Supplier added successfully!");
			}else{
				redirectAttributes.addFlashAttribute("msg", "Supplier updated successfully!");
			}
			
			PosSupplier posSupplier = convertToDatabaseModel(supplierFormModel);
			posSupplier.setCreatedBy(getUserInSession());
			
			supplierService.saveOrUpdate(posSupplier);

			return "redirect:/admin/suppliers/" + posSupplier.getId();
		}

	}
	
	private PosSupplier convertToDatabaseModel(SupplierFormModel supplierFormModel){
		
		//convert
		PosSupplier posSupplier = new PosSupplier();
		
		if(!StringUtils.isEmpty(supplierFormModel.getId())){
			Long id = Long.valueOf(supplierFormModel.getId());
			posSupplier = supplierService.findById(id);
		}else{
			posSupplier.setActive(true);
		}
		
		posSupplier.setName(supplierFormModel.getName());
		posSupplier.setAddress(supplierFormModel.getAddress());
		posSupplier.setContactPersonName(supplierFormModel.getContactPersonName());
		posSupplier.setPhonePrimary(supplierFormModel.getPhonePrimary());
		posSupplier.setFax(supplierFormModel.getFax());
		posSupplier.setDiscount(supplierFormModel.getDiscount());
		
		return posSupplier;
	}
	
	public static SupplierFormModel convertToFormModel(PosSupplier posSupplier){
		
		//convert
		SupplierFormModel supplierFormModel = new SupplierFormModel();
		supplierFormModel.setId(posSupplier.getId() + "");
		supplierFormModel.setName(posSupplier.getName());
		supplierFormModel.setAddress(posSupplier.getAddress());
		supplierFormModel.setContactPersonName(posSupplier.getContactPersonName());
		supplierFormModel.setPhonePrimary(posSupplier.getPhonePrimary());
		supplierFormModel.setFax(posSupplier.getFax());
		supplierFormModel.setDiscount(posSupplier.getDiscount());
		
		return supplierFormModel;
	}
	
	private void populateDefaultModel(Model model) {

//		Map<String, String> country = new LinkedHashMap<String, String>();
//		country.put("US", "United Stated");
//		country.put("CN", "China");
//		country.put("SG", "Singapore");
//		country.put("MY", "Malaysia");
//		model.addAttribute("countryList", country);
	}

}
