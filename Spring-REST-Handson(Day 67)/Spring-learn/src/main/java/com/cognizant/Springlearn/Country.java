package com.cognizant.Springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

	private String code;
	private String name;

	public Country() {
		LOGGER.debug("Inside Country Constructor");
	}

	public String getCode() {
		LOGGER.info("Returning the country code: "+code);
		return code;
	}

	public void setCode(String code) {
		this.code = code;
		LOGGER.info("Setting the country code as: "+code);
	}

	public String getName() {
		LOGGER.info("Returning the country name: "+name);
		return name;
	}

	public void setName(String name) {
	    this.name = name;
		LOGGER.info("Setting the ountry name as: "+name);
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}