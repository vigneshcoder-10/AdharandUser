package com.firstspringbootproject.firstspringbootproject.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
@Entity
@Component
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//@Positive
	//@Min(value = 1)
	//@Max(value = 99999999)
	private int uid;
	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUemail() {
		return uemail;
	}


	public void setUemail(String uemail) {
		this.uemail = uemail;
	}


	public AadharDto getAdhar() {
		return adhar;
	}


	public void setAdhar(AadharDto adhar) {
		this.adhar = adhar;
	}

  @NotBlank(message = "name Cannot be Blank")
  @NotNull(message = "name Caannot be Empty")
  
	private String uname;
	
	@Email
//	@NotBlank(message = "email cannot be blank")
	//@NotNull(message = "email cannot be empty")
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
,message = "email format should be name@domain.com")
	private String uemail;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private AadharDto adhar;

	

}
