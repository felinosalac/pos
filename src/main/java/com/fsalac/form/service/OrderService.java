package com.fsalac.form.service;

import java.util.List;
import java.util.Map;

import com.fsalac.form.model.PosOrder;

public interface OrderService {
	
	List<PosOrder> findAll();
	
	void saveOrUpdate(PosOrder order);
	
	PosOrder findById(Long id);
	
	List<PosOrder> search(Map<String, String> searchCriteria);

}
