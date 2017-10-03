package com.fsalac.form.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsalac.form.model.PosOrder;
import com.fsalac.form.service.BaseService;
import com.fsalac.form.service.OrderService;

@Service("orderService")
public class OrderServiceImpl extends BaseService implements OrderService {

	@Override
	@Transactional(readOnly=true)
	public List<PosOrder> findAll() {
		//return !orderDAO.all().isEmpty() ? orderDAO.all() : Collections.<PosOrder>emptyList();
		return !orderDAO.fetchProducts().isEmpty() ? orderDAO.fetchProducts() : Collections.<PosOrder>emptyList();
		//return Collections.<PosOrder>emptyList();
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(PosOrder posOrder) {
		if (posOrder.getId() == null) {
			posOrder.setDateCreated(new Date());
			orderDAO.save(posOrder);
		} else {
			posOrder.setDateUpdated(new Date());
			orderDAO.update(posOrder);
		}
	}

	@Override
	public PosOrder findById(Long id) {
		return orderDAO.find(id);
	}

	@Override
	@Transactional(readOnly = false)
	public List<PosOrder> search(Map<String, String> searchCriteria) {

		String id = searchCriteria.get("id");
		//String productName = searchCriteria.get("productName");

		StringBuffer sql = new StringBuffer("from PosOrder c where 1=1 ");

		if (!StringUtils.isEmpty(id)) {
			sql.append("and c.id = :id ");
		}

//		if (!StringUtils.isEmpty(productName)) {
//			sql.append(" and c.productName like :productName");
//		}

		Query query = customerDAO.getSesssion().createQuery(sql.toString());

		if (!StringUtils.isEmpty(id)) {
			query.setParameter("id", Long.valueOf(id));
		}

//		if (!StringUtils.isEmpty(productName)) {
//			query.setParameter("productName", "%" + productName + "%");
//		}

		@SuppressWarnings("unchecked")
		List<PosOrder> list = query.list();

		return list;
	}
	
	

}
