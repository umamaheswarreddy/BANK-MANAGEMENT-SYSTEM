package com.example.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Investment;



@RunWith(SpringRunner.class)
public class InvestMentRepositoryTest {
	
	@MockBean
	private InvestMentRepository repository;
	
	@Test
	public void testRepository() {
		Investment investment = new Investment(1, 2, "8919196614", "50", new Date(), "AJNPU0692G");
		repository.save(investment);
		Assert.assertNotNull(investment.getiId());
		Assert.assertEquals("8919196614", investment.getAccountNumber());
	}
	@Test
	public void testfindAllByPan() {
		List<Investment> list = new ArrayList<>();
		Investment investment1 = new Investment(1, 2, "8919196614", "50", new Date(), "AJNPU0692G");
		Investment investment2 = new Investment(2, 1, "9999196614", "40", new Date(), "AJNPU0692G");
		list.add(investment1);
		list.add(investment2);
		when(repository.findAllByPan("AJNPU0692G")).thenReturn(Optional.of(list));
		assertEquals(2, list.size());				
	}
	@Test
	public void testFindAllByPanANDMutualFundId() {
		List<Investment> list = new ArrayList<>();
		Investment investment1 = new Investment(1, 2, "8919196614", "50", new Date(), "AJNPU0692G");
		Investment investment2 = new Investment(2, 2, "9999196614", "40", new Date(), "AJNPU0692G");
		list.add(investment1);
		list.add(investment2);
		when(repository.findAllByPanANDMutualFundId("AJNPU0692G", 2)).thenReturn(list);
		assertEquals(2, list.size());				
	}
	@Test
	public void testfindAllByMutualFundId() {
		List<Investment> list = new ArrayList<>();
		Investment investment1 = new Investment(1, 2, "8919196614", "50", new Date(), "AJNPU0692G");
		Investment investment2 = new Investment(2, 2, "9999196614", "40", new Date(), "AJNPU0692G");
		list.add(investment1);
		list.add(investment2);
		when(repository.findAllByMutualFundId(2)).thenReturn(list);
		assertEquals(2, list.size());				
	}
	

}
