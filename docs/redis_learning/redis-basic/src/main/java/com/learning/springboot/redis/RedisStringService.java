package com.learning.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 功能描述：
 *  Redis操作工具类
 * @author morning
 * @date 2020/5/9 22:26
 * @version v0.0.1
 */
@Component
public class RedisStringService<V> {

	@Autowired
	private RedisTemplate<String, V> redisTemplate;

	public RedisTemplate template() {
		return redisTemplate;
	}

	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	public V get(final String key) {
		return redisTemplate.opsForValue().get(key);

	}

	/**
	 * 写入缓存
	 */
	public boolean set(final String key, V value) {
		boolean result = false;
		try {
			redisTemplate.opsForValue().set(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 更新缓存
	 */
	public boolean getAndSet(final String key, V value) {
		boolean result = false;
		try {
			redisTemplate.opsForValue().getAndSet(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 删除缓存
	 */
	public boolean delete(final String key) {
		boolean result = false;
		try {
			redisTemplate.delete(key);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
