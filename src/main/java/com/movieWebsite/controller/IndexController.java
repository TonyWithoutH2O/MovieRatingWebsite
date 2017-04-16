package com.movieWebsite.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieWebsite.model.ResJSON;
import com.movieWebsite.model.User;
import com.movieWebsite.model.UserException;
import com.movieWebsite.service.UserService;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/login.do")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(" login validation");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User currentUser = userService.findUserByNameAndPassword(username, password);
		if (currentUser == null) {
			throw new UserException("User dosen't exist or wrong password");
		}
		Cookie cookie = new Cookie("userInfo", username + "-" + password);
		cookie.setMaxAge(60 * 60 * 24);

		response.addCookie(cookie);
		HttpSession session = request.getSession();
		session.setAttribute("currentUser", currentUser);

		ResJSON.writeToResponse(ResJSON.toResJSON(0, "Success"), response);
		return;
	}

	@RequestMapping(value = "/userIndex.do")
	public void userIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		if (currentUser == null) {
			//throw new UserException("Please log in first!");
			//TODO redirect to the login page
		}

		ResJSON.writeToResponse(ResJSON.toResJSON(currentUser), response);
		return;
	}
	
}
