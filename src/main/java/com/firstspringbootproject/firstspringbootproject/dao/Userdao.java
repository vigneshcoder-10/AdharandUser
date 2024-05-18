package com.firstspringbootproject.firstspringbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.firstspringbootproject.firstspringbootproject.dto.User;
import com.firstspringbootproject.firstspringbootproject.repo.UserRepo;


@Repository
public class Userdao {

	@Autowired
	UserRepo repo ;
	
	public User saveUser(User u) {
		return repo.save(u);
	}
	
	public User findUser(int id) {
		Optional<User> u=repo.findById(id);
		if(u.isPresent()) {
			return u.get();
		}else return null;
		
	}
	
	
	public User deleteUser(int id) {
		User u=findUser(id);
		
		if(u!=null) {
			repo.delete(u);
			return u;
		}
		else return null;
	}
	
	public User updateUser(User user,int id) {
		
		User u=findUser(id);
		
		if(u!=null) {
			u.setUid(id);
			return repo.save(user);
			
		}return null;
	}
	
	public List<User> getall ()
	{
		return repo.findAll();
	}
}
