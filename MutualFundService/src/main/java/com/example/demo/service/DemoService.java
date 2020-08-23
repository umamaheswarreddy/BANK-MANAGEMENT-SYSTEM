package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DemoController;

@Service
public class DemoService {
	
	@Autowired
	private DemoController controller;
	
	public String currentUserName() {
		return controller.currentUserName();
	}

}
