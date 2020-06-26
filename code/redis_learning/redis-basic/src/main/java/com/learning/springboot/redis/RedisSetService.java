package com.learning.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

@Component
public class RedisSetService<V> {

    @Autowired
    private RedisTemplate<String, V> redisTemplate;

    public RedisTemplate template() {
        return redisTemplate;
    }

    /**
     * Redis Set 批量新增元素
     * @param key
     * @param values
     * @return
     */
    public Long add(String key, V... values) {
       return redisTemplate.opsForSet().add(key, values);
    }

    /**
     * 删除元素
     * @param key
     * @return
     */
    public Long remove(String key) {
        return redisTemplate.opsForSet().remove(key);
    }

    /**
     * Redis Set中元素移动到另一个Set
     * @param key
     * @param value
     * @param destKey
     */
    public Boolean move(String key, V value, String destKey) {
        return redisTemplate.opsForSet().move(key, value, destKey);
    }

    /**
     * 差集Set集合
     * @param keys
     * @return
     */
    public Set<V> difference(Collection<String> keys) {
        return redisTemplate.opsForSet().difference(keys);
    }

    /**
     * 交集Set集合
     * @param keys
     * @return
     */
    public Set<V> intersect(Collection<String> keys) {
        return redisTemplate.opsForSet().intersect(keys);
    }

    /**
     * 并集Set集合
     * @param keys
     * @return
     */
    public Set<V> union(Collection<String> keys) {
        return redisTemplate.opsForSet().union(keys);
    }

    /**
     * Set集合
     * @param key
     * @return
     */
    public Set<V> members(String key) {
        return redisTemplate.opsForSet().members(key);
    }


}
