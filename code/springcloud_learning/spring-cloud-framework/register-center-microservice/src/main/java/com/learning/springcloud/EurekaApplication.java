
package com.learning.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    /**
     * 日志打印
     */
    private static final Logger LOG = LoggerFactory.getLogger(EurekaApplication.class);

    public static void main(String[] args) {
        LOG.info("***************************************");
        LOG.info("***   Start Eureka Microservice    ***");
        LOG.info("***************************************");
        SpringApplication.run(EurekaApplication.class, args);
        LOG.info("***************************************");
        LOG.info("***    Start Eureka Sucessfully     ***");
        LOG.info("***************************************");
    }
}