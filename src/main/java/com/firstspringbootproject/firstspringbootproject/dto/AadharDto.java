package com.firstspringbootproject.firstspringbootproject.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Component

@Table(name = "Adhar")
public class AadharDto {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	//@Positive
	//@Min(value = 1)
	private int id;
	
	@NotBlank(message = "anumber cannot be Blank")
	@NotNull(message = "anumber cannot be Null")
	private String anumber;
	@NotBlank(message = "address cannot be Blank")
	@NotNull(message = "address cannot be Null")
	private String address;
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnumber() {
		return anumber;
	}
	public void setAnumber(String anumber) {
		this.anumber = anumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "AadharDto [id=" + id + ", anumber=" + anumber + ", address=" + address + "]";
	}
	
	

}
