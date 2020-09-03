package com.cloud.mic.micservicemain.Controller;

import com.cloud.mic.micservicemain.Dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: micservicecms
 * @description: Redis测试类
 * @author: zjc
 * @create: 2020-09-03 22:21
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRedisApplicationTestController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
    }

    @Autowired
    RedisDao redisDao;

    @Test
    public void testRedis() {
        redisDao.setKey("name", "zhang");
        redisDao.setKey("age", "12");
        logger.info(redisDao.getValue("name"));
        logger.info(redisDao.getValue("age"));
    }
    /*
    也可以通过windows安装后在cmd命令行进行redis服务的开启或者关闭
C:\Users\Administrator>redis-server.exe --service-stop
[17016] 03 Sep 22:40:09.010 # Redis service successfully stopped.

C:\Users\Administrator>redis-server.exe --service-start
[4216] 03 Sep 22:40:20.356 # Redis service successfully started.

C:\Users\Administrator>redis-cli.exe -h 127.0.0.1 -p 6379
127.0.0.1:6379> set
(error) ERR wrong number of arguments for 'set' command
127.0.0.1:6379> set name zhangsan
OK
127.0.0.1:6379> get name
"zhangsan"
127.0.0.1:6379>
*/
}
