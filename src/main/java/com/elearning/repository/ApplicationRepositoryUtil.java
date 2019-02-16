package com.elearning.repository;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.elearning.dto.LoginDto;
import com.elearning.model.User;
 
@Service
public class ApplicationRepositoryUtil {
 
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private UserRepository userRepository;
 
    /**
     * @return the mongoTemplate
     */
    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }
 
    /**
     * @return the customerRepository
     */
    public UserRepository getUserRepository() {
        return userRepository;
    }
    
    public void createUser(User user){
    	userRepository.save(user);
    	
    }

	/**
	 * @param user
	 */
	public User AuthenticateUser(LoginDto loginDto) {
		User user = userRepository.findByUserNameAndPassword(loginDto.getUserName(), loginDto.getPassword());
		return user;
	}
 
}