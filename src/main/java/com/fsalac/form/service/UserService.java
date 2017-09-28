package com.fsalac.form.service;

import java.util.List;

import com.fsalac.form.model.PosUser;

public interface UserService {

	List<PosUser> findAll();

	void saveOrUpdate(PosUser user);
	
	void delete(int id);
	
	//security methods
	PosUser findById(Long id);
    
    void saveUser(PosUser user);
     
    void updateUser(PosUser user);
     
    List<PosUser> findAllUsers();
    
}