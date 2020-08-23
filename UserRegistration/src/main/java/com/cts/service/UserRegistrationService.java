package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.User;
import com.cts.repository.UserRepository;

@Service
public class UserRegistrationService {

	@Autowired
	private UserRepository repo;

	public void save(User user) {
		repo.save(user);
	}

	public boolean existsByPan(String pan) {
		return repo.existsByPan(pan);
	}

}
