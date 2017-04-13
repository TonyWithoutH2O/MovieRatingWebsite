package com.movieWebsite.service;

import java.io.Serializable;

import com.movieWebsite.model.Movie;
import com.movieWebsite.model.Rating;
import com.movieWebsite.model.User;

/**
 * @author Clark
 *
 */
public interface RatingService {
	
	/**
	 * Put a new rating data into the database
	 * @param rating
	 * @param user
	 * @param movie
	 * @return
	 */
	public Serializable rate(int rating, User user, Movie movie);
	
	/**
	 * Put a new rating data into the database
	 * @param rating
	 * @return
	 */
	public Serializable rate(Rating rating);
}
