package com.firstspringbootproject.firstspringbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.firstspringbootproject.firstspringbootproject.dao.Aadhardao;
import com.firstspringbootproject.firstspringbootproject.dao.Userdao;
import com.firstspringbootproject.firstspringbootproject.dto.AadharDto;
import com.firstspringbootproject.firstspringbootproject.dto.User;
import com.firstspringbootproject.firstspringbootproject.execption.UserNotFound;
import com.spring.firstspring.firstspringbootproject.util.ResponseStructure;


@Service
public class UserService {
	@Autowired
	Userdao udao;
	
	@Autowired
	Aadhardao adao;
	
	public ResponseEntity<ResponseStructure<User>> saveuser(User u){
		ResponseStructure<User> structure = new ResponseStructure<User>();
		User saveduser = udao.saveUser(u);
		
		if(saveduser!=null) {
			structure.setData(saveduser);
			structure.setMessage("user saved");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
		}
		return null; // exception for user not saved
	}
	
	public ResponseEntity<ResponseStructure<User>> findUser(int id){
		ResponseStructure<User> structure = new ResponseStructure<User>();
		
		User dbuser = udao.findUser(id);
		if(dbuser!=null) {
			structure.setData(dbuser);
			structure.setMessage("user found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}
		throw new UserNotFound("User is not found for the given id");
	}
	
	public ResponseEntity<ResponseStructure<User>> assignAdharToUser(int uid, int aid){
		ResponseStructure<User> structure = new ResponseStructure<User>();
		
		User exuser = udao.findUser(uid);
		AadharDto exadhar = adao.findById(aid);
		
		if(exadhar!=null) {
			if(exuser!=null) {
				exadhar.setUser(exuser);
				exuser.setAdhar(exadhar);
				AadharDto updatedadhar = adao.updateAdhar(exadhar,exadhar.getId());
				structure.setData(updatedadhar.getUser());
				structure.setMessage("adhar assigned to a user");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
				
			}return null; // throw user not found exception
		}return null; // throw adhar not found exception
		
	}
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id){
		
		ResponseStructure<User> structure=new ResponseStructure<User>();
		
		
		User user=udao.findUser(id);
		
		if(user!=null) {
			
			structure.setMessage("The Given Id Was Deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			
			structure.setData(udao.deleteUser(id));
			
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			
		}
		 return null;
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User u,int id){
		
		
		ResponseStructure<User> structure=new ResponseStructure<User>()	;
		
		
		User user=udao.updateUser(u, id);
		
		if(user!=null) {
			
			user.setUid(id);
			structure.setData(user);
			structure.setMessage("User has been Updated Succesfully");
			structure.setStatus(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			
			
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> getallUser(){
		
		ResponseStructure<List<User>> structure=new ResponseStructure<List<User>>();
		
		structure.setData(udao.getall());
		
		structure.setMessage("Details of all Users");
		
	   structure.setStatus(HttpStatus.FOUND.value());
	   
	   return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);
		
	}
	
}
