package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.entity.Investment;
import com.example.demo.repository.InvestMentRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class InvestMentServiceTest {
	
	@Mock
	private InvestMentRepository repo;

	@InjectMocks
	private InvestMentService service;
	
	@Test
	public void testAddBankAccount() {
		Investment investment = new Investment(1, 2, "8919196614", "50", new Date(), "AJNPU0692G");
		service.save(investment);
		verify(repo, times(1)).save(investment);
	}
	
	@Test
	public void testFindAllByPan() {
		List<Investment> list = new ArrayList<>();
		Investment investment1 = new Investment(1, 2, "8919196614", "50", new Date(), "AJNPU0692G");
		Investment investment2 = new Investment(2, 1, "9999196614", "40", new Date(), "AJNPU0692G");
		list.add(investment1);
		list.add(investment2);
		when(repo.findAllByPan("AJNPU0692G")).thenReturn(Optional.of(list));
		List<Investment> InvestmentList = service.findAllByPan("AJNPU0692G");
		assertEquals(2, InvestmentList.size());
	}
	
	@Test
	public void testFindAllByPanANDMutualFundId() {
		List<Investment> list = new ArrayList<>();
		Investment investment1 = new Investment(1, 2, "8919196614", "50", new Date(), "AJNPU0692G");
		Investment investment2 = new Investment(2, 2, "9999196614", "40", new Date(), "AJNPU0692G");
		list.add(investment1);
		list.add(investment2);
		when(repo.findAllByPanANDMutualFundId("AJNPU0692G", 2)).thenReturn(list);
		List<Investment> InvestmentList = service.findAllByPanANDMutualFundId("AJNPU0692G", 2);
		assertEquals(2, InvestmentList.size());
	}
	@Test
	public void testfindAllByMutualFundId() {
		List<Investment> list = new ArrayList<>();
		Investment investment1 = new Investment(1, 2, "8919196614", "50", new Date(), "AJNPU0692G");
		Investment investment2 = new Investment(2, 2, "9999196614", "40", new Date(), "AJNPU0692K");
		list.add(investment1);
		list.add(investment2);
		when(repo.findAllByMutualFundId(2)).thenReturn(list);
		List<Investment> InvestmentList = service.findAllByMutualFundId(2);
		assertEquals(2, InvestmentList.size());
	}
	
	

}
