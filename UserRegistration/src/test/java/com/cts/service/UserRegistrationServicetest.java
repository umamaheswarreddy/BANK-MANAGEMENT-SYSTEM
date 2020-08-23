package com.cts.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.entity.User;
import com.cts.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserRegistrationServicetest {

	@Mock
	private UserRepository repo;

	@InjectMocks
	private UserRegistrationService service;

	@Test
	public void testAddUser() {
		User user = new User(1, "mahesh", "uma", "SHIVA", "SHIVA", "mahi@gmail.com", "8919196614", "AJNPU0692G",
				LocalDate.of(2019, 07, 02));
		service.save(user);
		verify(repo, times(1)).save(user);

	}
	@Test
	public void testUserExistByPan() {
		User user = new User(1, "mahesh", "uma", "SHIVA", "SHIVA", "mahi@gmail.com", "8919196614", "AJNPU0692G",
				LocalDate.of(2019, 07, 02));
		Mockito.when(repo.existsByPan("AJNPU0692G")).thenReturn(true);
		assertEquals(true, service.existsByPan("AJNPU0692G"));
	}
	
}
