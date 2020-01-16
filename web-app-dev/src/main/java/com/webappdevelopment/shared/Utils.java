/**
 * 
 * @author Parth
 * @date 2020-01-12
 * @description Utils class use to generate the random public userId
 *
 */

package com.webappdevelopment.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	// Initialize the RANDOM class
	private final Random RANDOM = new SecureRandom();
	// Initialize final ALPHABET string
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	/**
	 * 
	 * @param legnth
	 *            - password length
	 * @return String - generated User Id base on the length provided by the user
	 */
	public String generateUserId(int length) {
		return generateRandomString(length);
	}

	/**
	 * 
	 * @param legnth
	 *            - - password length
	 * @return String - randomly generated String bas on provided length
	 */
	public String generateRandomString(int length) {
		StringBuilder returnValue = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));

		}

		return new String(returnValue);
	}
}
