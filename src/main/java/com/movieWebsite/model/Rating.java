package com.movieWebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_rating")
public class Rating {
	
	@Id
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	@Column(name="rateId", length = 11)
	private int rateId;
	
	@Column
	private int rate;
	
	@Column
	private int movieId;
	
	@Column
	private int userId;
	
	@Column
	private int time;
	
	public Rating() {
		super();
	}

	public Rating(int rate, int userId, int movieId, int time) {
		super();
		this.rate = rate;
		this.userId = userId;
		this.movieId = movieId;
		this.time = time;
	}

	public Rating(int rate, int userId, int movieId) {
		super();
		this.rate = rate;
		this.userId = userId;
		this.movieId = movieId;
		this.time = (int) (System.currentTimeMillis() / 1000L);
	}

	public int getRateId() {
		return rateId;
	}

	public int getRate() {
		return rate;
	}

	public int getMovieId() {
		return movieId;
	}

	public int getUserId() {
		return userId;
	}

	public int getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "Rating [rateId=" + rateId + ", rate=" + rate + ", movieId=" + movieId + ", userId=" + userId + ", time="
				+ time + "]";
	}

	
}
