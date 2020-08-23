package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.entity.MutualFund;
import com.example.demo.repository.MutualFundRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MutualFundServiceTest {
	
	@Mock
	private MutualFundRepository repo;

	@InjectMocks
	private MutualFundService service;
	
	
	@Test
	public void testGetAllMutualFunds() {
		List<MutualFund> list = new ArrayList<>();
		MutualFund mutualFund1 = new MutualFund(1, "GOLD FUND");
		MutualFund mutualFund2 = new MutualFund(2, "ICIC FUND");
		list.add(mutualFund1);
		list.add(mutualFund2);
		when(repo.findAll()).thenReturn(list);
		List<MutualFund> mutualFundList = service.findAll();
		assertEquals(2, mutualFundList.size());
	}

}
