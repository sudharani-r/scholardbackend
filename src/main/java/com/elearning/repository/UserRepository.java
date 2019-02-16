/**
 * 
 */
package com.elearning.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elearning.model.User;

/**
 * @author I330976
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
		
		User findByFirstName(String firstName);

		List<User> findByLastName(String lastName);
		
		User findByUserNameAndPassword(String userName, String password);
	 
	
}
