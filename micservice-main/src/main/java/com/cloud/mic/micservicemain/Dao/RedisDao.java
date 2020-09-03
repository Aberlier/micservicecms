package com.cloud.mic.micservicemain.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @program: micservicecms
 * @description: Redis数据处理类
 * @author: zjc
 * @create: 2020-09-03 22:08
 **/
@Repository
public class RedisDao {
    @Autowired
    private StringRedisTemplate template;
    //往Redis中设置值
    public void setKey(String key,String value){
        ValueOperations<String,String> ops = template.opsForValue();
        //设置1分钟过期
        ops.set(key,value,1, TimeUnit.MINUTES);
    }
    //从Redis中取值
    public String getValue(String key){
        ValueOperations<String,String> ops = this.template.opsForValue();
        return ops.get(key);
    }
}
