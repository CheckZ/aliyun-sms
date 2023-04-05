package com.checkzh;

import com.checkzh.config.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @ClassName RedisTst
 * @Description TODO
 * @Author Check_Z
 * @Date 2023/3/20 11:45
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void redisTest() {
        System.out.println(redisUtil.get(null));
        System.out.println(redisUtil.get(""));
        System.out.println(redisUtil.get("*"));
        String key1 = "test2";
        String value1 = "redis2";
        redisUtil.set(key1, value1);
        String redisValue1 = redisUtil.get(key1).toString();
        System.out.println("缓存中的key为：" + key1 + "," + "值为：" + redisValue1);
    }

}
