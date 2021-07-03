package com.example.demo;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.info("Exception handler started...");
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("timestamp", new Date());
		map.put("status", status.value());

		List<String> errors = exception.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		map.put("errors", errors);

		LOGGER.info("Exception handler terminated...");
		return new ResponseEntity<>(map, headers, status);
	}
}
