package com.cognizant.Springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) {
		LOGGER.info("Application started...");
		SpringApplication.run(SpringLearnApplication.class, args);		
		displayDate();
		displayCountry();
		displayCountries();
		LOGGER.info("Process Completed...");
	}
	
	public static void displayDate() {
		//Incorporate logging
		LOGGER.info("Starting displayDate function");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		//Load SimpleDateFormat from Spring Configuration XML
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date date;
		try {
			date = format.parse("31/12/2018");
			LOGGER.debug(date.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOGGER.info("Ending displayDate function");
		}
	
	public static void displayCountry() {
		//Load Country from Spring configuration XML
		LOGGER.info("Starting displayCountry function");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		LOGGER.debug("Country 1 : {}", country.toString());	
		//Demonstration of Singleton and Prototype Scope
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country 2 : {}", anotherCountry.toString());
		LOGGER.info("Starting displayCountry function");
	}
	
	public static void displayCountries() {
		//Load list of countries from Spring Configuration XML
		LOGGER.info("Starting displayCountries function");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = context.getBean("countryList",java.util.ArrayList.class);
		LOGGER.info("List of all the countries:");
		for(Country country : countryList) {
			LOGGER.debug("Country : {}", country.toString());	
		}
		LOGGER.info("Starting displayCountries function");
	}

}