package com.learning.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 功能描述：
 *  Redis List 服务操作类
 * @author morning
 * @date 2020/5/9 22:26
 * @version v0.0.1
 */
@Component
public class RedisListService<V> {

	@Autowired
	private RedisTemplate<String, V> redisTemplate;

	public RedisTemplate template() {
		return redisTemplate;
	}

	/**
	 * 功能描述：
	 *  左侧弹出
	 * @author morning
	 * @date 2020/5/10 16:59
	 * @version v0.0.1
	 */
	public V leftPop(final String key) {
		return redisTemplate.opsForList().leftPop(key);
	}

	/**
	 * 功能描述：
	 *  右侧弹出
	 * @author morning
	 * @date 2020/5/10 17:00
	 * @version v0.0.1
	 */
	public V rightPop(final String key) {
		return redisTemplate.opsForList().rightPop(key);
	}

	/**
	 * 功能描述：
	 *  左侧加入
	 * @author morning
	 * @date 2020/5/10 17:00
	 * @version v0.0.1
	 */
	public Long leftPush(final String key, V value) {
		return redisTemplate.opsForList().leftPush(key, value);
	}

	/**
	  * 功能描述:
	  *  集合中元素添加到头部
	  * @author morning
	  * @date 2020/5/10 17:41
	  * @version v0.0.1
	   * @param key
	   * @return  values
	  */
	public Long leftPushAll(final String key, Collection<V> values) {
		return redisTemplate.opsForList().leftPushAll(key, values);
	}

	public Long leftPushAll(final String key, V... value) {
		return redisTemplate.opsForList().leftPushAll(key, value);
	}

	/**
	 * 功能描述：
	 *  右侧加入
	 * @author morning
	 * @date 2020/5/10 17:00
	 * @version v0.0.1
	 */
	public Long rightPush(final String key, V value) {
		return redisTemplate.opsForList().rightPushAll(key, value);
	}
	public Long rightPushAll(final String key, V... value) {
		return redisTemplate.opsForList().rightPushAll(key, value);
	}
	/**
	 * 功能描述:
	 *  集合中元素添加到尾部
	 * @author morning
	 * @date 2020/5/10 17:41
	 * @version v0.0.1
	 * @param key
	 * @return  values
	 */
	public Long rightPushAll(final String key, Collection<V> values) {
		return redisTemplate.opsForList().rightPushAll(key, values);
	}

	/**
	  * 功能描述:
	  *  删除key中的value值，逻辑如下：
	  *   count>0,从头到尾进行扫描，删除第一个匹配的元素
	  *   count<0,从头到尾进行扫描，删除第一个匹配的元素
	  *   count=0,删除所有匹配的元素
	  * @author morning
	  * @date 2020/5/10 19:19
	  * @version v0.0.1
	  * @param key
	  * @return Long
	  */
	public Long remove(final String key, long count, V value) {
		return redisTemplate.opsForList().remove(key, count, value);
	}
}
