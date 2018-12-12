package com.app.spring.app.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.spring.app.entity.UserDepartment;

@Repository
@Qualifier(value="UserDepartmentRepository")
public interface UserDepartmentRepository extends JpaRepository<UserDepartment,Long>{

}
