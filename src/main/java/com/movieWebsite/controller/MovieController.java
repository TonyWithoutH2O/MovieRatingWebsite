package com.movieWebsite.controller;

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
import com.movieWebsite.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Resource
	private MovieService movieService;
	
	@RequestMapping("/list.do")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		List<Movie> movieList = movieService.movieList();
		String json = new Gson().toJson(movieList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
			
		}
	}
	
	@RequestMapping("/{movieName}.do")
	public void movieIndex(@PathVariable String movieName, 
							HttpServletRequest request, 
							HttpServletResponse response) {
		Movie movie = movieService.findMovieByName(movieName);
		if (movie == null) {
			// TODO Auto-generated constructor stub
		}
		String json = (new Gson().toJson(movie));
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
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
