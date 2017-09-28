package com.fsalac.form.service;

import java.util.List;
import java.util.Map;

import com.fsalac.form.model.PosSupplier;

public interface SupplierService {
	
	List<PosSupplier> findAll();
	
	void saveOrUpdate(PosSupplier customer);
	
	PosSupplier findById(Long id);
	
	List<PosSupplier> search(Map<String, String> searchCriteria);

}
