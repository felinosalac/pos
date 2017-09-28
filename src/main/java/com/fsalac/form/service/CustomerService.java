package com.fsalac.form.service;

import java.util.List;
import java.util.Map;

import com.fsalac.form.model.PosCustomer;

public interface CustomerService {
	
	List<PosCustomer> findAll();
	
	void saveOrUpdate(PosCustomer customer);
	
	PosCustomer findById(Long id);
	
	List<PosCustomer> search(Map<String, String> searchCriteria);

}
