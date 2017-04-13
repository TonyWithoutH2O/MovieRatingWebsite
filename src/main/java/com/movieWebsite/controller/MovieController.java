package com.movieWebsite.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieWebsite.model.Movie;
import com.movieWebsite.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Resource
	private MovieService movieService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Movie> movieList = movieService.movieList();
		model.addAttribute("movieList", movieList);
		return "movie/list";
	}
	
	@RequestMapping("/{movieName}")
	public String movieIndex(@PathVariable String movieName, Model model) {
		Movie movie = movieService.findMovieByName(movieName);
		model.addAttribute("movie", movie);
		return "movie/movieIndex";
	}
}
