package com.cts.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.entity.BankAccount;
import com.cts.exceptions.CustomerNotFoundException;
import com.cts.service.LoginService;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LoginService service;

//	@Test(expected = Exception.class)
	@Test
	@WithMockUser(username = "AJNPU0692G", roles = { "USER", "ADMIN" })
	public void getAllAccountsByPan() throws Exception {
		when(service.findAllByPan("AJNPU0692G")).thenReturn(
				Arrays.asList(new BankAccount(1, "8919196614", "ANDB0000410", "SBI", "741656538", "AJNPU0692G"),
						      new BankAccount(2, "9919196614", "ANDB0000555", "BOI", "777656538", "AJNPU0692G")));

		RequestBuilder request = MockMvcRequestBuilders.get("/user/bank/{pan}", "AJNPU0692G")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"[{\"bankAccount\":\"8919196614\",\"ifscCode\":\"ANDB0000410\",\"bankName\":\"SBI\",\"micrCode\":\"741656538\"},"
						+ "{\"bankAccount\":\"9919196614\",\"ifscCode\":\"ANDB0000555\",\"bankName\":\"BOI\",\"micrCode\":\"777656538\"}]"))
				.andReturn();
	}

	@Test
	@WithMockUser(username = "AJNPU0692G", roles = {"USER"})
	public void addBankTest() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.post("/user/addBank").accept(MediaType.APPLICATION_JSON)
				.content("{\"bid\":1, " + "\"bankAccount\":\"8919196614\",\"ifscCode\":\"ANDB0000410\",\"bankName\":\"SBI\",\"micrCode\":\"741656538\"}")
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().is(201)).andReturn();
	}

}
