package com.movieWebsite.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.movieWebsite.model.Movie;
import com.movieWebsite.model.Rating;
import com.movieWebsite.model.User;
import com.movieWebsite.service.MovieService;
import com.movieWebsite.service.RatingService;
import com.movieWebsite.service.UserService;

public class Test {
	
	private ApplicationContext ac;
	private volatile User user;
	private Movie movie;
	private volatile Rating rating;

	@Before
	public void setUp() throws Exception {
		user = new User("dangd", "123456", 25, "M", "Student", 90007);
		ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
	}

	@org.junit.Test
	public void userTest() {
		UserService userService = (UserService)ac.getBean("userService");
		userService.createUser(user);		
		User retUser = userService.findUserByNameAndPassword(user.getUsername(), user.getPassword());
		System.out.println(retUser.toString());
		user = new User("dangdangdang", "123456", 26, "M", "Educator", 90012);
		userService.createUser(user);
		retUser = userService.findUserByNameAndPassword(user.getUsername(), user.getPassword());
		System.out.println(retUser.toString());
	}
	
	@org.junit.Test
	public void ratingTest() {
		UserService userService = (UserService)ac.getBean("userService");
		User retUser = userService.findUserByNameAndPassword(user.getUsername(), user.getPassword());
		RatingService ratingService = (RatingService)ac.getBean("ratingService");
		ratingService.rate(4, retUser, movie);
	}
	
	@org.junit.Test
	public void loginTest() {
		UserService userService = (UserService)ac.getBean("userService");
		user = userService.login("dangdangdang", "12345");
		assert(user == null);
		user = userService.login("dangdangdang", "123456");
		System.out.println(user.toString());
	}

	@org.junit.Test
	public void importUserData() {
		UserService userService = (UserService)ac.getBean("userService");
		List<String> dataList = CSVUtils.importCSV(new File("C:/Users/Clark/Downloads/ee542Project/inputdata/u_user.csv"));
		for (int i = 1; i < dataList.size(); i++) {
			String[] list = dataList.get(i).split(",");
			String zipcodeStr = list[4];
			int zipcode = 90007;
			if (isNumeric(zipcodeStr)) {
				zipcode = Integer.parseInt(zipcodeStr);
			}
			user = new User(list[0], list[0] + list[1], Integer.parseInt(list[1]), list[2], list[3], zipcode);
			userService.createUser(user);
			System.out.println(user.toString());
			//System.out.println(Integer.parseInt(list[1]));
		}
	}
	
	@org.junit.Test
	public void importRatingData() {
		RatingService ratingService = (RatingService)ac.getBean("ratingService");
		List<String> dataList = CSVUtils.importCSV(new File("C:/Users/Clark/Downloads/ee542Project/inputdata/u_data.csv"));
		for (int i = 1; i < dataList.size(); i++) {
			String[] list = dataList.get(i).split(",");
			//System.out.println(list[3]);
			//System.out.println(Integer.parseInt(list[3]));
			rating = new Rating(Integer.parseInt(list[2]), Integer.parseInt(list[0]), Integer.parseInt(list[1]), Integer.parseInt(list[3]));
			//System.out.println(rating.getTime());
			ratingService.rate(rating);
			//System.out.println(rating.toString());
			//System.out.println(Integer.parseInt(list[1]));
		}
	}
	
/*	@org.junit.Test
	public void importMovieData() throws IOException {
		MovieService movieService = (MovieService)ac.getBean("movieService");
		//UserService userService = (UserService)ac.getBean("userService");
		//List<String> dataList = CSVUtils.importCSV(new File("C:/Users/Clark/Downloads/ee542Project/inputdata/u_item.csv"));
		String srcCSV = "C:/Users/Clark/Downloads/ee542Project/inputdata/u_item.csv";
		CsvReader reader = new CsvReader(srcCSV, ',', Charset.forName("UTF-8"));
		while(reader.readRecord()) {
			if (reader.getCurrentRecord() == 0) {
				continue;
			}
			String[] tmp = reader.getValues();
			String category = "";
			for (int i = 5; i < tmp.length; i++) {
				category = category + tmp[i];
				if (i != tmp.length - 1) {
					category += ",";
				}
			}
			movie = new Movie(tmp[1], tmp[2], tmp[4], category);
			movieService.addMovie(movie);
			movie = movieService.findMovieByName(movie.getMovieName());
			System.out.println(movie.toString());
		}
	}
*/	
	
	public static boolean isNumeric(String str){  
		for(int i=str.length();--i>=0;){  
			int chr=str.charAt(i);  
		    if(chr<48 || chr>57) { 
		    	return false;  
		   	}  
		}
		return true;  
	}
	
	@org.junit.Test
	public void movieListTest() {
		MovieService movieService = (MovieService)ac.getBean("movieService");
		List<Movie> movieList = movieService.movieList();
		for (int i = 0; i < movieList.size(); i++) {
			System.out.println(movieList.get(i).toString());
		}
	}
	

}
