package com.movieWebsite.service;

import com.movieWebsite.model.User;

/**
 * @author Clark
 *
 */
public interface UserService {
	

	/**
	 * Add the user into the database
	 * @param user
	 */
	public boolean createUser(User user);
	
	/**
	 * Delete the corresponding user in the database
	 * @param user
	 */
	public void deleteUser(User user);
	
	/**
	 * Update the corresponding user in the database
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * Find the user in the database by username
	 * @param userName
	 * @return
	 */
	public User findUserByName(String userName);
	
	/**
	 * Find the user in the database by username and password
	 * @param user
	 * @return null or User found in the database
	 */
	public User findUserByNameAndPassword(String username, String password);
	
	/**
	 * Login service
	 * @param username
	 * @param password
	 * @return if success return the current user, if not return null
	 */
	public User login(String username,String password);

}
