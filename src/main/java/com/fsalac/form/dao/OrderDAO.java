package com.fsalac.form.dao;

import java.util.List;

import com.fsalac.form.model.PosOrder;

public interface OrderDAO extends GenericDAO<PosOrder> {
	
	public List<PosOrder> fetchProducts();

}
