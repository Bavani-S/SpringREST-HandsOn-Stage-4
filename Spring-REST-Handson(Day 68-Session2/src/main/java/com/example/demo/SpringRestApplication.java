package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApplication {

                 private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestApplication.class);
	public static void main(String[] args) {
                                   LOGGER.info("Application started...");
		SpringApplication.run(SpringRestApplication.class, args);
                                   LOGGER.info("Process Completed...");
	}

}
