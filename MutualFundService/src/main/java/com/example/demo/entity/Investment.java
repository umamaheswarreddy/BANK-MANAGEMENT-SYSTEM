package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * @author 844226 - mahesh
 *
 */

@ApiModel(description = "This is the Investment entity")
@Entity
public class Investment {
	
	@ApiModelProperty(value = "A unique key for each investment")
	@Id
	@GeneratedValue
	private int iId;
	
	@ApiModelProperty(value = "A MutualFundId  for  Investment")
	@NotNull(message = "MutualFundId cannot be null")
//	@Range(min = 1,max = 3,message = "MutualFundId should be in 1 to 2 ")
	private int MutualFundId;
	
	@ApiModelProperty(value = "A accountNumber  for  Investment")
	@NotNull(message = "bankAccount should not be null")
	@Pattern(regexp = "(^[0-9]{10}$)",message = "bankAccount should contain 10 digits")
	private String accountNumber;
	
	@ApiModelProperty(value = "A amountToInvest  for  Investment")
	@NotNull(message = "enter amount To Invest")
	@Pattern(regexp = "(^0[1-9]|[1-9]{1}[0-9]{1}$)", message = "Amount field should accept two decimal number only.and dont enter 00rs")
	private String amountToInvest;
	
	@JsonIgnore
	private Date timestamp;
	
	@Transient
	private Date timeStamp;
	
	@JsonIgnore
	private String pan;
	
	@Transient
	private MutualFund mutulFund;
	
	public Investment() {
		super();
	}
	public Investment(int iId,
			@NotNull(message = "MutualFundId cannot be null") @Range(min = 1, max = 3, message = "MutualFundId should be in 1 to 2 ") int mutualFundId,
			@NotNull(message = "bankAccount should not be null") @Pattern(regexp = "(^[0-9]{10}$)", message = "bankAccount should contain 10 digits") String accountNumber,
			@NotNull(message = "enter amount To Invest") @Pattern(regexp = "(^[0-9]{2}$)", message = "Amount field should accept two decimal number only.") String amountToInvest,
			Date timestamp, String pan) {
		super();
		this.iId = iId;
		MutualFundId = mutualFundId;
		this.accountNumber = accountNumber;
		this.amountToInvest = amountToInvest;
		this.timestamp = timestamp;
		this.pan = pan;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
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
	public String getAmountToInvest() {
		return amountToInvest;
	}
	public void setAmountToInvest(String amountToInvest) {
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
