package com.fsalac.form.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fsalac.form.dao.CustomerDAO;
import com.fsalac.form.dao.OrderDAO;
import com.fsalac.form.dao.ProductDAO;
import com.fsalac.form.dao.SupplierDAO;

public class BaseService {
	
	@Autowired
	protected CustomerDAO customerDAO;
	
	@Autowired
	protected SupplierDAO supplierDAO;
	
	@Autowired
	protected ProductDAO productDAO;
	
	@Autowired
	protected OrderDAO orderDAO;

}
