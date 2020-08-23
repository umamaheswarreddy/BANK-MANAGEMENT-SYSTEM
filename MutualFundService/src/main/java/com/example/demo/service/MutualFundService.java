package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MutualFund;
import com.example.demo.repository.MutualFundRepository;

@Service
public class MutualFundService {

	@Autowired
	private MutualFundRepository repo;

	public List<MutualFund> findAll() {	
		return repo.findAll();
	}

	public MutualFund findById(int mutualFundId) {
		
		return repo.findById(mutualFundId).orElse(null);
	}

}
