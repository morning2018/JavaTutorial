
package com.learning.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 功能描述：
 *  eureka注册中心
  @author morning
 * @date 2020/4/21 21:22
 * @version v0.0.1
 */
@SpringBootApplication
@EnableEurekaClient
public class ProductApplication {
    /**
     * 日志打印
     */
    private static final Logger LOG = LoggerFactory.getLogger(ProductApplication.class);

    public static void main(String[] args) {
        LOG.info("***************************************");
        LOG.info("***   Start Product Microservice    ***");
        LOG.info("***************************************");
        SpringApplication.run(ProductApplication.class, args);
        LOG.info("***************************************");
        LOG.info("***    Start Product Sucessfully     ***");
        LOG.info("***************************************");
    }
}