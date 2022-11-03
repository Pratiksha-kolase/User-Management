package com.mobiloitte.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobiloitte.com.dto.UserDto;
import com.mobiloitte.com.model.UserModel;
import com.mobiloitte.com.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody UserDto userDto) {

		return userService.insert(userDto);
	}

	@GetMapping("/getbyfirstname/{firstname}")
	public Optional<UserModel> firstname(@PathVariable("firstname") String firstname) {

		return userService.getByFirstname(firstname);
	}


	@GetMapping("/getbylastname/{lastName}")
	public Optional<UserModel> lastname(@PathVariable("lastname") String lastname) {

		return userService.getByLastname(lastname);
	}

	@GetMapping("/getAllData")
	public List<UserModel> allData() {
		return userService.allData();
	}

	@GetMapping("/getById/{user_id}")
	public Optional<UserModel> getById(@PathVariable("user_id") Long user_id) {
		return userService.getById(user_id);

	}

	@GetMapping("getByUserName/{username}")
	public Optional<UserModel> getByUsername(@PathVariable("username") String username) {

		return userService.getByUsername(username);
	}
	

	@PutMapping("/update/{user_id}")
	public ResponseEntity<String> update(@PathVariable("user_id") Long user_id, @RequestBody UserDto userDto) {

		return userService.update(user_id, userDto);
	}
	
	

}
