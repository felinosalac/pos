package com.fsalac.form.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fsalac.form.model.PosUser;
import com.fsalac.form.model.security.CustomUserDetail;
import com.fsalac.form.service.CustomerService;
import com.fsalac.form.service.ProductService;
import com.fsalac.form.service.SupplierService;
import com.fsalac.form.service.UserService;

public class BaseController {
	
	final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	final static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	@Autowired
	protected UserService userService;

	@Autowired
	protected CustomerService customerService;
	
	@Autowired
	protected SupplierService supplierService;
	
	@Autowired
	protected ProductService productService;

	public PosUser getUserInSession() {
		
		CustomUserDetail myUserDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		PosUser userInSession =  myUserDetails.getUser();

		return userInSession;
	}
	
	public Date convertToDate(String stringDate) {
		Date date = null;
		try {

			date = formatter.parse(stringDate);
			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}
	
	public static String formatDate(Date date){
		return dateFormatter.format(date);
	}

}
