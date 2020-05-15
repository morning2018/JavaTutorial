package com.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动StringBoot
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.learning"})
public class Application {

	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("*****Start Spring Boot Begining!!!*****");
		System.out.println("***************************************");
		SpringApplication.run(Application.class, args);
		System.out.println("***************************************");
		System.out.println("***Start Spring Boot Sucessfully !!!***");
		System.out.println("***************************************");
	}
}
