package com.saraya.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.saraya.app.entity.AppUser;
import com.saraya.app.entity.Appointment;
import com.saraya.app.entity.Coach;

public interface AppointmentService {

	//public Coach coachSubscribe(Coach coach);
	//public AppUser userSubscribe(AppUser user);
	
	//1 -a need for user only
	public Coach viewProfileOfCoach(String coach_id);
	//1-b need for coach only
	public AppUser viewProfileOfAppUser(String user_id);
	// 2
	public List<Coach> viewAllLifeCoachs();
	// 3
	public Appointment bookAppointment(Appointment appointment);
	// 4 a & b
	public List<Appointment> viewUpcomingAppointmentsForUser(String user_id);
	public List<Appointment> viewUpcomingAppointmentsForCoach(String coach_id);
	// 5
	public Appointment rescheduleAppointment(Integer booking_id, LocalDateTime appointment_date);
	// 6
	public void cancelAppointment(Integer booking_id);
	
	// TODO: create two controllers, one with base path /coachs and another with /users and handle the access restriction
	// with Spring Security
}
