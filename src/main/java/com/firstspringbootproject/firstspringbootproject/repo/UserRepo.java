package com.firstspringbootproject.firstspringbootproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.firstspringbootproject.firstspringbootproject.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByuname(String name);
	
	@Query("select u from User u where u.uname=?1 and u.uemail=?2")
	public User findbynameAndeEmail(String name,String email);

}
