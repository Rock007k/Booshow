package com.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/movie")
public class MovieController {

	@PostMapping("/addNew")
	public ResponseEntity<String> postMethodName(@RequestBody MovieRequest movieRequest){
		//TODO: process POST request
		
	}
	
}
