
package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryserviceApplication.class, args);
    	System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("***Start Spring Boot Sucessfully !!!***");
		System.out.println("***************************************");
		System.out.println("***************************************");
    }
}