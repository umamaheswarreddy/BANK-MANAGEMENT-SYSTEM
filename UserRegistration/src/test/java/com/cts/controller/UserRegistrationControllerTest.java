package com.cts.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.repository.UserRepository;
import com.cts.service.UserRegistrationService;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRegistrationService service;
		
	@Test
	public void addUserTest() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.post("/UserRegistration/add").accept(MediaType.APPLICATION_JSON)
				.content(
			   "{\"id\":1, "
				+ "\"firstName\": \"koushik\", "
				+ "\"lastName\": \"gosh\", "
				+ "\"password\": \"SHIVA\", "
				+ "\"conformPassword\":\"SHIVA\","
				+ "\"email\": \"gosh@gmail.com\", "
				+ "\"contactNumber\": \"8919196614\", "
				+ "\"pan\": \"AJNPU0692G\", "
				+ "\"contactNumber\": \"8919196614\", "
				+ "\"birthday\":\"07-20-1998\"}")
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().is(201)).andReturn();
	}
	
	

}
