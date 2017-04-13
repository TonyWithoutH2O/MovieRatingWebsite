package com.movieWebsite.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieWebsite.dao.BaseDao;
import com.movieWebsite.model.Movie;
import com.movieWebsite.model.Rating;
import com.movieWebsite.model.User;
import com.movieWebsite.service.RatingService;

@Service("ratingService")
public class RatingServiceImpl implements RatingService {

	@Resource
	private BaseDao<Rating> baseDao;

	@Override
	@Transactional
	public Serializable rate(int rating, User user, Movie movie) {
		Rating ratingObj = new Rating(rating, user.getUserid(), movie.getMovieId());
		return baseDao.save(ratingObj);
	}

	@Override
	@Transactional
	public Serializable rate(Rating rating) {
		return baseDao.save(rating);
	}

	
	
}
