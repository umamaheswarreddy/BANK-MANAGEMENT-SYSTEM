package com.cts.repository;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.entity.BankAccount;


@RunWith(SpringRunner.class)
public class BankAccountRepositoryTest {

	@MockBean
	private BankAccountRepository repository;
	
	@Test
	public void testBankAccountRepository() {
		BankAccount bankAccount = new BankAccount(1, "8919196614", "ANDB0000410", "BOI", "7416565389", "AJNPU0692G");
		repository.save(bankAccount);
		Assert.assertNotNull(bankAccount.getPan());
		Assert.assertEquals("ANDB0000410", bankAccount.getIfscCode());

	}
	
	@Test
	public void testfindByBankAccountRepository() {
		BankAccount bankAccount = new BankAccount(1, "8919196614", "ANDB0000410", "BOI", "7416565389", "AJNPU0692G");
		when(repository.findByPan("AJNPU0692G")).thenReturn(bankAccount);
		Assert.assertEquals(bankAccount,repository.findByPan("AJNPU0692G"));		
		
	}
	
	@Test
	public void testExistsByBankAccount() {
		BankAccount bankAccount = new BankAccount(1, "8919196614", "ANDB0000410", "BOI", "7416565389", "AJNPU0692G");
		when(repository.existsByBankAccount("8919196614")).thenReturn(true);
		Assert.assertTrue(repository.existsByBankAccount("8919196614"));		
		
	}
	@Test
	public void testfindAllByPan() {
		
		List<BankAccount> list = new ArrayList<>();
		BankAccount bankAccount1 = new BankAccount(1, "8919196614", "ANDB0000410", "BOI", "7416565389", "AJNPU0692G");
		BankAccount bankAccount2 = new BankAccount(2, "7719196614", "DDDB0000410", "INDAIN", "7716565389", "AJNPU0692G");
		list.add(bankAccount1);
		list.add(bankAccount2);
		when(repository.findAllByPan("AJNPU0692G")).thenReturn(list);
		Assert.assertEquals(2,list.size());
	}
	
	
}
