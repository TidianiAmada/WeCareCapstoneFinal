package com.saraya.app.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.saraya.app.entity.Coach;
import com.saraya.app.repository.CoachRepo;
import com.saraya.app.repository.UserRepo;

@Service
public class CoachService implements UserDetailsService {

	@Autowired
	private CoachRepo coachRepo;
	private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(9, new SecureRandom());
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return coachRepo.findByEmail(email)
				.orElseThrow(()->
					new UsernameNotFoundException(String.format("user with mail %s ot found ",email))
				);
	}
	
	public Coach coachSubscribe(Coach coach) {
		// TODO encoding & mail sender
		boolean coachExists= coachRepo.findByEmail(coach.getUsername()).isPresent();
		if(coachExists) {
			throw new IllegalStateException("email already taken");
		}
		String encodedPassword= bCryptPasswordEncoder.encode(coach.getPassword());
		coach.setPassword(encodedPassword);
		return coachRepo.save(coach);
	}

}
