package com.saraya.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity @Data
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private LocalDateTime appointmentDate;
	private String slot;
	


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private AppUser appUser;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coachId")
	private Coach coach;
	
	
	public Appointment(LocalDateTime appointment_date, String slot, AppUser appUser, Coach coach) {
		super();
		this.appointmentDate = appointment_date;
		this.slot = slot;
		this.appUser = appUser;
		this.coach = coach;
	}
	
	public Appointment() {
		super();
	}


	


	
	/**
	 * @return the bookingId
	 */
	public Integer getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the appointmentDate
	 */
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * @return the slot
	 */
	public String getSlot() {
		return slot;
	}


	/**
	 * @param slot the slot to set
	 */
	public void setSlot(String slot) {
		this.slot = slot;
	}


	/**
	 * @return the appUser
	 */
	public AppUser getAppUser() {
		return appUser;
	}


	/**
	 * @param appUser the appUser to set
	 */
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}


	/**
	 * @return the coach
	 */
	public Coach getCoach() {
		return coach;
	}


	/**
	 * @param coach the coach to set
	 */
	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	@Override
	public String toString() {
		return "Appointment Info : bookingId=" + bookingId + ", appointmentDate=" + appointmentDate + ", slot= " + slot
				+ ", appUser=" + appUser.getName()+" with contact  "+appUser.getUsername() + ", coach=" + coach.getName() + "]";
	}
	
	

}
