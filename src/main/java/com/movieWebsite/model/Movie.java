package com.movieWebsite.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Clark
 *
 */
@Entity
@Table(name = "t_movie")
public class Movie {
	
	@Id
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	@Column(name="movieId", length = 11)
	private int movieId;
	
	@Column
	private String movieName;
	
	@Column
	private String date;
	
	@Column
	private String url;
	
	@Column
	private String category;
		
	public static String[] categoryName = {"unknown", "action", "adventure", "children",
											"comedy", "crime", "documentary", "drama",
											"drama", "fantasy", "filmnoir", "horror",
											"musical", "mystery", "romance", "scifi",
											"thriller", "war", "western"};
	
	
	public Movie() {
		super();
	}


	public Movie(String movieName, String date, String url, String category) {
		super();
		this.movieName = movieName;
		this.date = date;
		this.url = url;
		this.category = category;
	}


	public int getMovieId() {
		return movieId;
	}


	public String getMovieName() {
		return movieName;
	}

	public String getDate() {
		return date;
	}

	public String getUrl() {
		return url;
	}


	/**
	 * @return A list of categories the movie in
	 */
	public List<String> getCategoryList() {
		List<String> categoryList = new ArrayList<>();
		String[] categoryArr = category.split(",");
		for (int i = 0; i < categoryArr.length; i++) {
			if (categoryArr[i].equals("1")) {
				categoryList.add(categoryName[i]);
			}
		}
		return categoryList;
	}


	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", date=" + date + ", url=" + url
				+ ", category=" + category + "]";
	}
	
}
