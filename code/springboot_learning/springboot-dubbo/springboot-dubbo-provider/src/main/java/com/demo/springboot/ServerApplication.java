package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot启动类 <br> 
 *  
 * @author morning<br>
 * @version 0.1<br>
 * @CreateDate 2017年11月14日 <br>
 * @since v0.1<br>
 * @see com.demo.springboot <br>
 */
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(ServerApplication.class,args);
    	System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("***Start Spring Boot Sucessfully !!!***");
		System.out.println("***************************************");
		System.out.println("***************************************");
    }
}
