package com.cognizant.Springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringRestApplication {
                 private static final Logger LOGGER = LoggerFactory.getLogger(SpringRestApplication.class);	
	public static void main(String[] args) throws ParseException {
                                   LOGGER.info("Application started...");
		SpringApplication.run(SpringRestApplication.class, args);
                                   LOGGER.info("Process Completed...");
	}
	
	public Country displayCountry() {
		//Getting the bean for country India
		LOGGER.info("Starting displayCountry function");
		ApplicationContext context = new ClassPathXmlApplicationContext("india.xml"); 
		Country country = (Country) context.getBean("in", Country.class);
		return country;
	}
	 
	
	public List<Country> displayCountries()
	{
		//Getting all the countries
		LOGGER.info("Starting displayCountries function");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list=context.getBean("countryList",java.util.ArrayList.class);
		return list;
		
	}

}
