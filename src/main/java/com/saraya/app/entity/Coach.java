package com.saraya.app.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;


@Entity @Data
public class Coach implements UserDetails {
	
	@Id
	@Column
	private String coachId;
	
	private String name;
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Date date_of_birth;
	
	private Long mobile_number;
	
	private String speciality;

	public Coach() {
		super();
	}

	public Coach(String name,String email, String password, Gender gender, Date date_of_birth, Long mobile_number,
			String speciality) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.mobile_number = mobile_number;
		this.speciality = speciality;
	}

	public Coach(String coach_id, String name,String email, String password, Gender gender, Date date_of_birth, Long mobile_number,
			String speciality) {
		super();
		this.coachId = coach_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.mobile_number = mobile_number;
		this.speciality = speciality;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			SimpleGrantedAuthority authority=new SimpleGrantedAuthority("COACH");
		return Collections.singletonList(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * @return the coachId
	 */
	public String getCoachId() {
		return coachId;
	}

	/**
	 * @param coachId the coachId to set
	 */
	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @param email the email to set
	 */
	public void setUsername(String email) {
		this.email = email;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * @return the date_of_birth
	 */
	public Date getDate_of_birth() {
		return date_of_birth;
	}

	/**
	 * @param date_of_birth the date_of_birth to set
	 */
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	/**
	 * @return the mobile_number
	 */
	public Long getMobile_number() {
		return mobile_number;
	}

	/**
	 * @param mobile_number the mobile_number to set
	 */
	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}

	/**
	 * @return the speciality
	 */
	public String getSpeciality() {
		return speciality;
	}

	/**
	 * @param speciality the speciality to set
	 */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
