package com.phegon.FoodApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAppApplication.class, args);
	}

}



// Enable MySql
// sudo systemctl start mysql
// sudo systemctl enable mysql
// sudo systemctl start apache2
// sudo systemctl enable apache2
