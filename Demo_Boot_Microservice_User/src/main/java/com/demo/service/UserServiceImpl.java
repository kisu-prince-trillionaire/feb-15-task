package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.User;
import com.demo.dao.UserDao;
import com.demo.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	@Override
	public List<User> getAllUser() {
		return (List<User>) dao.findAll();
	}

	@Override
	public User getUser(String id) {
		return dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id doesn't exist : " + id));
	}

	@Override
	public User addUser(User user) {
		return dao.save(user);
	}

	@Override
	public User updateUser(User user) {
		return dao.save(user);
	}

	@Override
	public String deleteUser(String id) {
		dao.deleteById(id);
		return "Deleted Sucessfully";
	}

}
