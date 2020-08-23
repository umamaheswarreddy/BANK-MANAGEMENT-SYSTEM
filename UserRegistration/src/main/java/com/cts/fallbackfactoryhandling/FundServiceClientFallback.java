package com.cts.fallbackfactoryhandling;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.controller.DemoServiceProxy;
import com.cts.model.Investment;
import com.cts.model.MutualFund;

import feign.FeignException;

public class FundServiceClientFallback implements DemoServiceProxy {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final Throwable cause;

	public FundServiceClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public String get() {
		return null;
	}

	@Override
	public List<MutualFund> getAllMutualFunds() {
		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			logger.error("404 error took place when getAllMutualFunds was called. Error message: "
					+ cause.getLocalizedMessage());
		} else {
			logger.error("Other error took place: " + cause.getLocalizedMessage());
		}
		return Arrays.asList(new MutualFund(0,"N/A"), new MutualFund(0,"N/A"));

	}

	@Override
	public Investment findByInvestmentid(int iId) {

		return null;
	}



}
