package com.fsalac.form.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.fsalac.form.model.ModelObject;

public abstract class GenericDAOHibernate<T extends ModelObject> extends AbstractDaoSupport implements GenericDAO<T> {

	private Class<T> persistentClass;

	@Autowired
	public GenericDAOHibernate(Class<T> type) {
		this.persistentClass = type;
		
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	public String getPersistentClassName() {
		return persistentClass.getName();
	}

	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public T find(long id) {
		return (T)getHibernateTemplate().get(persistentClass, id);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> all() {
		return (List<T>) getHibernateTemplate().find("from "  + this.persistentClass.getName());
		
	}

	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}
	
	@Override
	public void initializeField(Object entity) {
		getHibernateTemplate().initialize(entity);
	
	}
	
	public Session getSesssion(){
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

}
