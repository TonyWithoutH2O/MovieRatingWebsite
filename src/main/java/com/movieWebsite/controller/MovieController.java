package com.movieWebsite.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.movieWebsite.model.Movie;
import com.movieWebsite.model.ResJSON;
import com.movieWebsite.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Resource
	private MovieService movieService;
	
	@RequestMapping("/list.do")
	public void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Movie> movieList = movieService.movieList();
		ResJSON.writeToResponse(ResJSON.toResJSON(movieList), response);
	}
	
	@RequestMapping("/{movieName}.do")
	public void movieIndex(@PathVariable String movieName, 
							HttpServletRequest request, 
							HttpServletResponse response) throws IOException {
		Movie movie = movieService.findMovieByName(movieName);
		if (movie == null) {
			// TODO return to where it comes
		}
		ResJSON.writeToResponse(ResJSON.toResJSON(movie), response);
	}	
	
	// For js
	/*
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
	*/
}
