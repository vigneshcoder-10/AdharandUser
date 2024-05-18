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

import com.firstspringbootproject.firstspringbootproject.dto.AadharDto;
import com.firstspringbootproject.firstspringbootproject.service.AdharService;
import com.spring.firstspring.firstspringbootproject.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("adhar")
public class AadharController {
	@Autowired
	AdharService service;
    @Operation(summary = "Api Used for Saving Adhar")
	@PostMapping
	public  ResponseEntity<ResponseStructure<AadharDto>>  saveAdhar(@RequestBody AadharDto adhar) {
		   return service.saveAdhar(adhar);
	}
	@GetMapping
	@Operation(summary = "Api Used for Finding Aadhar")
	public ResponseEntity<ResponseStructure<AadharDto>> findById(@RequestParam int id) {
		return service.findAdhar(id);
	}
	
	
	@PutMapping
	@Operation(summary = "Api is used for Update Aadhar")
	public ResponseEntity<ResponseStructure<AadharDto>> updateAdhar(@RequestBody AadharDto adhar, int id){
		return service.updateAdhar(adhar, id);
		
	}
	@DeleteMapping
	@Operation(summary = "Api is used to delete Particular Aadhar")
	public ResponseEntity<ResponseStructure<AadharDto>> deleteAdhar(@RequestParam int id)
	{
		return service.deleteAdhar(id);
	}
	
	@GetMapping("getall")
	@Operation(summary = "Api is used to Find All Aadhar")
	public ResponseEntity<ResponseStructure<List<AadharDto>>> getall(){
	return service.getall();
	
	}
	}

