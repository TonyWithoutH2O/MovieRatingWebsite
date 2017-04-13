package com.movieWebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_user")
public class User {
	
	@Id
	@GenericGenerator(name = "generator", strategy = "native")
	@GeneratedValue(generator = "generator")
	@Column(name="userid", length = 11)
	private int userid;
	
	@Column(unique = true)
	private String username;
	
	@Column
	private String password;
	
	@Column
	private int age;
	
	@Column
	private String gender;
	
	@Column
	private String occupation;
	
	@Column
	private int zipcode;
	
	
	public User() {
		super();
	}
	
	public User(String username) {
		super();
		this.username = username;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, int age, String gender, String occupation, int zipcode) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.zipcode = zipcode;
	}

	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", age=" + age
				+ ", gender=" + gender + ", occupation=" + occupation + ", zipcode=" + zipcode + "]";
	}
	

}
