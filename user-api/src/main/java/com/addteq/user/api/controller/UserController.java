package com.addteq.user.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addteq.user.api.domain.User;
import com.addteq.user.api.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	ResponseEntity<List<User>> getUserNamesFromDB() {
		List<User> userList = userService.getUserNamesFromDB();
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/save") 
	ResponseEntity<String> saveUsersToDatabase() {
		int recordsSaved = userService.saveUsersToDatabase();
		String message = recordsSaved<0 ? "Success" : "Failure to retrive data from file";
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

}
