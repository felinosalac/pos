package com.fsalac.form.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fsalac.form.dao.CustomerDAO;
import com.fsalac.form.dao.GenericDAOHibernate;
import com.fsalac.form.model.PosCustomer;

@Repository
public class CustomerDAOImpl extends GenericDAOHibernate<PosCustomer> implements CustomerDAO{

	public CustomerDAOImpl() {
		super(PosCustomer.class);
	}

	@Override
	public List<PosCustomer> findByPage(int page, int count) {
		return null;
	}

}
