/**
 * 
 * @author Parth
 * @date 2020-01-11
 * @description UserService class
 *
 */
package com.webappdevelopment.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.webappdevelopment.dto.UserDto;

public interface UserService extends UserDetailsService {

	UserDto createUser(UserDto user);
}
