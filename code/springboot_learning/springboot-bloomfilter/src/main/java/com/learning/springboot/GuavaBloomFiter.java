package com.learning.springboot;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import com.google.common.hash.PrimitiveSink;

import java.nio.charset.Charset;

/**
 *  guava bloom filter
 *  布隆过滤器验证存在，则可能不存在
 *  布隆过滤器验证不存在，则一定不存在
 * @author weiyt
 * @date 2020/9/10 13:33
 * @since 0.0.1-SNAPSHOT
 */
public class GuavaBloomFiter {
    /**
     * 预计个数
     */
    private final long size = 100000000;

    /**
     * 初始化过滤器
     */
    private BloomFilter<String> bloom = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), size);

    /**
     添加元素
     * @param str
     */
    public void put(String str) {
        bloom.put(str);
    }

    /**
     * 判断是否存在
     * @param str
     * @return
     */
    public boolean mightContain(String str) {
        return bloom.mightContain(str);
    }


    public static void main(String[] args) {
        GuavaBloomFiter blBoolmTest = new GuavaBloomFiter();
        String mystr = "GuavaBloomFiterGuavaBloomFiterGuavaBloomFiterGuavaBloomFiterGuavaBloomFiterGuavaBloomFiterGuavaBloomFiterGuavaBloomFiterGuavaBloomFiterGuavaBloomFiterGuavaBloomFiterGuavaBloomFiter";
        for (int i =0;i<10000000;i++) {
            blBoolmTest.put(mystr + i);
        }
         for (int i =0;i<1000000;i++) {
            String str = mystr + (i*100);
            System.out.println(str + "已添加：" + blBoolmTest.mightContain(str));
         }
    }

}
