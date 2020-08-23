package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DemoController;
import com.example.demo.entity.Investment;
import com.example.demo.exceptions.InvestmentNotFoundException;
import com.example.demo.service.InvestMentService;
import com.example.demo.service.MutualFundService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author 844226
 * @apiNote InvestMentControoler used to invest money and retrive all
 *          transactions
 */
@RestController
public class InvestMentController {

	@Autowired
	private InvestMentService service;

	@Autowired
	private MutualFundService mService;

	@Autowired
	DemoController controller;


	@GetMapping("/TotalInvestmentByPan/{pan}")
	public String totalSummary(@PathVariable String pan) {
		List<Investment> investments = service.findAllByPan(pan);
		Integer total = investments.stream().map(Investment::getAmountToInvest).mapToInt(Integer::valueOf).sum();
		return "Total Invest By " + pan + " is " + total;
	}

	@GetMapping("/TotalInvestmentByPanAndAccountNumber/pan/{pan}/accountNumber/{accountNumber}")
	public List<Investment> GetAllTransationsBUPanAndAmount(@PathVariable String pan,
			@PathVariable String accountNumber) {
		List<Investment> investments = service.findAllByPan(pan);
		List<Investment> result = investments.stream().filter(invest -> invest.getAccountNumber().equals(accountNumber))
				.collect(Collectors.toList());
		result.forEach(invest -> {
			invest.setTimeStamp(invest.getTimestamp());
			invest.setMutulFund(mService.findById(invest.getMutualFundId()));
		});
		return result;
		

	}

	/**
	 * 
	 * @param investment - investment details
	 */
	@ApiOperation(value = "Add a investment", consumes = "application/json", notes = "Hit this URL to insert a new investment details")
	@PostMapping("/invest")
	public ResponseEntity<String> addInvest(@Valid @RequestBody Investment investment) {

		String userName = controller.currentUserName();
		investment.setPan(userName);
		investment.setTimestamp(new Date());
		service.save(investment);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	/**
	 * 
	 * @param pan - pancard
	 * @return list of investments
	 * @throws Exception
	 */
	@ApiOperation(value = "Retrieve a Investment  details based on pan", produces = "A Investment details if it exists", notes = "Hit this URL to get a Investment details")
	@GetMapping("/getTransactions/{pan}")
	public List<Investment> GetAllTransactionsByPan(@PathVariable String pan) {

		List<Investment> investment = service.findAllByPan(pan);

		if (!controller.currentUserName().equals(pan)) {
			throw new InvestmentNotFoundException("you are not allowed to see others transaction details");
		} else if (investment.isEmpty()) {
			throw new InvestmentNotFoundException("no transactions to show pls invest in mutual funds");
		} else {
			investment.forEach(invest -> {
				invest.setTimeStamp(invest.getTimestamp());
				invest.setMutulFund(mService.findById(invest.getMutualFundId()));
			});
			return investment;
		}
	}

	/**
	 * 
	 * @param pan          - pan
	 * @param MutualFundId - MutualFundId
	 * @return list of transactions
	 */
	@ApiOperation(value = "Retrieve a Investment  details based on pan and mutualFundid", produces = "A Investment details if it exists", notes = "Hit this URL to get a Investment details")
	@GetMapping("/getTransaction/pan/{pan}/mutualFundid/{MutualFundId}")
	public List<Investment> findInvestmentByPanANDMutualFundId(@PathVariable String pan,
			@PathVariable int MutualFundId) {
		List<Investment> investments = service.findAllByPanANDMutualFundId(pan, MutualFundId);
		if (investments.isEmpty()) {
			throw new InvestmentNotFoundException("no investments to show for entered pan and mutualfundId ");
		} else {
			investments.forEach(invest -> {
				invest.setTimeStamp(invest.getTimestamp());
				invest.setMutulFund(mService.findById(MutualFundId));
			});
			return investments;
		}
	}

	/**
	 * 
	 * @param MutualFundId - MutualFundId
	 * @return list of investment details based on mutualFundid
	 */
	@ApiOperation(value = "Retrieve a Investment  details based on mutualFundid", produces = "A Investment details if it exists", notes = "Hit this URL to get a Investment details based on mutualFundid")
	@GetMapping("/getAllTransaction/MutualFundId/{MutualFundId}")
	public List<Investment> findAllTransactionDetailsForParticularFund(@PathVariable int MutualFundId) {

		List<Investment> investments = service.findAllByMutualFundId(MutualFundId);
		if (investments.isEmpty()) {
			throw new InvestmentNotFoundException("please enter valid MutualFundId");
		} else {
			investments.forEach(invest -> {
				invest.setTimeStamp(invest.getTimestamp());
				invest.setMutulFund(mService.findById(MutualFundId));
			});
			return investments;
		}
	}

//	/**
//	 * 
//	 * @param pan- pan
//	 * @param iId  - investmentId
//	 * @return list of transactions
//	 */
//	@ApiOperation(value = "Retrieve a Investment  details based on pan and investmentId", produces = "A Investment details if it exists", notes = "Hit this URL to get a Investment details")
//	@GetMapping("/getTransaction/pan/{pan}/id/{iId}")
//	public Investment findByInvestmentid(@PathVariable String pan, @PathVariable int iId) {
//		Investment investment = repo.findByPanANDIId(pan, iId).orElse(null);
//		if (investment.equals(null)) {
//			throw new InvestmentNotFoundException("no transactions to show on this pan and investmentid");
//		} else {
//			MutualFund Mf = dao.findById(investment.getMutualFundId()).orElse(null);
//			investment.setMutulFund(Mf);
//			return investment;
//		}

}
