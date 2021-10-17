package com.saraya.app.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.saraya.app.entity.AppUser;
import com.saraya.app.entity.Coach;
import com.saraya.app.service.AppointmentService;
import com.saraya.app.service.CoachService;

@RestController @RequestMapping("/api/coach")
public class CoachController {

	@Autowired
	AppointmentService appointmentService;
	@Autowired
	CoachService coachService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Coach> saveCoach(Coach coach) {
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/register").toUriString());
		return ResponseEntity.created(uri).body(coachService.coachSubscribe(coach));
	}
	@GetMapping("/users/{userId}")
	public AppUser showProfileUser(@PathVariable String userId) {
		return appointmentService.viewProfileOfAppUser(userId);
	}

	
	

	
}
