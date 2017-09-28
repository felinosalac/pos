package com.fsalac.form.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fsalac.form.dao.GenericDAOHibernate;
import com.fsalac.form.dao.PosUserDAO;
import com.fsalac.form.model.PosUser;

@Repository
public class PosUserDAOImpl extends GenericDAOHibernate<PosUser> implements PosUserDAO{

	public PosUserDAOImpl() {
		super(PosUser.class);
	}

	@Override
	public List<PosUser> findByPage(int page, int count) {
		return null;
	}

}
