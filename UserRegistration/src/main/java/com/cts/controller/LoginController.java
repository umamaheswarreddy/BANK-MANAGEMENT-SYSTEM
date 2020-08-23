package com.cts.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.BankAccount;
import com.cts.exceptions.CustomerNotFoundException;
import com.cts.exceptions.DupicatesException;
import com.cts.service.LoginService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author 844226
 * @implNote login controller provides login facility for user. if you want to
 *           access this controller you must have userName and password.
 *
 */
@RestController
@RequestMapping("/user")
public class LoginController {
	

	@Autowired
	private LoginService service;

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * 
	 * @param pan       pan number of user
	 * @param principal this interface pickup the current user userName.
	 * @return
	 */
	@ApiOperation(value = "Retrieve a BankAccount  details based on pan", produces = "A BankAccount details if it exists", notes = "Hit this URL to get a Account details details")
	@GetMapping("/bank/{pan}")
	public List<BankAccount> getBank(@PathVariable String pan, Principal principal) {
		String username = principal.getName();
		if (!username.equals(pan))
		{
			logger.error("no access");
			throw new CustomerNotFoundException("you are not allowed to access other user account details");
		} else 
		{
			List<BankAccount> accounts = service.findAllByPan(pan);
			if (accounts.isEmpty()) {
				logger.error("you have no accounts to show. please setup account");
				throw new CustomerNotFoundException("you have no accounts to show. please setup account ");
			} else {
				logger.info("Retrieve a BankAccount  details based on pan successfull");
				return accounts;
			}

		}

	}

	/**
	 * 
	 * @param account   BankAccount Details of logined user
	 * @param principal it capture the current logined user
	 * @return 201 status if user added successfully.
	 */
	@ApiOperation(value = "Add a bankAccount",notes = "Hit this URL to insert a new account details")
	@PostMapping("/addBank")
	public ResponseEntity<?> addbank(@Valid @RequestBody BankAccount account, Principal principal) {

		String username = principal.getName();
		int count = service.countByPan(username);

		if (service.existsByBankAccount(account.getBankAccount())) {
			logger.error("duplicate Account number");
			throw new DupicatesException("duplicate Account number");
		}

		else if (count >= 4) {
			logger.error("user able to setup at least one and at most four Bank accounts");
			throw new DupicatesException("user able to setup at least one and at most four Bank accounts");
		} else {
			account.setPan(username);
			service.save(account);
			logger.info("new account added successfully");
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}

	}

	@GetMapping("/username")
	public String currentUserName(Principal principal) {

		String username = principal.getName();
		int count = service.countByPan(username);
		return username + " " + count;
	}

//	@GetMapping("/{id}")
//	public User getuser(@PathVariable int id) {
//		User user = repo.findById(id).orElse(null);
//		LocalDate today = LocalDate.now();
//		LocalDate dob = user.getBirthday();
//		Period p = Period.between(dob, today);
//		int age = p.getYears();
//		user.setAge(age);
//		return user;
//	}
	
//	@RequestMapping("/feign")
//	public String getAsll() {
//		return proxy.get();
//	}

//	@HystrixCommand
//	@RequestMapping("/feign/mutualFunds/all")
//	public List<MutualFund> getAllMutualFunds() {
//		return proxy.getAllMutualFunds();
//	}
//
//	@GetMapping("/feign/getTransaction/{iId}")
//	public Investment findByInvestmentid(@PathVariable int iId, Principal principal) {
//
//		Investment invst = proxy.findByInvestmentid(iId);
//		invst.setPan(principal.getName());
//		return invst;
//	}

//	@GetMapping("/all")
//	public List<User> getAll() {
//		List<User> users = repo.findAll();
//		LocalDate today = LocalDate.now();
//		for (User user : users) {
//			LocalDate dob = user.getBirthday();
//			Period p = Period.between(dob, today);
//			user.setAge(p.getYears());
//		}
//		return users;
//	}
	
//	@Autowired
//	private NoOpPasswordEncoder passwordEncoder;
	
//	@Autowired
//	private DemoServiceProxy proxy;

}
