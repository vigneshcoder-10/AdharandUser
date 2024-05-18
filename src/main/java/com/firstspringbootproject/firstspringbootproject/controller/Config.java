package com.firstspringbootproject.firstspringbootproject.controller;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class Config implements WebMvcConfigurer{
	@Bean
	public OpenAPI swaggerDocApi() {
			
		Server server1 = new Server();
		server1.setUrl("http://localhost:8080/");
		server1.setDescription("Server for Testing");
		
		Server server2 = new Server();
		server2.setUrl("http://localhost:8080/");
		server2.setDescription("Server for Production");
		
		Contact co = new Contact();
		co.setEmail("vickyrohith01@gmail.com");
		co.setName("DomainName");
		co.setUrl("www.appdomain.com");
		
		License license = new License();
		license.setName("License Provider: Approved by Google");
		license.setUrl("License URL ");
		
		Info info = new Info();
		info.setContact(co);
		info.setLicense(license);
		info.setDescription(" App Description ");
		info.setTermsOfService(" Url for terms and services ");
		info.setTitle(" Aadhar and User Connection Project");
		info.setVersion("2.1");
		
		OpenAPI api = new OpenAPI();
		api.setInfo(info);
		api.setServers(Arrays.asList(server1,server2));
		return api;
	}
	
}
