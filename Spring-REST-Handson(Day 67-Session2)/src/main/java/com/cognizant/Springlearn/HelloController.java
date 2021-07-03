package com.cognizant.SpringLearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	@GetMapping("/hello")
	public String sayHello(){
		LOGGER.debug("Hello world service invoked");
		return "Hello World!!";
	}
}