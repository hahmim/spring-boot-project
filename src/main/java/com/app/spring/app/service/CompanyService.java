package com.app.spring.app.service;

import java.util.List;
import java.util.Optional;

import com.app.spring.app.entity.User;
import com.app.spring.app.entity.UserDepartment;

public interface CompanyService {
	
	List<User> getAllUsers();
	List<UserDepartment> getAllUserDepartment();
	
	User addUser(User user);
	
	void updateUser(User user);
	
	User deleteUser(User optional);
	
	User findUserById(Long Id);

}
