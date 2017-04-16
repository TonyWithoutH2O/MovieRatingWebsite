package com.movieWebsite.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ResJSON {
	private int status;
	private String message;
	
	public ResJSON() {
		super();
	}
	
	public ResJSON(int status) {
		super();
		this.status = status;
	}

	public ResJSON(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ResJSON [status=" + status + ", message=" + message + "]";
	}
	
	public static String toResJSON(int status, String message) {
		return new Gson().toJson(new ResJSON(status, message), ResJSON.class);
	}
	
	public static String toResJSON(User user) {
		return new Gson().toJson(user, User.class);
	}
	
	public static String toResJSON(Movie movie) {
		return new Gson().toJson(movie, Movie.class);		
	}

	public static String toResJSON(Rating rating) {
		return new Gson().toJson(rating, Rating.class);		
	}
	
	public static String toResJSON(List<Movie> movieList) {
		return new Gson().toJson(movieList);
	}
	
	public static void writeToResponse(String json, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(json);
		writer.flush();
		writer.close();
	}
}
