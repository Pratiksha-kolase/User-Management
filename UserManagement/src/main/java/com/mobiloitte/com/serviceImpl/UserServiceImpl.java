package com.mobiloitte.com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobiloitte.com.controller.UserController;
import com.mobiloitte.com.dao.UserDao;
import com.mobiloitte.com.dto.UserDto;
import com.mobiloitte.com.model.UserModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.mobiloitte.com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public ResponseEntity<String> insert(UserDto userDto) {
		UserModel userModel = new UserModel();
		
		Optional<UserModel> user=userDao.findByUsername(userDto.getUsername());
		
		if( !user.isPresent())
		{
			userModel.setUsername(userDto.getUsername());
		}
		else
		{
			return new ResponseEntity<>("Username Already Exists...",HttpStatus.OK);
		}
		
		Optional<UserModel> pass=userDao.findByPassword(userDto.getPassword());
		if(!pass.isPresent())
		{
			userModel.setPassword(userDto.getPassword());
		}
		else
		{
			return new ResponseEntity<>("Password Already Exixts..",HttpStatus.OK);
		}
		
		Optional<UserModel> mobile=userDao.findByMobnumber(userDto.getMobnumber());
		if( !mobile.isPresent())
		{
			userModel.setMobnumber(userDto.getMobnumber());
		}
		else
		{
			return new ResponseEntity<>("Mobile number Already Exists...",HttpStatus.OK);
		}

		Optional<UserModel> email = userDao.findByEmailadd(userDto.getEmailadd());
		if (!email.isPresent()) {
			userModel.setFirstname(userDto.getFirstname());
			userModel.setLastname(userDto.getLastname());
			userModel.setUserdob(userDto.getUserdob());
			userModel.setEmailadd(userDto.getEmailadd());
			userModel.setPassword(userDto.getPassword());
			userModel.setUsername(userDto.getUsername());
			userDao.save(userModel);
			return new ResponseEntity<>("201 Account Created", HttpStatus.CREATED);
		} else {

			return new ResponseEntity<>("Email Already Registered.", HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseEntity<List> allData() {
		List<UserModel> list= userDao.findAll();
		if(!list.isEmpty())
		return new ResponseEntity<>(list,HttpStatus.OK);
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Optional<UserModel> getById(Long user_id) {

		return userDao.findById(user_id);
	}

	@Override
	public Optional<UserModel> getByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public ResponseEntity<String> update(Long user_id, UserDto userDto) {
		ResponseEntity<String> message = new ResponseEntity<>("", HttpStatus.OK);
		Optional<UserModel> updateUser = userDao.findById(user_id);
		if (updateUser.isPresent()) {
			UserModel userModel = userDao.getById(user_id);
			userModel.setFirstname(userDto.getFirstname());
			userModel.setLastname(userDto.getLastname());
			userModel.setMobnumber(userDto.getMobnumber());
			userModel.setUserdob(userDto.getUserdob());
			userDao.save(userModel);
			message = new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
		} else {

			message = new ResponseEntity<>("404 Not found", HttpStatus.NOT_FOUND);
		}
		return message;
	}

	@Override
	public Optional<UserModel> getByFirstname(String firstname) {
		return userDao.findByFirstname(firstname);
	}

	@Override
	public Optional<UserModel> getByLastname(String lastname) {
		return userDao.findByLastname(lastname);
	}

	@Override
	public ResponseEntity<String> deleteUser(Long user_id) {
//		Optional<UserModel> findUser
		userDao.deleteById(user_id);
		return new ResponseEntity<>("200 User Deleted Successfully.......!",HttpStatus.OK);
	}

	@Override
	public List getemailpassword() {

		return userDao.getemails();
	}

}
