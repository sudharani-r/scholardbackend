package com.elearning.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
 
 

@Document(collection="user")
public class User {
 
    @Id
    @Field
    private String id;
    @Field
    private String userName;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private String password;
    @Field
    private String mobileNumber;
     
 
    public User(){
    	
    }
    
    public User(String id, String userName, String firstName,String lastName,String password, String mobileNumber){
    	this.id = id;
    	this.userName = userName;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.password = password;
    	this.mobileNumber = mobileNumber;
    	
    }
 
    /**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
    /**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
    
    public String getMobileNumber() {
        return mobileNumber;
    }
 
   
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
 
}
