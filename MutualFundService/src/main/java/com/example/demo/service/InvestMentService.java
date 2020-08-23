package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Investment;
import com.example.demo.repository.InvestMentRepository;

@Service
public class InvestMentService {
	
	@Autowired
	private InvestMentRepository repo;

	public void save(Investment investment) {
		repo.save(investment);	
	}

	public List<Investment> findAllByPan(String pan) {		
		return repo.findAllByPan(pan).orElse(null);
	}

	public List<Investment> findAllByPanANDMutualFundId(String pan, int mutualFundId) {
		
		return repo.findAllByPanANDMutualFundId(pan, mutualFundId);
	}

	public List<Investment> findAllByMutualFundId(int mutualFundId) {
		
		return repo.findAllByMutualFundId(mutualFundId);
	}

}
