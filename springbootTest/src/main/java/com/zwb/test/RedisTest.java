package com.zwb.test;

import com.zwb.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    /**
     * RedisTemplate 与 StringRedisTemplate 的区别：
     *
     * 1.两者的数据是不共通的；也就是说StringRedisTemplate只能管理StringRedisTemplate里面的数据，
     * RedisTemplate只能管理RedisTemplate中的数据。
     * 2.序列化的方式不一样：RedisTemplate使用的是JdkSerializationRedisSerializer，StringRedisTemplate使用的是StringRedisSerializer
     * 3.使用场景不一样：StringRedisTemplate适合于取字符串,而redisTemplate适合取出对象
     */

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private ValueOperations<String,Object> valueOperations;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;


    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("11ccv1", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
        User user = new User("fdgvfdv234", "小明", "男", 19, "湖北天门");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("zwb", user);
        Map map = new HashMap();
        map.put("map", null);
        operations.set("zwb1", user, 1, TimeUnit.SECONDS);


        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }

    /**
     * 判断是否存在 key
     */
    public boolean existsKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除 key
     */
    public boolean deleteKey(String key){
        return redisTemplate.delete(key);
    }

    /**
     * 批量删除key
     */
    public Long batchDeleteKey(String ... key){
        Set<String> kSet = Stream.of(key).map(k -> k).collect(Collectors.toSet());
        return redisTemplate.delete(kSet);
    }

    /**
     * 添加map集合
     */
    @Test
    public void addMap(){
        Map map = new HashMap();
        map.put("z", 123);
        map.put("s", "qwqw");
        map.put("t", null);
        //redis 添加map集合
        hashOperations.putAll("test11123", map);
        //redis 查询map集合
        Map<String, Object> resultMap= hashOperations.entries("test11123");
        System.out.println(resultMap);
    }

}
