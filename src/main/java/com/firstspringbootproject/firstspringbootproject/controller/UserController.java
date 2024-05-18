package com.firstspringbootproject.firstspringbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firstspringbootproject.firstspringbootproject.dto.User;
import com.firstspringbootproject.firstspringbootproject.repo.UserRepo;
import com.firstspringbootproject.firstspringbootproject.service.UserService;
import com.spring.firstspring.firstspringbootproject.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("user")
public class UserController {
	
	
	@Autowired
	UserService service;
	
	@Autowired
	UserRepo urepo;
	
	@PostMapping
	@Operation(summary = "Api is Used For Saving User")
	public ResponseEntity<ResponseStructure<User>> saveuser(@RequestBody User u){
		return service.saveuser(u);
	}
	
	@GetMapping
	@Operation(summary = "Api is Used for Find Particular User")
	public ResponseEntity<ResponseStructure<User>> finduser(@RequestParam int id){
		return service.findUser(id);
	}
	

	@PutMapping("assignadhar")
	@Operation(summary = "Api is Used for Assigning Aadhar to User-")
	public ResponseEntity<ResponseStructure<User>> assignAdharToUser(@RequestParam int uid,@RequestParam int aid){
		return service.assignAdharToUser(uid, aid);
	}
	
	@GetMapping("findbyname")
	@Operation(summary = "Api is Used for Find User By Name")
	public User findUserByName(@RequestParam String name) {
		return urepo.findByuname(name);
	}
	
	@GetMapping("login")
	@Operation(summary = "Api is Used for Find User By Name And Email")
	public User findUserByNameandEmail(@RequestParam String name,@RequestParam String email) {
		return urepo.findbynameAndeEmail(name, email);
	}
	
	@DeleteMapping
	@Operation(summary = "Api is Used For Deleting Particular User")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id) {
		return service.deleteUser(id);
	}
	
	
	@PutMapping("updateuser")
	@Operation(summary = "Api is used for deleting particular User")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user,int id){
		
		return service.updateUser(user, id);
		
	}
	@GetMapping("alluser")
	@Operation(summary = "Api is Used for Find allUser")
	public  ResponseEntity<ResponseStructure<List<User>>> getall(){
		return service.getallUser();
	}
}
