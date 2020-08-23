package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MutualFund;
import com.example.demo.exceptions.InvestmentNotFoundException;
import com.example.demo.service.MutualFundService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mutualFunds")
public class MutualFundController {
	
	@Autowired
	private MutualFundService sevice;
	
	 Logger logger = LoggerFactory.getLogger(MutualFundController.class);

	/**
	 * @return list of all mutual funds
	 */
	@ApiOperation(value = "list of all a mutualFunds", consumes = "application/json", notes = "Hit this URL to show all mutualFunds")
	@GetMapping("/all")
	public List<MutualFund> getAllMutualFunds(){
		List<MutualFund> mutualFunds= sevice.findAll();
		if(mutualFunds.isEmpty()) {
			logger.error("no mutual funds to show");
			throw new InvestmentNotFoundException("no mutual funds to show");
		}
		else {
			logger.info("succesfull");
			return mutualFunds;
		}
	}
	
}
