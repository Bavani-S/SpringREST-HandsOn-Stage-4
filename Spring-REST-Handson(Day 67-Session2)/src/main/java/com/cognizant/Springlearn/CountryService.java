package com.cognizant.Springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CountryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

	public Country getCountry(String code) throws CountryNotFoundException {
		Country country=new Country();
		List<Country> list=new ArrayList<Country>();
		SpringRestApplication springrest= new SpringRestApplication();
		list= springrest.displayCountries();
		for(Country eachCountry : list){
			if(eachCountry.getCode().equals(code)){
				country=eachCountry;
				break;
			}
		}
		if(country==null){
			throw new CountryNotFoundException();
		}
		return country;
	}
}