package com.saraya.app.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saraya.app.entity.AppUser;


@Repository
public interface UserRepo extends JpaRepository<AppUser, String> {
	
	// to view user profile by coach
//	@Query("Select * from app_user where appuser.user_id=")
	AppUser findByUserId(String userId);
	Optional<AppUser> findByEmail(String email);

}
