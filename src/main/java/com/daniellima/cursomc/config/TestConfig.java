package com.daniellima.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.daniellima.cursomc.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	public DBService dbservice;
	
	@Bean
	public boolean InstantiateTestDataBase() throws ParseException {
		dbservice.InstantiateTestDataBase();
		
		return true;
		
	}

}
