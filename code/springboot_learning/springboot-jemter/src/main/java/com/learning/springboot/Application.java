package com.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动StringBoot
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("*****Start Spring Boot *****");
		System.out.println("***************************************");
		SpringApplication.run(Application.class, args);
		System.out.println("***************************************");
		System.out.println("***Start Spring Boot Sucessfully ***");
		System.out.println("***************************************");
	}
}
