package com.learning.springboot.generatedata;

import lombok.extern.slf4j.Slf4j;

/**
 *  生成日志数据
 * @author morning
 * @date 2020/9/22 18:33
 * @since 0.0.1
 */
@Slf4j(topic = "GENERATE-SQL")
public class BatchGenerateData {
    /**
      *  数据格式：
      *  k,c,pad
      * @author weiyt
      * @date 2020/9/22 15:48
      * @since 3.1.0-SNAPSHOT
      */
    public void generate(int num, int sharding, int modValue) {
        for (int i = 0; i < num; i++ ) {
            int mod = i % sharding;
            if (mod == modValue) {
                log.debug("{},{},{},{}", i, (i +1 ), ("c" + i), ("pad" + i));
            }
        }
    }
}
