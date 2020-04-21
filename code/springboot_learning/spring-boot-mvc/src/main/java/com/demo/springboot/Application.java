package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 启动StringBoot
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

	// 启动成功后访问：http://localhost:8080/springboot/
	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("*****Start Application Begining!!!*****");
		System.out.println("***************************************");
		System.out.println("***************************************");
		SpringApplication.run(Application.class, args);
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("***Start Application Sucessfully !!!***");
		System.out.println("***************************************");
		System.out.println("***************************************");
	}
}
