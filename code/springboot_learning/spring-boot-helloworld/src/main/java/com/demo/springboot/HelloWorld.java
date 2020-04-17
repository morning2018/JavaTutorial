package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorld {
	 @RequestMapping("/")
	    String home() {
	        return "Hello World!";
	    }
	
	    public static void main(String[] args) throws Exception {
	    	// 启动成功后访问http://localhost:8080/，界面显示Hello World!
	    	SpringApplication.run(HelloWorld.class, args);
	    }
	 

}
