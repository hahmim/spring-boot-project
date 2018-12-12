package com.app.spring.app.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.spring.app.entity.User;

@Repository
@Qualifier(value="UserRepository")
public interface UserRepository extends JpaRepository<User,Long> {
	
	 User findUserByUserId(final Long id);

}
