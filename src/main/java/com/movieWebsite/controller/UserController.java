package com.movieWebsite.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movieWebsite.model.User;
import com.movieWebsite.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	/*
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/list");
		return mav;
	}
	*/
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new User());
		return "user/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(User user) {
		userService.createUser(user);
		return "redirect:/index/login";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User currentUser = (User)session.getAttribute("currentUser");
		if (currentUser == null) {
			return "redirect:/index/login"; //Redirect to login page if there's no current user
		}
		model.addAttribute(new User());
		return "user/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, User user) {
		HttpSession session = request.getSession();
		User currentUser = (User)session.getAttribute("currentUser");
		if (currentUser == null) {
			return "redirect:/index/login";//Temporarily redirect to the login page before erro page finished
		}
		user.setUsername(currentUser.getUsername());
		user.setUserid(currentUser.getUserid());
		userService.updateUser(user);
		return "redirect:/index/login";
	}
	
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String userIndex(@PathVariable String username, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User currentUser = (User)session.getAttribute("currentUser");
		//User currentUser = (User)userService.findUserByName(username);
		if (currentUser == null) {
			return "redirect:/index/login";
		}
		if (currentUser.getUsername().equals(username)) {
			model.addAttribute(username);
			return "user/userIndex";			
		}
		return "redirect:/index/login";
	}

}
