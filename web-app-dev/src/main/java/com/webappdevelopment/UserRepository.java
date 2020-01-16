/**
 * 
 * @author Parth
 * @date 2020-01-12
 * @description UserRepository interface created to use in-build CrudRepository
 */

package com.webappdevelopment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webappdevelopment.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	/**
	 * 
	 * @param email-
	 *            email address use to find User
	 * @return userEntity base on Email id
	 */
	UserEntity findUserByEmail(String email);

}
