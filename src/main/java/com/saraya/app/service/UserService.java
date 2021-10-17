package com.saraya.app.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.saraya.app.entity.AppUser;
import com.saraya.app.repository.UserRepo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(9, new SecureRandom());
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return userRepo.findByEmail(email)
				.orElseThrow(()->
					new UsernameNotFoundException(String.format("user with mail %s ot found ",email))
				);
	}
	
	public AppUser userSubscribe(AppUser user) {
		// TODO encoding & mail sender
		boolean userExists= userRepo.findByEmail(user.getUsername()).isPresent();
		if(userExists) {
			throw new IllegalStateException("email already taken");
		}
		String encodedPassword= bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		return userRepo.save(user);
	}

}
