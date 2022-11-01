package com.mobiloitte.com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mobiloitte.com.controller.UserController;
import com.mobiloitte.com.dao.UserDao;
import com.mobiloitte.com.dto.UserDto;
import com.mobiloitte.com.model.UserModel;

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

		userModel.setFirstname(userDto.getFirstname());
		userModel.setLastname(userDto.getLastname());
		userModel.setUserdob(userDto.getUserdob());
		userModel.setEmailadd(userDto.getEmailadd());
		userModel.setFirstname(userDto.getFirstname());
		userModel.setLastname(userDto.getLastname());
		userModel.setMobnumber(userDto.getMobnumber());
		userModel.setPassword(userDto.getPassword());
		userModel.setUsername(userDto.getUsername());
		userDao.save(userModel);
		return new ResponseEntity<>("Successfully Registered", HttpStatus.OK);
	}

	@Override
	public List<UserModel> allData() {
		return userDao.findAll();
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
			userModel.setUserdob(userDto.getUserdob());
			userDao.save(userModel);
			message = new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
		} else {

			message = new ResponseEntity<>("Not found", HttpStatus.OK);
		}
              return message;
	}


//	@Override
//	public ResponseEntity<String> checkUser(String emailadd,UserDto userDto) {
//
//		Optional<UserModel> emailadd1=userDao.findByEmailadd(userDto.getEmailadd());
//		UserModel userModel=new UserModel();
//		if(!emailadd1.isPresent())
//		{
//			userModel.setEmailadd(userDto.getEmailadd());
//			return new ResponseEntity<>("Registered",HttpStatus.OK);
//		}
//		else
//		{
//			return new ResponseEntity<>("Not Registered",HttpStatus.OK);
//		}
//		

//}
}
