/**
 * 
 * @author Parth
 * @date 2020-01-08
 * @description WebAppDevApplication class
 */

package com.webappdevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WebAppDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppDevApplication.class, args);
	}

	/**
	 * 
	 * @return EnCryptPassword
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
