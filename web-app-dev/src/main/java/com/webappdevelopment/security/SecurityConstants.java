/**
 * 
 * @author Parth
 * @date 2020-01-18
 * @description SecurityConstants.class provide SecurityConstants
 *
 */

package com.webappdevelopment.security;

public class SecurityConstants {

	// Token timing set
	public static final long EXPIRATION_TIME = 8600000;
	// pass with header request with post request
	public static final String TOKEN_PREFIX = "Parth";
	// pass header string
	public static final String HEADER_STRING = "Authorization";
	// public URL to sign up into the system
	public static final String SIGN_UP_URL = "/users";
	// use to EnCryption of access Token
	public static final String TOKEN_SECRET = "adm56cvef8efj3k5";
}
