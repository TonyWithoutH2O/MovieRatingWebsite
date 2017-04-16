package com.movieWebsite.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.movieWebsite.model.ResJSON;
import com.movieWebsite.model.User;
import com.movieWebsite.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/add.do")
	public void add(HttpServletRequest request, HttpServletResponse response) {
		String json = request.getParameter("user");
		User newUser = new Gson().fromJson(json, User.class);
		if (userService.createUser(newUser)) {
			return;
		} else {
			// TODO create failed response
		}
	}

	@RequestMapping(value = "/update.do")
	public void update(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser == null) {
			// TODO redirect to login
		}
		String json = request.getParameter("user");
		User user = (User) (new Gson().fromJson(json, User.class));
		user.setUserid(currentUser.getUserid());
		user.setUsername(currentUser.getUsername());
		userService.updateUser(user);
	}

	@RequestMapping(value = "/{username}.do")
	public void userIndex(@PathVariable String username, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser == null || (!currentUser.getUsername().equals(username))) {
			// TODO redirect to login
		}
		ResJSON.writeToResponse(ResJSON.toResJSON(currentUser), response);
	}

}
