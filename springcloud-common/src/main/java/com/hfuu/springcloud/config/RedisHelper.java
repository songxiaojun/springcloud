package com.hfuu.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.NumberUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis 服务接口实现类
 */
@Service
public class RedisHelper {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> opsForHash;
    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> opsForList;
    @Resource(name = "redisTemplate")
    private SetOperations<String, Object> opsForSet;
    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> opsForValue;
    @Resource(name = "redisTemplate")
    private ZSetOperations<String, Object> opsForZSet;
    @Resource(name = "stringRedisTemplate")
    private HashOperations<String, String, String> stringOpsForHash;
    @Resource(name = "stringRedisTemplate")
    private ListOperations<String, String> stringOpsForList;
    @Resource(name = "stringRedisTemplate")
    private SetOperations<String, String> stringOpsForSet;
    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> stringOpsForValue;
    @Resource(name = "stringRedisTemplate")
    private ZSetOperations<String, String> stringOpsForZSet;

    /**
     * 获取匹配的keys
     *
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern) {
        // TODO 获取匹配的keys
        return redisTemplate.keys(pattern);
    }

    /**
     * 是否存在key
     *
     * @param key
     * @return
     */
    public Boolean hasKey(String key) {
        // TODO 是否存在key
        return redisTemplate.hasKey(key);
    }

    /**
     * 设置key的过期时间
     *
     * @param key
     * @param expire_time：毫秒
     */
    public void expire(String key, Long expire_time) {
        // TODO 设置key的过期时间
        redisTemplate.expire(key, expire_time, TimeUnit.MILLISECONDS);
    }

    /**
     * 根据 key 删除存储的对象
     *
     * @param keys
     * @param value
     */
    public void delete(Set<String> keys) {
        // TODO 根据 key 删除存储的对象
        redisTemplate.delete(keys);
    }

    /**
     * 根据 keys 删除存储的对象
     *
     * @param keys
     * @param value
     */
    public void delete(String key) {
        // TODO 根据 key 删除存储的对象
        redisTemplate.delete(key);
    }

    /**
     * 设置字符串类型的 key-value
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        // TODO 设置字符串类型的 key-value
        stringOpsForValue.set(key, value);
    }

    /**
     * 设置字符串类型的 key-value, 不存在key设置
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean setIfAbsent(String key, String value) {
        // TODO 设置字符串类型的 key-value
        return stringOpsForValue.setIfAbsent(key, value);
    }

    /**
     * 设置多个字符串类型的 keys-values
     *
     * @param keys_values
     */
    public void multiSet(Map<String, String> keys_values) {
        // TODO 设置多个字符串类型的 keys-values
        stringOpsForValue.multiSet(keys_values);
    }

    /**
     * 设置字符串类型的 key-value + 过期时间
     *
     * @param key
     * @param value
     * @param expir_time：毫秒
     */
    public void set(String key, String value, Long expir_time) {
        // TODO 设置字符串类型的 key-value + 过期时间
        stringOpsForValue.set(key, value, expir_time, TimeUnit.MILLISECONDS);
    }

    /**
     * 根据 key 获取存储的字符串类型的 value
     *
     * @param key
     * @param value
     */
    public String get(String key) {
        // TODO 根据 key 获取存储的字符串类型的 value
        return stringOpsForValue.get(key);
    }

    /**
     * 根据 key 获取存储的字符串类型的 value
     *
     * @param key
     * @param value
     */
    public String getAndSet(String key, String value) {
        // TODO 根据 key 获取存储的字符串类型的 value
        return stringOpsForValue.getAndSet(key, value);
    }

    /**
     * @title: TODO 根据 key 自增 value 值 delta == value += delta
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年8月25日 上午9:45:35
     * @param key
     * @param delta
     * @return
     */
    public Long increment(String key, long delta) {
        return stringOpsForValue.increment(key, delta);
    }

    /**
     * 根据 keys 获取存储的字符串类型的 values
     *
     * @param keys
     * @return
     */
    public List<String> multiGet(List<String> keys) {
        // TODO 根据 keys 获取存储的字符串类型的 values
        return stringOpsForValue.multiGet(keys);
    }

    /**
     * 倒序设置1个或多个字符串到key中
     *
     * @param key
     * @param values
     * @return
     */
    public Long leftPush(String key, String... values) {
        // TODO 倒序设置1个或多个字符串到key中
        return stringOpsForList.leftPushAll(key, values);
    }

    /**
     * 顺序设置1个或多个字符串到key中
     *
     * @param key
     * @param values
     * @return
     */
    public Long rightPush(String key, String... values) {
        // TODO 顺序设置1个或多个字符串到key中
        return stringOpsForList.rightPushAll(key, values);
    }

    /**
     * 倒序设置list字符串到key中
     *
     * @param key
     * @param values
     * @return
     */
    public Long leftPush(String key, List<String> values) {
        // TODO 倒序设置list字符串到key中
        return stringOpsForList.leftPushAll(key, values);
    }

    /**
     * 顺序设置list字符串到key中
     *
     * @param key
     * @param values
     * @return
     */
    public Long rightPush(String key, List<String> values) {
        // TODO 顺序设置list字符串到key中
        return stringOpsForList.rightPushAll(key, values);
    }

    /**
     * 获取列表元素，从开始下标到结束下标，（0，-1表示全部）
     *
     * @param key
     * @param start_index：开始下标，从0开始
     * @param end_index
     * @return
     */
    public List<String> range(String key, Long start_index, Long end_index) {
        // TODO 获取列表元素，从开始下标到结束下标，（0，-1表示全部）
        return stringOpsForList.range(key, start_index, end_index);
    }

    /**
     * 获取并移除第一个元素
     *
     * @param key
     * @return
     */
    public String leftPop(String key) {
        // TODO 获取并移除第一个元素
        return stringOpsForList.leftPop(key);
    }

    /**
     * 获取并移除最后一个元素
     *
     * @param key
     * @return
     */
    public String rightPop(String key) {
        // TODO 获取并移除最后一个元素
        return stringOpsForList.rightPop(key);
    }

    /**
     * 获取指定下标元素
     *
     * @param key
     * @return
     */
    public String index(String key, Long index) {
        // TODO 获取指定下标元素
        return stringOpsForList.index(key, index);
    }

    /**
     * 获取key 的size
     *
     * @param key
     * @return
     */
    public Long size(String key) {
        // TODO 获取key 的size
        return stringOpsForList.size(key);
    }

    /**
     * 移除num个列表元素value,并返回移除个数
     *
     * @param key
     * @param num：0全部
     * @param value
     * @return
     */
    public Long remove(String key, Long num, String value) {
        // TODO 移除num个列表元素value
        return stringOpsForList.remove(key, num, value);
    }

    /**
     * 截取key的第start_index到end_index元素再次赋给key
     *
     * @param key
     * @param start_index
     * @param end_index
     * @return
     */
    public void trim(String key, Long start_index, Long end_index) {
        // TODO 截取key的第start_index到end_index元素再次赋给key
        stringOpsForList.trim(key, start_index, end_index);
        ;
    }

    /**
     * 将ori_key的最后一个元素取出压栈dir_key
     *
     * @param ori_key
     * @param dir_key
     * @return
     */
    public String rightPopAndLeftPush(String ori_key, String dir_key) {
        // TODO 将ori_key的最后一个元素取出压栈dir_key
        return stringOpsForList.rightPopAndLeftPush(ori_key, dir_key);
    }

    /**
     * 在下标index出设置value
     *
     * @param key
     * @param index
     * @param value
     */
    public void setValueIndex(String key, Long index, String value) {
        // TODO 在下标index出设置value
        stringOpsForList.set(key, index, value);
    }

    /**
     * 设置hashmap对象
     *
     * @param key
     * @param map
     */
    public void putAll(String key, Map<String, String> map) {
        // TODO 设置hashmap对象
        stringOpsForHash.putAll(key, map);
    }

    /**
     * 通过key获取map对象
     *
     * @param key
     * @return
     */
    public Map<String, String> entries(String key) {
        // TODO 通过key获取map对象
        return stringOpsForHash.entries(key);
    }

    // -------------------------------------------------------------------------
    /**
     * @title: TODO 设置单个 key-obj 缓存, eg. key1:user1
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午4:29:41
     * @param key
     * @param value
     */
    public void setForObject(String key, Object value) {
        opsForValue.set(key, value);
    }

    /**
     * @title: TODO 设置多个 key-obj 缓存, eg. {key1:user1,key2:user2,key3:stu3}
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午4:30:38
     * @param keys_values
     */
    public void multiSetForObject(Map<String, Object> keys_values) {
        opsForValue.multiSet(keys_values);
    }

    /**
     * @title: TODO 设置单个 key-obj 缓存 + 过期时间(毫秒), eg. key1:user1
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午4:29:41
     * @param key
     * @param value
     */
    public void setForObject(String key, Object value, Long expir_time) {
        opsForValue.set(key, value, expir_time, TimeUnit.MILLISECONDS);
    }

    /**
     * @title: TODO 根据 key 获取指定对象T的 value
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午4:29:41
     * @param key
     * @param value
     */
    @SuppressWarnings("unchecked")
    public <T> T getForObject(String key, Class<T> type) {
        return (T) opsForValue.get(key);
    }

    /**
     * @title: TODO 根据 keys 获取 values
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午4:29:41
     * @param key
     * @param value
     */
    public List<Object> multiGetForObject(List<String> keys) {
        return opsForValue.multiGet(keys);
    }

    /**
     * @title: TODO 根据 keys 获取指定对象T的 values, 所有对象类型要一致
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午4:29:41
     * @param key
     * @param value
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> multiGetForObject(List<String> keys, Class<T> type) {
        List<T> list = (List<T>) opsForValue.multiGet(keys);
        return list;
    }

    /**
     * @title: TODO 将1个或多个 value 倒序压栈到 key 中
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:05:24
     * @param key
     * @param values
     * @return
     */
    public Long leftPushForObject(String key, Object... values) {
        return opsForList.leftPushAll(key, values);
    }

    /**
     * @title: TODO 将1个或多个 value 倒序压栈到 key 中
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:05:24
     * @param key
     * @param values
     * @return
     */
    public Long leftPushForObject(String key, List<?> values) {
        return opsForList.leftPushAll(key, values.toArray());
    }

    /**
     * @title: TODO 将1个或多个 value 顺序压栈到 key 中
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:05:24
     * @param key
     * @param values
     * @return
     */
    public Long rightPushForObject(String key, Object... values) {
        return opsForList.rightPushAll(key, values);
    }

    /**
     * @title: TODO 将1个或多个 value 顺序压栈到 key 中
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:05:24
     * @param key
     * @param values
     * @return
     */
    public Long rightPushForObject(String key, List<?> values) {
        if (CollectionUtils.isEmpty(values)) {
            return null;
        }
        return opsForList.rightPushAll(key, values.toArray());
    }

    /**
     * @title: TODO 获取指定类型的全部列表元素
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:12:59
     * @param key
     * @param type
     * @return
     */
    public <T> List<T> rangeForObject(String key, Class<T> type) {
        return rangeForObject(key, 0L, -1L, type);
    }

    /**
     * @title: TODO 获取指定类型的列表元素，从开始下标到结束下标，（0，-1表示全部）
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:12:59
     * @param key
     * @param start_index
     *            下标从0开始
     * @param end_index
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> rangeForObject(String key, Long start_index, Long end_index, Class<T> type) {
        List<T> range = (List<T>) opsForList.range(key, start_index, end_index);
        return range;
    }

    /**
     * @title: TODO 获取指定类型的第一个元素并移除
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:24:15
     * @param key
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T leftPopForObject(String key, Class<T> type) {
        return (T) opsForList.leftPop(key);
    }

    /**
     * @title: TODO 获取指定类型的最后一个元素并移除
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:24:15
     * @param key
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T rightPopForObject(String key, Class<T> type) {
        return (T) opsForList.rightPop(key);
    }

    /**
     * @title: TODO 获取指定类型的下标为 index 的元素
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:24:15
     * @param key
     * @param type
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T indexForObject(String key, Long index, Class<T> type) {
        return (T) opsForList.index(key, index);
    }

    /**
     * @title: TODO 获取指定 key 的 value 的个数
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:33:23
     * @param key
     * @return
     */
    public Long sizeForObject(String key) {
        return opsForList.size(key);
    }

    /**
     * @title: TODO 移除num个列表元素value,并返回移除个数
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:39:14
     * @param key
     * @param num
     * @param value
     * @return
     */
    public Long removeForObject(String key, Long num, Object value) {
        return opsForList.remove(key, num, value);
    }

    /**
     * @title: TODO 截取 key 的第 start_index 到 end_index 元素再次赋给key
     * @description:
     * @author: create by weiyanhao
     * @date: 2017年6月14日 下午5:56:37
     * @param key
     * @param start_index
     * @param end_index
     */
    public void trimForObject(String key, Long start_index, Long end_index) {
        opsForList.trim(key, start_index, end_index);
    }

    @SuppressWarnings("unchecked")
    public <T> T rightPopAndLeftPushForObject(String ori_key, String dir_key, Class<T> type) {
        return (T) opsForList.rightPopAndLeftPush(ori_key, dir_key);
    }

    public void setValueIndexForObject(String key, Long index, Object value) {
        opsForList.set(key, index, value);
    }

    /**
     * 设置hashmap对象
     *
     * @param key
     * @param map
     */
    public void putAllForObject(String key, Map<String, Object> map) {
        // TODO 设置hashmap对象
        opsForHash.putAll(key, map);
    }

    /**
     * 通过key获取map对象
     *
     * @param key
     * @return
     */
    public Map<String, Object> entriesForObject(String key) {
        // TODO 通过key获取map对象
        return opsForHash.entries(key);
    }

}
