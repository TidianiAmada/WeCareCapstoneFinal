package com.saraya.app.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.saraya.app.entity.AppUser;
import com.saraya.app.entity.Appointment;
import com.saraya.app.entity.Coach;
import com.saraya.app.service.AppointmentService;
import com.saraya.app.service.UserService;

// TODO mapping
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	AppointmentService appointmentService;
	@Autowired
	UserService userService;
	
	//TODO create user and coach
	
	
	@PostMapping("/register")
	public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/register").toUriString());
		return ResponseEntity.created(uri).body(userService.userSubscribe(user));
	}
	
	@GetMapping("/coachs/{coach_id}")
	public ResponseEntity<Coach> showProfileCoach(@PathVariable String coach_id) {
		return ResponseEntity.ok().body(appointmentService.viewProfileOfCoach(coach_id)); 
	}
	
	@GetMapping("/coachs")
	public ResponseEntity<List<Coach>> showAlllifecoach(){
		return ResponseEntity.ok().body(appointmentService.viewAllLifeCoachs());
	}
	
	@PostMapping("/book")
	public ResponseEntity<Appointment> bookAppointment(Appointment appointment){
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/book").toUriString());
		return ResponseEntity.created(uri).body(appointmentService.bookAppointment(appointment));
	}
	@PutMapping("/rebook") //TODO not sure that this gonna work
	public ResponseEntity<Appointment> rebookAppointment(@RequestParam Integer booking_id,@RequestParam LocalDateTime appointment_date){
		URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/rebook").toUriString());
		return ResponseEntity.created(uri).body(appointmentService.rescheduleAppointment(booking_id, appointment_date));
	}
	@DeleteMapping("/debook")
	public ResponseEntity<Void> cancelAppointment(@RequestParam Integer booking_id){
		appointmentService.cancelAppointment(booking_id);
		return ResponseEntity.ok().build();
	}
	
}
