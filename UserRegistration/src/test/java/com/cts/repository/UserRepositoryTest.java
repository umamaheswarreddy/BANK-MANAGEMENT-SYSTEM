package com.cts.repository;

import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.entity.User;


@RunWith(SpringRunner.class)
public class UserRepositoryTest {
	
	@MockBean
	UserRepository repository;

	@Test
	public void testUserRepository() {
		User user = new User(1, "mahesh", "uma", "SHIVA", "SHIVA", "mahi@gmail.com", "8919196614", "AJNPU0692G", LocalDate.of(2019, 07, 02));
		repository.save(user);
		Assert.assertNotNull(user.getId());
	}
	@Test
	public void testUserExistByPan() {
		User user = new User(1, "mahesh", "uma", "SHIVA", "SHIVA", "mahi@gmail.com", "8919196614", "AJNPU0692G", LocalDate.of(2019, 07, 02));
		when(repository.existsByPan("AJNPU0692G")).thenReturn(true);
		Assert.assertTrue(repository.existsByPan("AJNPU0692G"));
	}
	@Test
	public void testfindByPan() {
		User user = new User(1, "mahesh", "uma", "SHIVA", "SHIVA", "mahi@gmail.com", "8919196614", "AJNPU0692G", LocalDate.of(2019, 07, 02));
		when(repository.findByPan("AJNPU0692G")).thenReturn(user);
		Assert.assertEquals(user, repository.findByPan("AJNPU0692G"));;
	}
	
}
