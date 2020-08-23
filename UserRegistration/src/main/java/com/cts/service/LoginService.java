package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.BankAccount;
import com.cts.repository.BankAccountRepository;

@Service
public class LoginService {

	@Autowired
	private BankAccountRepository repo;
	

	public List<BankAccount> findAllByPan(String pan) {

		return repo.findAllByPan(pan);
	}

	public int countByPan(String username) {
		return repo.countByPan(username);

	}

	public boolean existsByBankAccount(String bankAccount) {
		return repo.existsByBankAccount(bankAccount);
	}

	public void save(BankAccount account) {
		repo.save(account);

	}

}
