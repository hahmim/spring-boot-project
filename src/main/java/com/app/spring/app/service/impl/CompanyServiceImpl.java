package com.app.spring.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.spring.app.entity.User;
import com.app.spring.app.entity.UserDepartment;
import com.app.spring.app.repositories.UserDepartmentRepository;
import com.app.spring.app.repositories.UserRepository;
import com.app.spring.app.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserDepartmentRepository userDepartmentRepository;
	
	
	

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public List<UserDepartment> getAllUserDepartment() {
	
		return userDepartmentRepository.findAll();
	}


	@Override
	public User addUser(User user) {
		userRepository.save(user);
		return user;
		
	}


	@Override
	public void updateUser(User user) {
		userRepository.save(user);	
	}


	@Override
	public User deleteUser(User user) {
		userRepository.delete(user);
		return user;
		
	}


	@Override
	public User findUserById(Long Id) {
		return userRepository.findUserByUserId(Id);
	}

}
