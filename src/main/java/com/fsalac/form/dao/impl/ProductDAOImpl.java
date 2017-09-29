package com.fsalac.form.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fsalac.form.dao.GenericDAOHibernate;
import com.fsalac.form.dao.ProductDAO;
import com.fsalac.form.model.PosProduct;

@Repository
public class ProductDAOImpl extends GenericDAOHibernate<PosProduct> implements ProductDAO{

	public ProductDAOImpl() {
		super(PosProduct.class);
	}

	@Override
	public List<PosProduct> findByPage(int page, int count) {
		return null;
	}

}
