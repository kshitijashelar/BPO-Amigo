package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean isUser(User user);

	/**
	 * 
	 * @param user
	 * @return
	 */

	public List<String> getUserDetails(User user);

	/**
	 * 
	 * @return
	 */
	public String getCurrentDateAndTime();

	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean isRegisterUser(User user);

	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean isRegister(User user);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public User findByUserId(int userId);

	public User findByEmailIdAndUserType(String emailId, String userType);
	
	public User findByEmailId(String emailId);

	

}
