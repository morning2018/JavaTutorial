package com.demo.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.springboot.mapper")
public class Application {

	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("*****Start Spring Boot Begining!!!*****");
		System.out.println("***************************************");
		System.out.println("***************************************");
		SpringApplication.run(Application.class, args);
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("***Start Spring Boot Sucessfully !!!***");
		System.out.println("***************************************");
		System.out.println("***************************************");
	}
}
