
package com.learning.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 功能描述：
 *  eureka注册中心
  @author morning
 * @date 2020/4/21 21:22
 * @version v0.0.1
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
		System.out.println("***************************************");
		System.out.println("***    Start Eureka Sucessfully     ***");
		System.out.println("***************************************");
    }
}