package com.saraya.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.saraya.app.service.CoachService;
import com.saraya.app.service.UserService;


@Configuration
@EnableWebSecurity
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

	private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	private UserService userService;
	@Autowired
	private CoachService coachService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/api").permitAll()
		.antMatchers("/h2-console").permitAll()
		.antMatchers("/api/user/**").hasAuthority("USER")
		.antMatchers("/api/coach/**").hasAuthority("COACH")
		.anyRequest().authenticated().and().formLogin();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProviderUser())
		.authenticationProvider(daoAuthenticationProviderCoach());
	}
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProviderUser() {
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setPasswordEncoder(bCryptPasswordEncoder);
		provider.setUserDetailsService(userService);
		return provider;
	}
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProviderCoach() {
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
		provider.setPasswordEncoder(bCryptPasswordEncoder);
		provider.setUserDetailsService(coachService);
		return provider;
	}

	
	
	

}
