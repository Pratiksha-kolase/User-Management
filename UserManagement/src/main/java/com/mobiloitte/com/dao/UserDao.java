package com.mobiloitte.com.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.mobiloitte.com.dto.UserDto;
import com.mobiloitte.com.model.UserModel;


public interface UserDao extends JpaRepository<UserModel,Long>{


	Optional<UserModel> findById(Long user_id);

	Optional<UserModel> findByUsername(String username);
	
	UserModel getById(Long user_id);

	Optional<UserModel> findByEmailadd(String emailadd);

	Optional<UserModel> findByMobnumber(Long mobnumber);

	Optional<UserModel> findByFirstname(String firstname);

	Optional<UserModel> findByLastname(String lastname);

	Optional<UserModel> findByUsername(Long mobnumber);

}
