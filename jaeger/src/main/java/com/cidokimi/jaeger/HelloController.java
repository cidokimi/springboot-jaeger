package com.cidokimi.jaeger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/span")
	public String span() {
		return "Hello from span";
	}
	
	@RequestMapping("/spanTospan")
	public String spanTospan() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8081/hello",String.class);
		return  responseEntity.getBody() +" from spanTospan";
	}

}
