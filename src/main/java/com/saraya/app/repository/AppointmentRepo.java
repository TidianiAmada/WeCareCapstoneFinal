package com.saraya.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.app.entity.AppUser;
import com.saraya.app.entity.Appointment;
import com.saraya.app.entity.Coach;


@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
	
//	List<Appointment> findAllByAppointmentDate(LocalDate appointment_date);
	
	// List<Appointment> findAllByUserId(String user_id);
	
	
	// 1-a Profile of User, need by coach look to userRepo
	// 1-b Profile of Coach, need by user look to coachRepo
	
	// Appointement of a user or coarch
	
	// 2 Booking an appointment, use save built in method
	
// 3 is given by CoachRepo
	// 4- To keep it simple we'll retrieve all appointments
//	List<Appointment> findAllByUserId(String userId);
//	List<Appointment> findAllByCoachId(String coachId);
	List<Appointment> findAllByAppUser(AppUser user);
	List<Appointment> findAllByCoach(Coach coach);
	
	
	// TODO: 3+ retrieve a Sorted and Sized Pageable of upcomming appointments
	
	// 5- reschedule an appointment, use findByBookingId then set and save
	Appointment findByBookingId(Integer booking_id);
	// 6- cancel an appointment, use findById then delete
	
	

}
