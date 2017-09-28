package com.fsalac.form.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	  auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
//	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//	  http.authorizeRequests()
//		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
//		.and().formLogin();
//
//	}
	
//	@Autowired
//	DataSource dataSource;
//
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//
//	  auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery("select username,password, enabled from pos_users where username=?")
//		.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
//	}
	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.and().formLogin()
		.loginPage("/login")
		.failureUrl("/login?error")
		.usernameParameter("username").passwordParameter("password")
		.and()
		.logout()
		.logoutSuccessUrl("/login?logout")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/403")
		.and().csrf();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}