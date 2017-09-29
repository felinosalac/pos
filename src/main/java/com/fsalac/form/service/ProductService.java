package com.fsalac.form.service;

import java.util.List;
import java.util.Map;

import com.fsalac.form.model.PosProduct;

public interface ProductService {
	
	List<PosProduct> findAll();
	
	void saveOrUpdate(PosProduct customer);
	
	PosProduct findById(Long id);
	
	List<PosProduct> search(Map<String, String> searchCriteria);

}
