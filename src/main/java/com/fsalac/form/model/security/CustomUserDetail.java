package com.fsalac.form.model.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fsalac.form.model.PosUser;

public class CustomUserDetail implements UserDetails{

    private static final long serialVersionUID = 1L;
    private PosUser user;

    Set<GrantedAuthority> authorities=null;

    public PosUser getUser() {
        return user;
    }

    public void setUser(PosUser user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities)
    {
        this.authorities=authorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        //return user.getProfileName();
    	return user.getUsername();
    }

    public boolean isAccountNonExpired() {
        //return user.isAccountNonExpired();
    	return user.isActive();
    }

    public boolean isAccountNonLocked() {
        //return user.isAccountNonLocked();
    	return user.isActive();
    }

    public boolean isCredentialsNonExpired() {
       // return user.isCredentialsNonExpired();
    	return user.isActive();
    }

    public boolean isEnabled() {
        //return user.isAccountEnabled();
    	return user.isActive();
    }

}