package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MutualFund {

	@Id
	@GeneratedValue
	private int mId;
	private String MutualFundName;
	
	

	public MutualFund() {
		super();
	}

	public MutualFund(int mId, String mutualFundName) {
		super();
		this.mId = mId;
		MutualFundName = mutualFundName;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getMutualFundName() {
		return MutualFundName;
	}

	public void setMutualFundName(String mutualFundName) {
		MutualFundName = mutualFundName;
	}

	
	
	
	
	
}
