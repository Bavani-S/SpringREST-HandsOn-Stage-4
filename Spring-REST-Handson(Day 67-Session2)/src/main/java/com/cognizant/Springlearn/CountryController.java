package com.cognizant.SpringLearn;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
	@Autowired
	CountryService countryService;
	//Country Web Service
	@RequestMapping(value ="/country",method = RequestMethod.GET)			
	public Country getCountryIndia(){
		SpringRestApplication springrest= new SpringRestApplication();
		return springrest.displayCountry();
	}
	//Get all countries
	@GetMapping("/countries")
	public List<Country> getallCountries(){
		SpringRestApplication springrest= new SpringRestApplication();
		return springrest.displayCountries();
	}
	//Get country based on country code
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
		return countryService.getCountry(code);
	}
	
}
