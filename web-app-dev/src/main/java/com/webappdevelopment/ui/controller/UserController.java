/**
 * 
 * @author Parth
 * @date 2020-01-08
 * @description UserContoller class to created the API end points
 */
package com.webappdevelopment.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webappdevelopment.dto.UserDto;
import com.webappdevelopment.model.request.UserDetailRequestModel;
import com.webappdevelopment.model.response.UserRest;
import com.webappdevelopment.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public UserRest CrateUser(@RequestBody UserDetailRequestModel userDetails) {

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		UserDto createUser = userService.createUser(userDto);

		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(createUser, returnValue);

		return returnValue;
	}

}
