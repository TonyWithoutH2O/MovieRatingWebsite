package com.movieWebsite.service;

import java.io.Serializable;
import java.util.List;

import com.movieWebsite.model.Movie;

/**
 * @author Clark
 *
 */
public interface MovieService {

	/**
	 * Add movie to the database
	 * @param movie
	 * @return
	 */
	public Serializable addMovie(Movie movie);
	
	/**
	 * Search the datebase with the moviename
	 * @param movieName
	 * @return movie found by movie name or null if no such movie
	 */
	public Movie findMovieByName(String movieName);
	
	/**
	 * @return the list of all movie
	 */
	public List<Movie> movieList();
}
