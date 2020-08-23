package com.example.demo.model;

import java.util.Date;

import com.example.demo.entity.MutualFund;

public class Investment {
	
	
	private int iId;
	private int MutualFundId;
	private String accountNumber;
	private int amountToInvest;
	private Date timestamp;
	private String pan;
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
