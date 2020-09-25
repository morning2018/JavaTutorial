package com.learning.springboot;

import com.learning.springboot.generatedata.BatchGenerateCustOrder;
import com.learning.springboot.generatedata.BatchGenerateData;
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
	private static final long NUM = 500 * 10000 * 24;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		long start = System.currentTimeMillis();
		BatchGenerateData batchGenerateSql = new BatchGenerateData();
		BatchGenerateCustOrder batchGenerateCustOrder = new BatchGenerateCustOrder();
		log.info("开始时间:" + start);
		int sharding = 24;
		//batchGenerateSql.generate(NUM, sharding, modValue);
		batchGenerateCustOrder.generate(NUM, sharding);
		long end = System.currentTimeMillis();
		log.info("结束时间：" + end);
		log.info("花费时间(ms)：" + (end-start));
	}
}
