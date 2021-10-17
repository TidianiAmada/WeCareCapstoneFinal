package com.saraya.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.app.entity.AppUser;
import com.saraya.app.entity.Appointment;
import com.saraya.app.entity.Coach;
import com.saraya.app.repository.AppointmentRepo;
import com.saraya.app.repository.CoachRepo;
import com.saraya.app.repository.UserRepo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor 
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CoachRepo coachRepo;
	@Autowired
	private AppointmentRepo appointmentRepo;
	@Autowired
	private MailService mailService;
	
	@Override
	public Coach viewProfileOfCoach(String coach_id) {
		return coachRepo.findByCoachId(coach_id);
	}

	@Override
	public AppUser viewProfileOfAppUser(String user_id) {
		return userRepo.findByUserId(user_id);
	}

	@Override
	public List<Coach> viewAllLifeCoachs() {
		return coachRepo.findAll();
	}

	@Override
	public Appointment bookAppointment(Appointment appointment) {
		// TODO is it better to pass an appointment as argument?? or Its parameters?
		Appointment rdv=appointmentRepo.save(appointment);
		mailService.send(rdv.getCoach().getUsername(), mailService.buildEmail(rdv.getCoach().getName(), rdv.toString())); 
		//TODO build email for new booking
		return rdv;
		
	}

	@Override
	public List<Appointment> viewUpcomingAppointmentsForUser(String user_id) {
		AppUser user= userRepo.findByUserId(user_id);
		return appointmentRepo.findAllByAppUser(user);
	}

	@Override
	public List<Appointment> viewUpcomingAppointmentsForCoach(String coach_id) {
		Coach coach=coachRepo.findByCoachId(coach_id);
		return appointmentRepo.findAllByCoach(coach);
	}

	@Override
	public Appointment rescheduleAppointment(Integer booking_id, LocalDateTime appointment_date) {
		Appointment rdv=appointmentRepo.findByBookingId(booking_id);
		// how to update
		rdv.setAppointmentDate(appointment_date);
		appointmentRepo.save(rdv);
		mailService.send(rdv.getCoach().getUsername(), null); //TODO build email for updated appointment
		return rdv;
	}

	@Override
	public void cancelAppointment(Integer booking_id) {
		Appointment rdv=appointmentRepo.findByBookingId(booking_id);
		appointmentRepo.delete(rdv);
		mailService.send(rdv.getCoach().getUsername(), null); //TODO build email for canceling appointment
		
	}



}
