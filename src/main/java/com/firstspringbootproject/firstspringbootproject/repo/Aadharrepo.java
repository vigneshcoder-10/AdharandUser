package com.firstspringbootproject.firstspringbootproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstspringbootproject.firstspringbootproject.dto.AadharDto;

public interface Aadharrepo  extends JpaRepository<AadharDto, Integer>{

}
