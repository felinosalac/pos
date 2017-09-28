package com.fsalac.form.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fsalac.form.model.PosCustomer;
import com.fsalac.form.model.PosUser;
import com.fsalac.form.web.model.CustomerFormModel;

@Controller
public class UploadController extends BaseController{
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@RequestMapping(value = "/users/image/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model, @RequestParam long userId) {
		
		PosUser user = userService.findById(userId);
		model.addAttribute("user", user);

		logger.debug("go to upload image page");

		return "users/upload/upload-file";
	}
	
//	@RequestMapping(value = "/users/image/add", method = RequestMethod.GET)
//	public String showAddUserForm(Model model) {
//
//		logger.debug("go to upload image page");
//
//		return "users/upload/upload-file";
//	}
	
	@RequestMapping(value = "/users/file", method = RequestMethod.GET)
	public String uploadFile(Model model) {

		logger.debug("go to file upload page");

		return "users/upload/upload-file-2";
	}
	
//	@RequestMapping(value = "/users/image/upload", method = RequestMethod.POST)
//	public String uploadFileHandler(
//			@RequestParam String name,
//			@RequestParam("file") MultipartFile file) {
	
	
	
	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/users/image/upload", method = RequestMethod.POST)
	public String uploadFileHandler(@RequestParam("file") MultipartFile file,
			Model model, final RedirectAttributes redirectAttributes,  @RequestParam long userId) {

		String message = "";
		String cssStatus = "success";
		
		PosUser posUser = null;
		
		String name = file.getOriginalFilename();
		System.out.println(name);
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

				message =  "You successfully uploaded file=" + name;
				
				logger.debug("file size=" + bytes.length);
				
				posUser = userService.findById(userId);
				posUser.setPicture(bytes);
				userService.saveOrUpdate(posUser);
				
			} catch (Exception e) {
				message =  "You failed to upload " + name + " => " + e.getMessage();
				cssStatus = "danger";
			}
		} else {
			 message = "You failed to upload " + name + " because the file was empty.";
			 cssStatus = "danger";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("css", cssStatus);
		model.addAttribute("user", posUser);
		
		return "users/upload/upload-file";
	}

	/**
	 * Upload multiple file using Spring Controller
	 */
	@RequestMapping(value = "/users/upload/multiple", method = RequestMethod.POST)
	public @ResponseBody String uploadMultipleFileHandler(@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) {

		if (files.length != names.length)
			return "Mandatory information missing";

		String message = "";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

				message = message + "You successfully uploaded file=" + name + "";
				
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		}
		return message;
	}
	
	
	///Customers

	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/customers/image/upload", method = RequestMethod.POST)
	public String uploadFileHandler(@RequestParam("file") MultipartFile file,
			Model model, final RedirectAttributes redirectAttributes,  @RequestParam long id, @RequestParam long fileType) {

		String message = "";
		String cssStatus = "success";
		
		PosCustomer customer = null;
		
		String name = file.getOriginalFilename();
		System.out.println(name);
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

				message =  "You successfully uploaded file=" + name;
				
				logger.debug("file size=" + bytes.length);
				
				customer = customerService.findById(id);
				
				if(fileType == 1){
					//profile pic
					customer.setProfilePicture(bytes);
				}else{
					//signature
					customer.setSignature(bytes);
				}
				
				customerService.saveOrUpdate(customer);
				
			} catch (Exception e) {
				message =  "You failed to upload " + name + " => " + e.getMessage();
				cssStatus = "danger";
			}
		} else {
			 message = "You failed to upload " + name + " because the file was empty.";
			 cssStatus = "danger";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("css", cssStatus);
		
		CustomerFormModel customerFormModel = CustomerController.convertToFormModel(customer);
		
		Map<String, String> creditTerm = new LinkedHashMap<String, String>();
		creditTerm.put("1", "Cash");
		creditTerm.put("2", "Credit");
		
		model.addAttribute("creditTerms", creditTerm);
		model.addAttribute("customer", customerFormModel);
		
		return "customers/customer-form";
	}
	
	@RequestMapping(value = "/customers/image/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model, @RequestParam long id, @RequestParam long fileType) {

		logger.debug("go to file upload page");
		
		PosCustomer customer = customerService.findById(id);
		model.addAttribute("customer", customer);
		
		if(fileType == 1){
			//profile pic
			model.addAttribute("formTitle", "Update Dealer's Profile Picture");
			model.addAttribute("fileType", "1");
		}else{
			//signature
			model.addAttribute("formTitle", "Update Dealer's Signature");
			model.addAttribute("fileType", "2");
		}

		return "customers/upload/upload-file";
	}

}
