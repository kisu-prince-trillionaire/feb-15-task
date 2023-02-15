package com.demo.service;

import java.util.List;

import com.demo.bean.User;

public interface UserService {
	
	public List<User> getAllUser();

	public User getUser(String id);

	public User addUser(User user);

	public User updateUser(User user);

	public String deleteUser(String id);
}
