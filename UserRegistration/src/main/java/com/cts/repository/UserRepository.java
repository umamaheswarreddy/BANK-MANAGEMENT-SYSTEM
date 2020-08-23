package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.User;



public interface UserRepository extends JpaRepository<User, Integer>{

	User findByFirstName(String firstName);
	User findByEmail(String email);
	User findByPan(String pan);
	Boolean existsByPan(String pan);
	

}
