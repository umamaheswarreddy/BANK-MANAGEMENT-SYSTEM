package com.example.demo.repository;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.MutualFund;


@RunWith(SpringRunner.class)
public class MutualFundRepositoryTest {

	@MockBean
	private MutualFundRepository repository;

	@Test
	public void testfindByPan() {
		Optional<MutualFund> mutualFund = Optional.ofNullable(new MutualFund(1, "GOLDFUND"));
		when(repository.findById(1)).thenReturn(mutualFund);
		Assert.assertEquals(mutualFund, repository.findById(1));
		
	}

	@Test
	public void testMutualFundRepository() {
		MutualFund mutualFund = new MutualFund(1, "GOLD FUND");
		repository.save(mutualFund);
		Assert.assertNotNull(mutualFund.getmId());
		Assert.assertEquals("GOLD FUND", mutualFund.getMutualFundName());
	}

}
