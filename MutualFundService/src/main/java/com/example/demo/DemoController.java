package com.example.demo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.WebUtils;

import com.example.demo.controller.UserRegistrationServiceProxy;

@RestController
public class DemoController {
	
	@Autowired
	UserRegistrationServiceProxy proxy;
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/get")
	public String get() {
		return "feign working well...........";
	}
	
	@GetMapping("/feign/UserRegistration/get")
	public String getFeign() {
		return proxy.get();
	}
	
	@RequestMapping("/feign/user/test")
	public String test() {
		return proxy.test();
	}
	

	@GetMapping("/feign/UserRegistration/username")
	public String currentUserName() {
		Cookie jsessionid = WebUtils.getCookie(request, "JSESSIONID");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "JSESSIONID="+jsessionid.getValue());
        ResponseEntity<byte[]> response = template.exchange("http://localhost:8080/UserRegistration/username",
                HttpMethod.GET,
                new HttpEntity<String>(headers),
                byte[].class);
		return new String(response.getBody());
		
	}
	

	

}
