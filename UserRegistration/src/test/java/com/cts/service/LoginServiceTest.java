package com.cts.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cts.entity.BankAccount;
import com.cts.repository.BankAccountRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginServiceTest {
	
	@Mock
	private BankAccountRepository repo;

	@InjectMocks
	private LoginService service;
	
	@Test
	public void testAddEmp() {
		BankAccount bankAccount = new BankAccount(1, "8919196614", "ANDB0000410", "BOI", "7416565389", "AJNPU0692G");
		service.save(bankAccount);
		verify(repo, times(1)).save(bankAccount);

	}
	
	@Test
	public void testExstingByAccountNumber() {
		BankAccount bankAccount = new BankAccount(1, "8919196614", "ANDB0000410", "BOI", "7416565389", "AJNPU0692G");
		Mockito.when(repo.existsByBankAccount("8919196614")).thenReturn(true);
		Assert.assertTrue(service.existsByBankAccount("8919196614"));

	}
	@Test
	public void testCountByPan() {
		BankAccount bankAccount = new BankAccount(1, "8919196614", "ANDB0000410", "BOI", "7416565389", "AJNPU0692G");
		Mockito.when(repo.countByPan("AJNPU0692G")).thenReturn(1);
		Assert.assertEquals(1, service.countByPan("AJNPU0692G"));;

	}
	
	@Test
	public void testFindAllByPan() {
		List<BankAccount> list = new ArrayList<>();
		BankAccount bankAccount1 = new BankAccount(1, "8919196614", "ANDB0000410", "BOI", "7416565389", "AJNPU0692G");
		BankAccount bankAccount2 = new BankAccount(2, "7719196614", "DDDB0000410", "INDAIN", "7716565389", "AJNPU0692G");
		list.add(bankAccount1);
		list.add(bankAccount2);
		when(repo.findAllByPan("AJNPU0692G")).thenReturn(list);
		List<BankAccount> bankAccountList = service.findAllByPan("AJNPU0692G");
		assertEquals(2, bankAccountList.size());
		
   		
		
		
	}

}
