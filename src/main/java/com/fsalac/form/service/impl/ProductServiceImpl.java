package com.fsalac.form.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsalac.form.model.PosCustomer;
import com.fsalac.form.model.PosProduct;
import com.fsalac.form.service.BaseService;
import com.fsalac.form.service.ProductService;

@Service("productService")
public class ProductServiceImpl extends BaseService implements ProductService {

	@Override
	public List<PosProduct> findAll() {
		return !productDAO.all().isEmpty() ? productDAO.all() : Collections.<PosProduct>emptyList();
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(PosProduct supplier) {
		if (supplier.getId() == null) {
			supplier.setDateCreated(new Date());
			productDAO.save(supplier);
		} else {
			supplier.setDateUpdated(new Date());
			productDAO.update(supplier);
		}
	}

	@Override
	public PosProduct findById(Long id) {
		return productDAO.find(id);
	}

	@Override
	@Transactional(readOnly = false)
	public List<PosProduct> search(Map<String, String> searchCriteria) {

		String id = searchCriteria.get("id");
		String productName = searchCriteria.get("productName");

		StringBuffer sql = new StringBuffer("from PosProduct c where 1=1 ");

		if (!StringUtils.isEmpty(id)) {
			sql.append("and c.id = :id ");
		}

		if (!StringUtils.isEmpty(productName)) {
			sql.append(" and c.productName like :productName");
		}

		Query query = customerDAO.getSesssion().createQuery(sql.toString());

		if (!StringUtils.isEmpty(id)) {
			query.setParameter("id", Long.valueOf(id));
		}

		if (!StringUtils.isEmpty(productName)) {
			query.setParameter("productName", "%" + productName + "%");
		}

		@SuppressWarnings("unchecked")
		List<PosProduct> list = query.list();

		return list;
	}
	
	

}
