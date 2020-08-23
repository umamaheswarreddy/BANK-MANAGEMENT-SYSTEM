package com.example.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "bms-service")
public interface UserRegistrationServiceProxy {
	
	@GetMapping("/UserRegistration/username")
	public String currentUserName();
    
	@GetMapping("/UserRegistration/get")
	public String get();
	
	@RequestMapping("/user/test")
	public String test() ;
	
	
}
