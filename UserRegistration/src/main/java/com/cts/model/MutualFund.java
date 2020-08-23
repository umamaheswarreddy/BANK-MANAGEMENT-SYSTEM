package com.cts.model;

public class MutualFund {

	
	private int mId;
	private String MutualFundName;
	

	public MutualFund(int mId, String mutualFundName) {
		super();
		this.mId = mId;
		MutualFundName = mutualFundName;
	}

	public int getmId() {
		return mId;
	}

	public MutualFund() {
		super();
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
