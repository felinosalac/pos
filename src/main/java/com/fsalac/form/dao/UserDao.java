package com.fsalac.form.dao;

import java.util.List;

import com.fsalac.form.model.PosUser;

public interface UserDao {

	PosUser findById(Long id);

	List<PosUser> findAll();

	void save(PosUser user);

	void update(PosUser user);

	void delete(Integer id);
	
    List<PosUser> findAllUsers();
    
    PosUser findByUserName(String username);

}