package com.fsalac.form.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsalac.form.dao.UserDao;
import com.fsalac.form.model.PosUser;
import com.fsalac.form.model.UserRole;
import com.fsalac.form.model.security.CustomUserDetail;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	//get user from the database, via Hibernate
	@Autowired
	private UserDao userDao;

	@Transactional(readOnly=true)
	@Override
	public CustomUserDetail loadUserByUsername(final String username)
		throws UsernameNotFoundException {
		
		System.out.println("WTF");

		PosUser user = userDao.findByUserName(username);
		Set<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		
		CustomUserDetail customUserDetail=new CustomUserDetail();
        customUserDetail.setUser(user);
        customUserDetail.setAuthorities(authorities);

		//return buildUserForAuthentication(user, authorities);
        return customUserDetail;
	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(PosUser user,
		List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(),
			user.isActive(), true, true, true, authorities);
	}

	private Set<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		System.out.println("WTF Again!");
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		Set<GrantedAuthority> result = new HashSet<GrantedAuthority>(setAuths);

		return result;
	}

}