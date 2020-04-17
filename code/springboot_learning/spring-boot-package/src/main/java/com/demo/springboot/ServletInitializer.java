package com.demo.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 *  通过继承SpringBootServletInitializer类 Spring Boot应用能够使用嵌入的Spring上下文来注册配置，
 *  这个Spring上下文是在容器初始化的时候创建的
 * @author morning<br>
 * @version 0.1<br>
 * @CreateDate 2017年11月13日 <br>
 * @since v0.1<br>
 * @see com.demo.springboot <br>
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
