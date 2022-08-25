package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface IUserService {
	public User getUserDetails(String email, String password);
	public String addUserDetails(User user);
	public User updateUser(User user);
	public String deleteUser(int id);
	public User findUserById(int id);
	public List<User> findAllUsers();
	public User findUsrByMail(String email);
}
