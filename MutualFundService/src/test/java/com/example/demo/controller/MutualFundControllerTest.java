package com.example.demo.controller;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.MutualFund;
import com.example.demo.service.MutualFundService;

@RunWith(SpringRunner.class)
@WebMvcTest(MutualFundController.class)
public class MutualFundControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MutualFundService service;

	@MockBean
	private RestTemplate resttemplet;

	@Test
	public void getAllTest() throws Exception {
		when(service.findAll()).thenReturn(Arrays.asList(new MutualFund(1, "GOLD FUND"),
														 new MutualFund(2, "ICIC FUND"),
														 new MutualFund(3, "AXIS FUND")));

		RequestBuilder request = MockMvcRequestBuilders.get("/mutualFunds/all").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)
		       .andExpect(status().isOk())
		       .andExpect(content()
		    		   .json(
				"[{\"mId\":1,\"mutualFundName\":\"GOLD FUND\"},"
				+ "{\"mId\":2,\"mutualFundName\":\"ICIC FUND\"},"
				+ "{\"mId\":3,\"mutualFundName\":\"AXIS FUND\"}]"))
				.andReturn();
	}

}
