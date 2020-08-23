package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.MutualFund;

@RestController
@RequestMapping("/user")
public class FeignController {
	
	@Autowired
	private DemoServiceProxy proxy;
	
	@RequestMapping("/feign/mutualFunds/all")
	public List<MutualFund> getAllMutualFunds() {
		return proxy.getAllMutualFunds();
	}

}
