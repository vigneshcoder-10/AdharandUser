package com.firstspringbootproject.firstspringbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.firstspringbootproject.firstspringbootproject.dao.Aadhardao;
import com.firstspringbootproject.firstspringbootproject.dto.AadharDto;
import com.firstspringbootproject.firstspringbootproject.execption.AadharNotFound;
import com.spring.firstspring.firstspringbootproject.util.ResponseStructure;
@Service
public class AdharService {
	
	@Autowired
	Aadhardao dao;
	
	public ResponseEntity<ResponseStructure<AadharDto>> saveAdhar(AadharDto adhar) {
		
		ResponseStructure<AadharDto> structure=new ResponseStructure<AadharDto>();
		
		AadharDto saveadhar =dao.saveAdhar(adhar);
		if(saveadhar !=null) {
			structure.setData(saveadhar);
			structure.setMessage("adhar Saved Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<AadharDto>>(structure,HttpStatus.CREATED);
		}
		return null;
		
		
		
	}
    public ResponseEntity<ResponseStructure<AadharDto>> findAdhar(int id) {
    	ResponseStructure<AadharDto> structure =new ResponseStructure<AadharDto>();
    	
    	AadharDto exadhar=dao.findById(id);
    	
    	if(exadhar!=null) {
    		structure.setData(exadhar);
    		structure.setMessage("Adhar founf with the given id");
    		structure.setStatus(HttpStatus.FOUND.value());
    		
    		return new ResponseEntity<ResponseStructure<AadharDto>>(structure,HttpStatus.FOUND);
    	}
    	else 
    	throw new AadharNotFound("Adhar not fopund for the given id");
    }
    
    public ResponseEntity<ResponseStructure<AadharDto>>  deleteAdhar(int id){
    	
     ResponseStructure<AadharDto> structure =new ResponseStructure<AadharDto>();
     
     
     AadharDto adhar =dao.findById(id);
     
     if(adhar!=null) {
    	 structure.setData(dao.deleteAdhar(id));
    	 structure.setMessage("Given Id has been Deletd Sucessfully");
    	 structure.setStatus(HttpStatus.OK.value());
    	 return new ResponseEntity<ResponseStructure<AadharDto>>(structure,HttpStatus.OK);
    	 
     }
     else 
    	 return null;
    
    }
    public ResponseEntity<ResponseStructure<AadharDto>> updateAdhar(AadharDto adhar,int id){
    	
    	ResponseStructure< AadharDto> structure=new ResponseStructure<AadharDto>();
    	
    	AadharDto exadhar= dao.updateAdhar(adhar, id);
    	
    	if(exadhar!=null) {
    		
    		structure.setData(exadhar);
    		structure.setMessage("Upadted Successfully");
    		structure.setStatus(HttpStatus.OK.value());
    		return new ResponseEntity<ResponseStructure<AadharDto>>(structure,HttpStatus.OK);
    	}
    	else 
    		return null;
    	
    }
    
    public ResponseEntity<ResponseStructure<List<AadharDto>>> getall(){
    	
    	ResponseStructure<List<AadharDto>> structure= new ResponseStructure<List<AadharDto>>();
    	
    	structure.setData(dao.getalladhar());
    	
    	structure.setMessage("Details of all Users ");
    	structure.setStatus(HttpStatus.FOUND.value());
    	return new ResponseEntity<ResponseStructure<List<AadharDto>>>(structure,HttpStatus.OK);
    	
    }
    }













