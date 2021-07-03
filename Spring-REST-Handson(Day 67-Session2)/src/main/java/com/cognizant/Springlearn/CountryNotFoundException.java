package com.cognizant.Springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country Not Found")
public class CountryNotFoundException extends Exception {
/*private String message;
CountryNotFoundException(String message){
super(message);*/
}

}