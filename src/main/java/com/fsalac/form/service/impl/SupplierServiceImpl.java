package com.fsalac.form.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsalac.form.model.PosSupplier;
import com.fsalac.form.service.BaseService;
import com.fsalac.form.service.SupplierService;

@Service("supplierService")
public class SupplierServiceImpl extends BaseService implements SupplierService {

	@Override
	public List<PosSupplier> findAll() {
		return supplierDAO.all();
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(PosSupplier supplier) {
		if (supplier.getId() == null) {
			supplier.setDateCreated(new Date());
			supplierDAO.save(supplier);
		} else {
			supplier.setDateUpdated(new Date());
			supplierDAO.update(supplier);
		}
	}

	@Override
	public PosSupplier findById(Long id) {
		return supplierDAO.find(id);
	}

	@Override
	@Transactional(readOnly = false)
	public List<PosSupplier> search(Map<String, String> searchCriteria) {
		String id = searchCriteria.get("id");
		String firstName = searchCriteria.get("firstName");
		String lastName = searchCriteria.get("lastName");
		String maximumCreditLine = searchCriteria.get("maximumCreditLine");
		
		StringBuffer sql = new StringBuffer("from Possupplier c where 1=1 ");
		
		if(!StringUtils.isEmpty(id)){
			sql.append("and c.id = :id ");
		}
		
		if(!StringUtils.isEmpty(firstName)){
			sql.append(" and c.firstName like :firstName");
		}
		
		if(!StringUtils.isEmpty(lastName)){
			sql.append(" and c.lastName like :lastName");
		}
		
		if(!StringUtils.isEmpty(maximumCreditLine)){
			sql.append(" and c.maximumCreditLine = :maximumCreditLine");
		}
		
		Query query = supplierDAO.getSesssion().createQuery(sql.toString());
		
		if(!StringUtils.isEmpty(id)){
			query.setParameter("id", Long.valueOf(id));
		}
		
		if(!StringUtils.isEmpty(firstName)){
			query.setParameter("firstName",  "%" + firstName + "%");
		}
		
		if(!StringUtils.isEmpty(lastName)){
			query.setParameter("lastName",  "%" + lastName + "%");
		}
		
		if(!StringUtils.isEmpty(maximumCreditLine)){
			query.setParameter("maximumCreditLine", Long.valueOf(maximumCreditLine));
		}
		
		
		@SuppressWarnings("unchecked")
		List<PosSupplier> list = query.list();
		
		return list;
	}

}
