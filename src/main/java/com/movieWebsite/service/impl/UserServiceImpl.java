package com.movieWebsite.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movieWebsite.dao.BaseDao;
import com.movieWebsite.model.User;
import com.movieWebsite.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private BaseDao<User> baseDao;
	
	@Override
	@Transactional
	public void createUser(User user) {
		User retUser = findUserByName(user.getUsername());
		if (retUser == null) {
			baseDao.save(user);
		}
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		baseDao.delete(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		baseDao.update(user);
	}

	@Override
	@Transactional
	public User findUserByNameAndPassword(String username, String password) {
		String hql = "from User u where u.username=? and u.password=?";
		return baseDao.get(hql, new Object[] {username, password});
	}
	
	@Override
	@Transactional
	public User login(String username, String password) {
		User loginUser = findUserByName(username);
		if (loginUser == null) {
			return null;
		}
		if (!loginUser.getPassword().equals(password)) {
			return null;
		}
		return loginUser;
	}

	@Override
	@Transactional
	public User findUserByName(String userName) {
		String hql = "from User u where u.username=?";
		return baseDao.get(hql, new Object[] {userName});		
	}
	
}
