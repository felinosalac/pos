package com.fsalac.form.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsalac.form.dao.PosUserDAO;
import com.fsalac.form.dao.UserDao;
import com.fsalac.form.model.PosUser;
import com.fsalac.form.service.BaseService;
import com.fsalac.form.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	PosUserDAO posUserDAO;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public PosUser findById(Long id) {
		return posUserDAO.find(id);
	}

	@Override
	public List<PosUser> findAll() {
		//return userDao.findAll();
		
		return posUserDAO.all();
	}

	@Override
	@Transactional(readOnly = false)
	public void saveOrUpdate(PosUser user) {

		if (user.getId() == null) {
			//findById(user.getId())==null
			posUserDAO.save(user);
		} else {
			posUserDAO.update(user);
		}

	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}
	
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
     
//    public PosUser findById(Long id) {
//        return userDao.findById(id);
//    }
 
    public void saveUser(PosUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateUser(PosUser user) {
    	PosUser entity = userDao.findById(user.getId());
        if(entity!=null){
            //entity.setSsoId(user.getSsoId());
            if(!user.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
        }
    }
 
    public List<PosUser> findAllUsers() {
        return userDao.findAllUsers();
    }
}