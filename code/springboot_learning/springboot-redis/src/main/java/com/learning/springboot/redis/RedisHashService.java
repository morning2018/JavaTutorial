package com.learning.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 功能描述：
 *  Redis Hash相关操作
 * @author morning
 * @date 2020/5/11 21:42
 * @version v0.0.1
 */
@Component
public class RedisHashService<V> {

    /**
     * redisTemplate
     */
    @Autowired
    private RedisTemplate<String, V> redisTemplate;

    /**
     * Hash表添加元素
     * @param key
     * @param hashKey
     * @param value
     */
   public void put(String key, Object hashKey, Object value) {
       redisTemplate.opsForHash().put(key, hashKey, value);
   }

    /**
     *Hash中批量添加元素
     * @param key
     * @param map
     */
    public void putAll(String key, Map<Object, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * Hash删除一个或者多个元素
     * @param key
     * @param hashKeys
     * @return
     */
   public Long delete(String key, Object... hashKeys) {
       return redisTemplate.opsForHash().delete(key, hashKeys);
   }

    /**
     * 返回Hash
     * @param key
     * @return
     */
    public Map<Object, Object> entries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 返回Hash中的值
     * @param key
     * @param hashKey
     * @return
     */
    public Object get(String key, Object hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * 返回所有的keys
     * @param key
     * @return
     */
    public Set<Object> keys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    /**
     * 返回Hash中values
     * @param key
     * @return
     */
    public List<Object> values(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    /**
     * 判断是否存在key
     * @param key
     * @param hashKey
     * @return
     */
    public Boolean hasKey(String key, Object hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

}
