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


@Entity
public class AppUser implements UserDetails {
	@Id
	@Column
	private String userId;
	
	private String name;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Date date_of_birth;
	
	private String email;
	
	private Integer pinCode;
	
	private String city;
	
	private String state;
	
	private String country;

	public AppUser() {
		super();
	}

	public AppUser(String name, String password, Gender gender, Date date_of_birth, String email, Integer pinCode,
			String city, String state, String country) {
		super();
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public AppUser(String user_id, String name, String password, Gender gender, Date date_of_birth, String email,
			Integer pinCode, String city, String state, String country) {
		super();
		this.userId = user_id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		
		this.email = email;
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Set The Class name as a role is a challenge here : AppUser.class.getName()
		SimpleGrantedAuthority authority= new SimpleGrantedAuthority("USER");
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param email the email to set
	 */
	public void setUsername(String email) {
		this.email = email;
	}

	/**
	 * @return the pinCode
	 */
	public Integer getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
