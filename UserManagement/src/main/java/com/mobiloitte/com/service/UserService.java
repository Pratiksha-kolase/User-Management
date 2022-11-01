package com.mobiloitte.com.service;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import com.mobiloitte.com.controller.UserController;
import com.mobiloitte.com.dto.UserDto;
import com.mobiloitte.com.model.UserModel;

public interface UserService {

	ResponseEntity<String> insert(UserDto userDto);

	List<UserModel> allData();

	Optional<UserModel> getById(Long user_id);

	Optional<UserModel> getByUsername(String username);

	ResponseEntity<String> update(Long user_id,UserDto userDto);

	ResponseEntity<String> checkUser(String emailadd, UserDto userDto);






	

	

	


}
