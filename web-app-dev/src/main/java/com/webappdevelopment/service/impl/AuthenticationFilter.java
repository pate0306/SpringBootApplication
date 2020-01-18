/**
 * 
 * @author Parth
 * @date 2020-01-18
 * @description AuthenticationFilter.class use to check the user when try to login in the system
 *
 */
package com.webappdevelopment.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webappdevelopment.model.request.UserLoginRequestModel;
import com.webappdevelopment.security.SecurityConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/**
	 * When user provide sign details this method will called and use
	 * AuthenticationManager will authentic the user by using Email and Password
	 * which will be reading from the UserLoginRequestModel
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {

			UserLoginRequestModel credential = new ObjectMapper().readValue(request.getInputStream(),
					UserLoginRequestModel.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credential.getEmail(),
					credential.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * It use to build JASON Web Token using Expiration time,SignatureAlgorithm,
	 * TOKEN_SECRET, and pass it into header to user response
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authentication) throws IOException, ServletException {

		String userName = ((User) authentication.getPrincipal()).getUsername();
		// Building JSON Web Token
		String jsonToken = Jwts.builder().setSubject(userName)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.TOKEN_SECRET).compact();
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + jsonToken);
	}
}
