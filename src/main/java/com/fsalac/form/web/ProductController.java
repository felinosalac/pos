package com.fsalac.form.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fsalac.form.model.PosProduct;
import com.fsalac.form.model.PosSupplier;
import com.fsalac.form.web.model.ProductFormModel;

@Controller
public class ProductController extends BaseController{
	
	private final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value = "admin/products", method = RequestMethod.GET)
	public String showAllProducts(Model model) {
		logger.debug("showAllProducts()");
		model.addAttribute("products", productService.findAll());
		return "products/product-list";
	}
	
	@RequestMapping(value = "admin/products/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {
		
		logger.debug("showAddproductForm()");
		ProductFormModel product = new ProductFormModel();
		model.addAttribute("product", product);
		
		//set the suppliers object that will be used in select element
		List<PosSupplier> suppliers = supplierService.findAll();
		model.addAttribute("suppliers", suppliers);
		
		return "products/product-form";
	}
	
	@RequestMapping(value = "admin/products/add", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("product") @Validated ProductFormModel ProductFormModel,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("saveOrUpdateproduct() : {}", ProductFormModel);

		if (result.hasErrors()) {
			populateDefaultModel(model);
			return "products/product-form";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if(ProductFormModel.isNew()){
				redirectAttributes.addFlashAttribute("msg", "product added successfully!");
			}else{
				redirectAttributes.addFlashAttribute("msg", "product updated successfully!");
			}
			
			PosProduct posProduct = convertToDatabaseModel(ProductFormModel);
			posProduct.setCreatedBy(getUserInSession());
			
			productService.saveOrUpdate(posProduct);

			return "redirect:/admin/products/" + posProduct.getId();
		}

	}
	
	// show customer
	@RequestMapping(value = "admin/products/{id}", method = RequestMethod.GET)
	public String showProduct(@PathVariable("id") long id, Model model) {
		logger.debug("showProduct() id: {}", id);
		PosProduct posProduct = productService.findById(id);
		if (posProduct == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Product not found");
		}
		ProductFormModel productFormModel = convertToFormModel(posProduct);
		model.addAttribute("product", productFormModel);
		return "products/product-details";
	}
	
	// show update form
	@RequestMapping(value = "admin/products/{id}/update", method = RequestMethod.GET)
	public String showUpdateProductForm(@PathVariable("id") long id, Model model) {
		logger.debug("showUpdateProductForm() : {}", id);
		PosProduct posProduct = productService.findById(id);
		
		if (posProduct == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "Product not found");
		}
		
		ProductFormModel productFormModel = convertToFormModel(posProduct);
		
		//set the suppliers object that will be used in select element
		List<PosSupplier> suppliers = supplierService.findAll();
		model.addAttribute("suppliers", suppliers);
		
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("product", productFormModel);

		return "products/product-form";

	}
	
	private PosProduct convertToDatabaseModel(ProductFormModel productFormModel){
		
		//convert
		PosProduct posProduct = new PosProduct();
		
		if(!StringUtils.isEmpty(productFormModel.getId())){
			Long id = Long.valueOf(productFormModel.getId());
			posProduct = productService.findById(id);
		}else{
			posProduct.setActive(true);
		}
		
		posProduct.setProductName(productFormModel.getProductName());
		posProduct.setSupplierId(supplierService.findById(Long.valueOf(productFormModel.getSupplier())));
		
		//set more fields
		
		return posProduct;
	}
	
	public static ProductFormModel convertToFormModel(PosProduct PosProduct){
		
		//convert
		ProductFormModel ProductFormModel = new ProductFormModel();
		ProductFormModel.setId(PosProduct.getId() + "");
		ProductFormModel.setProductName(PosProduct.getProductName());
		// set more fields
		
		return ProductFormModel;
	}
	
	private void populateDefaultModel(Model model) {

//		Map<String, String> country = new LinkedHashMap<String, String>();
//		country.put("US", "United Stated");
//		country.put("CN", "China");
//		country.put("SG", "Singapore");
//		country.put("MY", "Malaysia");
//		model.addAttribute("countryList", country);
	}
	
	

	@RequestMapping(value = "admin/products/search", method = RequestMethod.GET)
	public String searchProducts(Model model, @RequestParam Map<String, String> searchCriteria) {
		logger.debug("searchProducts()");
		model.addAttribute("products", productService.search(searchCriteria));
		
		model.addAttribute("id", searchCriteria.get("id"));
		model.addAttribute("productName", searchCriteria.get("productName"));
//		model.addAttribute("lastName", searchCriteria.get("lastName"));
//		model.addAttribute("phoneNumber",searchCriteria.get("phoneNumber"));
//		model.addAttribute("maximumCreditLine", searchCriteria.get("maximumCreditLine"));
//		model.addAttribute("creditTerm", searchCriteria.get("creditTerm"));
//		model.addAttribute("registrationDate", searchCriteria.get("registrationDate"));
		
		return "products/product-list";
	}

}
