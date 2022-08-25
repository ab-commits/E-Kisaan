package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserRepository;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImple implements IUserService {
	@Autowired
	private IUserRepository userRepo;

	@Override
	public User getUserDetails(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new RuntimeException("Invalid Login Details"));
	}

	@Override
	public String addUserDetails(User user) {
		userRepo.save(user);
		return "User addedd successfully ...!";
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public String deleteUser(int id) {
		userRepo.deleteById(id);
		return "User Successfully deleted";
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).orElseThrow(()->new RuntimeException("Invalid USer id"));
	}

	@Override
	public List<User> findAllUsers() {
		List<User> list = userRepo.findAll();
		System.out.println(list);
		return list;
	}
	
	@Override
	public User findUsrByMail(String email) {
		
		return userRepo.findByEmail(email);
	}


}
