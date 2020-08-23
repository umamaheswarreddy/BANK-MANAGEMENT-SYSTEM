package com.cts.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.User;
import com.cts.exceptions.DupicatesException;
import com.cts.service.UserRegistrationService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author 844226
 * @implNote UserRegistrationController for UserRegistration
 *
 */
@RestController
@RequestMapping("/UserRegistration")
@CrossOrigin(origins = "http://localhost:9000")
public class UserRegistrationController {

	
	@Autowired
	private UserRegistrationService service;
	
    Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);
	
	
	@GetMapping("/username")
	public String currentUserName(Principal principal) {
		return principal.getName();
	}

//	@Autowired
//	private NoOpPasswordEncoder passwordEncoder;


	/**
	 * 
	 * @param user -user details in json format
	 * @return 201 status if user added succesfull.
	 */
	@ApiOperation(value = "Add a User", consumes = "application/json", notes = "Hit this URL to insert a new USER details")
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
		
		if (!user.getPassword().equals(user.getConformPassword())) {
			logger.error("password and conform password are not matching");
			throw new DupicatesException("password and conform password are not matching");
		} 
		else if(service.existsByPan(user.getPan())) {		
			throw new DupicatesException("duplicate pan ");
		}
		else {			
			user.setRole("USER");
			service.save(user);
			logger.info("new user added successfully");
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	
	}
		


}
