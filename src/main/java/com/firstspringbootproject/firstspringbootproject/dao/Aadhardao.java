package com.firstspringbootproject.firstspringbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.firstspringbootproject.firstspringbootproject.dto.AadharDto;
import com.firstspringbootproject.firstspringbootproject.repo.Aadharrepo;

@Repository
public class Aadhardao {
	
	@Autowired
	Aadharrepo repo;

	public AadharDto saveAdhar(AadharDto adhar) {
		return repo.save(adhar);
	}
	
	public AadharDto findById(int id) {
		Optional<AadharDto> opadhar=repo.findById(id);
	   if(opadhar.isPresent())
		   return opadhar.get();
	   else 
		   return null;
	}
	
	
	public AadharDto deleteAdhar(int id) {
		
		AadharDto adhar =findById(id);
		
		if(adhar!=null) {
			repo.delete(adhar);
			return adhar;
		}
		else {
			return null;
		}
	}
	
	public AadharDto updateAdhar(AadharDto adhar,int id ) {
		
		AadharDto existingAdhar=findById(id);
		
		if(existingAdhar!=null) {
			adhar.setId(id);
			return repo.save(adhar);
		}
		return null;
	}
	
	public List<AadharDto> getalladhar(){
		return repo.findAll();
	}
	
}
