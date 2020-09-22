package com.learning.springboot;

import com.learning.springboot.generatesql.BatchGenerateData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  application
 * @author morning
 * @date 2020/9/22 16:00
 * @since 0.0.1
 */
@SpringBootApplication
@Slf4j
public class Application {

	/**
	 * 按照24取余进行生成
	 */
	private static final int NUM = 500 * 10000 * 24;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		long start = System.currentTimeMillis();
		log.info("开始时间:" + start);
		BatchGenerateData batchGenerateSql = new BatchGenerateData();
		int sharding = 24;
		int modValue = 0;
		batchGenerateSql.generate(NUM, sharding, modValue);
		long end = System.currentTimeMillis();
		log.info("结束时间：" + end);
		log.info("花费时间(ms)：" + (end-start));
	}
}
