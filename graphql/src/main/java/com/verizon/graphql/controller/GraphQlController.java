package com.verizon.graphql.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graphql-home")
public class GraphQlController {
	
	@GetMapping
	public ResponseEntity<String> getHomePage()
	{
		return new ResponseEntity<>("Welcome..!!",HttpStatus.OK);
	}

}
