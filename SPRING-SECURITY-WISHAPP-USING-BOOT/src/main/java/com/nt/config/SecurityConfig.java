package com.nt.config;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource ds;
	
	@Autowired
	private HttpSession ses;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds)
		.usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS_DB WHERE UNAME=?")
		.authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USERS_ROLE WHERE UNAME=?");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/welcome").access("permitAll")
		                        .antMatchers("/wmc").access("hasAnyRole('ROLE_MANAGER','ROLE_CLERK')")
		                        .and().formLogin()
		                        .and().rememberMe()
		                        .and().logout()
		                        .and().exceptionHandling().accessDeniedPage("/denied.jsp")
		                        .and().sessionManagement().maximumSessions(2).and();
	}

}
