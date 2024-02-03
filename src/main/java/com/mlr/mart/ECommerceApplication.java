package com.mlr.mart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*this is the starting point of the application
 *@author Laxman
 *
 */

@SpringBootApplication
public class ECommerceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

}
