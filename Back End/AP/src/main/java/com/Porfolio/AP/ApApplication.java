 package com.Porfolio.AP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class ApApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApApplication.class, args);
	}  
        
        
}
