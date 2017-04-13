package com.movieWebsite.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieWebsite.dao.BaseDao;
import com.movieWebsite.model.Movie;
import com.movieWebsite.service.MovieService;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
	
	@Resource
	private BaseDao<Movie> baseDao;
	
	@Override
	@Transactional
	public Serializable addMovie(Movie movie) {
		return baseDao.save(movie);
	}

	@Override
	@Transactional
	public Movie findMovieByName(String movieName) {
		String hql = "from Movie m where m.movieName = ?";
		Object[] param = new Object[] {movieName};
		return baseDao.get(hql, param);
	}

	@Override
	@Transactional
	public List<Movie> movieList() {
		String hql = "from Movie";
		return baseDao.find(hql, null);
	}

}
