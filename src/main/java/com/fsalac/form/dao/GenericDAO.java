package com.fsalac.form.dao;

import java.util.List;

import org.hibernate.Session;

import com.fsalac.form.model.ModelObject;

public interface GenericDAO<T extends ModelObject> {

	void save(T entity);
	
	T find(long id);
	
	List<T> all();
	
	void update(T entity);
	
	void delete(T entity);
	
	void initializeField(Object entity);
	
	List<T> findByPage(int page, int count);
	
	Session getSesssion();

}
