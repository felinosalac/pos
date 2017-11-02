package com.fsalac.form.web;

import java.util.Date;
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
		model.addAttribute("supplierName", posProduct.getSupplierId());
		return "products/product-details";
	}
	
	// show update form
	@RequestMapping(value = "admin/products/{id}/update", method = RequestMethod.GET)
	public String showUpdateProductForm(@PathVariable("id") Long id, Model model) {
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
		model.addAttribute("product", productFormModel);
		
		PosSupplier supplier = posProduct.getSupplierId();
		if (posProduct != null) {
			supplier.setName(supplier.getName() + " (selected)");
		}
		model.addAttribute("supplier", supplier);

		return "products/product-form";

	}
	
	private PosSupplier getSupplier(Long supplierId, List<PosSupplier> suppliers){
		PosSupplier posSupplier = null;
		
		for (PosSupplier supplier : suppliers) {
			if(supplierId == supplier.getId()){
				posSupplier = supplier;
			}
		}
		return posSupplier;
	}
	
	private PosProduct convertToDatabaseModel(ProductFormModel productFormModel){
		
		//convert
		PosProduct posProduct = new PosProduct();
		boolean isNew = false;
		
		if(!StringUtils.isEmpty(productFormModel.getId())){
			Long id = Long.valueOf(productFormModel.getId());
			posProduct = productService.findById(id);
		}else{
			posProduct.setActive(true);
			isNew = true;
		}
		
		posProduct.setProductName(productFormModel.getProductName());
		posProduct.setSupplierId(supplierService.findById(Long.valueOf(productFormModel.getSupplier())));
		posProduct.setColor(productFormModel.getColor());
		posProduct.setSize(productFormModel.getSize());
		posProduct.setCatalogPrice(productFormModel.getCatalogPrice());
		
		//set more fields
		if(isNew){
			posProduct.setDateCreated(new Date(System.currentTimeMillis()));
		}else{
			posProduct.setDateUpdated(new Date(System.currentTimeMillis()));
		}
		
		return posProduct;
	}
	
	public static ProductFormModel convertToFormModel(PosProduct posProduct){
		
		//convert
		ProductFormModel productFormModel = new ProductFormModel();
		productFormModel.setId(posProduct.getId() + "");
		productFormModel.setProductName(posProduct.getProductName());
		productFormModel.setColor(posProduct.getColor());
		productFormModel.setSize(posProduct.getSize());
		productFormModel.setCatalogPrice(posProduct.getCatalogPrice());
		
		// set more fields
		
		return productFormModel;
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
