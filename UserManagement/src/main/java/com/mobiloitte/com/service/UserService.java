package com.mobiloitte.com.service;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import com.mobiloitte.com.controller.UserController;
import com.mobiloitte.com.dto.UserDto;
import com.mobiloitte.com.model.UserModel;

public interface UserService {

	ResponseEntity<String> insert(UserDto userDto);

	ResponseEntity<List> allData();

	Optional<UserModel> getByUsername(String username);

	Optional<UserModel> getByLastname(String lastname);

	Optional<UserModel> getByFirstname(String firstname);

	ResponseEntity<String> deleteUser(Long user_id);

	ResponseEntity<String> update(Long user_id, UserDto userDto);

	Optional<UserModel> getById(Long user_id);

	List getemailpassword();
}
