package com.saraya.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.app.entity.Coach;


@Repository
public interface CoachRepo extends JpaRepository<Coach, String> {
	
	// 3 - all life coach
	List<Coach> findAll();
	
	// to view coach profile by user
	Coach findByCoachId(String coachId);
	Optional<Coach> findByEmail(String email);

}
