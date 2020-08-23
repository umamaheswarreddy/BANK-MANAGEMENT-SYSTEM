package com.cts.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.fallbackfactoryhandling.FundFallbackFactory;
import com.cts.model.Investment;
import com.cts.model.MutualFund;

@FeignClient(name = "demo-service",fallbackFactory =FundFallbackFactory.class)
public interface DemoServiceProxy {

	@RequestMapping("/get")
	public String get();

	@RequestMapping("/mutualFunds/all")
	public List<MutualFund> getAllMutualFunds();

	@GetMapping("/getTransaction/{iId}")
	public Investment findByInvestmentid(@PathVariable int iId);
	
	

}
