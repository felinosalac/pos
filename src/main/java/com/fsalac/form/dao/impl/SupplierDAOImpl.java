package com.fsalac.form.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fsalac.form.dao.GenericDAOHibernate;
import com.fsalac.form.dao.SupplierDAO;
import com.fsalac.form.model.PosSupplier;

@Repository
public class SupplierDAOImpl extends GenericDAOHibernate<PosSupplier> implements SupplierDAO{

	public SupplierDAOImpl() {
		super(PosSupplier.class);
	}

	@Override
	public List<PosSupplier> findByPage(int page, int count) {
		return null;
	}

}
