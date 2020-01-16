/**
 * 
 * @author Parth
 * @date 2020-01-11
 * @description UserServiceImpl class
 *
 */

package com.webappdevelopment.service.impl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.webappdevelopment.UserRepository;
import com.webappdevelopment.dto.UserDto;
import com.webappdevelopment.io.entity.UserEntity;
import com.webappdevelopment.service.UserService;
import com.webappdevelopment.shared.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto user) {

		/**
		 * Check the user is Already exits in the system or not by using Email address
		 */
		if (userRepository.findUserByEmail(user.getEmail()) != null)
			throw new RuntimeException("Recored already exists");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		/**
		 * Generate the random publicUserId by using generateRandomString method
		 */
		String publicUserId = utils.generateRandomString(10);
		/**
		 * EnCrypt user Password before storing into database
		 */
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userEntity.setUserId(publicUserId);
		/**
		 * Save user into Database
		 */
		UserEntity storeUserDetails = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storeUserDetails, returnValue);

		return returnValue;
	}

	/**
	 * This Method allow to load the user details by userName
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findUserByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}

}
