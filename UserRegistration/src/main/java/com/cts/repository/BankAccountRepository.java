package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.entity.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
	
	BankAccount findByPan(String pan);

	List<BankAccount> findAllByPan(String pan);

	
	@Query(value = "SELECT count(pan) FROM BankAccount where pan = :pan")
	Integer countByPan(@Param("pan") String pan);

	boolean existsByBankAccount(String bankAccount);
	
	

}
	

	


