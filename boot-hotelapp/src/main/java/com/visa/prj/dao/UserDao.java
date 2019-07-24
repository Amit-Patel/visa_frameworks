package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.User;


public interface UserDao extends JpaRepository<User, String> {
	
	@Query("from User u where u.email = :e and u.password = :p")
	User getByEmailAndPassword(@Param("e") String email, @Param("p") String password);
}
