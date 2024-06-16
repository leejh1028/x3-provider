package org.nyzz.x3;

import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class X3ProviderApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void contextLoads() {

//        redisTemplate.opsForValue().set("你好", "sadasdasdsd");

//        redisTemplate.opsForHash().put("hash22", "you", "123123123");
//        redisTemplate.opsForHash().put("hash22", "name", "张三");
//        Object object = redisTemplate.opsForHash().get("hash22", "name");
//        System.out.println("object = " + JSONUtil.toJsonStr(object));
        Long add = redisTemplate.opsForSet().add("set22", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        System.out.println("add = " + add);

    }

}
