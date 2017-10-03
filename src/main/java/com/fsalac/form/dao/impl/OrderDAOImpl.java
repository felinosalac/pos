package com.fsalac.form.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fsalac.form.dao.GenericDAOHibernate;
import com.fsalac.form.dao.OrderDAO;
import com.fsalac.form.model.PosOrder;

@Repository
public class OrderDAOImpl extends GenericDAOHibernate<PosOrder> implements OrderDAO{

	public OrderDAOImpl() {
		super(PosOrder.class);
	}

	@Override
	public List<PosOrder> findByPage(int page, int count) {
		return null;
	}
	
	@Autowired
	public void setGenericDAOHibernate(final SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<PosOrder> fetchProducts(){
		
		List<PosOrder> orders = new ArrayList<PosOrder>();
		
		//select e from Employee e join fetch e.addresses
		orders = getHibernateTemplate().getSessionFactory().getCurrentSession()
			.createQuery("select o from PosOrder o join fetch o.customer join fetch o.product").list();
		
		return orders;
	}

}

/**
 * 
 * 
 * //List<PosOrder> orders = new ArrayList<PosOrder>();
		
		List<PosOrder> orders = (List<PosOrder>) getHibernateTemplate().find("from PosOrder o join fetch o.customer join fetch o.product "  + PosOrder.class.getName());

		//select e from Employee e join fetch e.addresses
		//orders = getSesssion().getSessionFactory().getCurrentSession()
		//	.createQuery("select o from PosOrder o join fetch o.customer join fetch o.product").list();
	*/
