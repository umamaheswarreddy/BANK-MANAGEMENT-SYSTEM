package com.cts.model;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Investment {
	
	@Id
	private int iId;
	private int MutualFundId;
	private String accountNumber;
	private int amountToInvest;
	@JsonIgnore
	private Date timestamp;
	@JsonIgnore
	private String pan;
	
	@Transient
	private MutualFund mutulFund;
	
	
	public MutualFund getMutulFund() {
		return mutulFund;
	}
	public void setMutulFund(MutualFund mutulFund) {
		this.mutulFund = mutulFund;
	}
	public int getMutualFundId() {
		return MutualFundId;
	}
	public void setMutualFundId(int mutualFundId) {
		MutualFundId = mutualFundId;
	}
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAmountToInvest() {
		return amountToInvest;
	}
	public void setAmountToInvest(int amountToInvest) {
		this.amountToInvest = amountToInvest;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	

}
