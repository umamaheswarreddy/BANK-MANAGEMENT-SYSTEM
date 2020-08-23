package com.cts.fallbackfactoryhandling;

import org.springframework.stereotype.Component;

import com.cts.controller.DemoServiceProxy;

import feign.hystrix.FallbackFactory;

@Component
public class FundFallbackFactory implements FallbackFactory<DemoServiceProxy> {

	@Override
	public DemoServiceProxy create(Throwable cause) {
		
		return new FundServiceClientFallback(cause);
	}

	
}
