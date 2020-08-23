package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DemoController;
import com.example.demo.entity.Investment;
import com.example.demo.repository.InvestMentRepository;
import com.example.demo.repository.MutualFundRepository;
import com.example.demo.service.InvestMentService;
import com.example.demo.service.MutualFundService;

@RunWith(SpringRunner.class)
@WebMvcTest(InvestMentController.class)
public class InvestmentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	InvestMentService service;

	@MockBean
	MutualFundService Mservice;

	@MockBean
	RestTemplate templet;

	@MockBean
	DemoController controller;
		

	@Test
	public void getAllByMutualFundIdTest() throws Exception {
		when(service.findAllByMutualFundId(1)).thenReturn(Arrays.asList(new Investment(1, 2, "8919196614", "20",new Date(), "AJNPU0692G")));

		RequestBuilder request = MockMvcRequestBuilders.get("/getAllTransaction/MutualFundId/{MutualFundId}", 1)
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json("[{\"iId\":1,\"accountNumber\":\"8919196614\",\"amountToInvest\":\"20\",\"mutulFund\":null,\"mutualFundId\":2}]")).andReturn();
	}
	
	@Test
	public void getAllByPanANDMutualFundIdTest() throws Exception {
		when(service.findAllByPanANDMutualFundId("AJNPU0692G", 1)).thenReturn(Arrays.asList(new Investment(1, 2, "8919196614", "20", new Date(), "AJNPU0692G"),new Investment(1, 2, "7419196614", "10", new Date(), "KKNPU0692G")));

		RequestBuilder request = MockMvcRequestBuilders.get("/getTransaction/pan/{pan}/mutualFundid/{MutualFundId}","AJNPU0692G", 1)
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json("[{},{}]")).andReturn();
	}
	
	@Test
	public void addInvestmentTest() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.post("/invest").accept(MediaType.APPLICATION_JSON)
				.content("{\"iId\":\"1\",\"MutualFundId\":\"1\",\"accountNumber\":\"8919196614\",\"amountToInvest\":\"20\",\"timestamp\":\"2020-08-13 20:37:04\",\"pan\":\"AJNPU0692G\"}")
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().is(201)).andReturn();
	}
	
	

}
