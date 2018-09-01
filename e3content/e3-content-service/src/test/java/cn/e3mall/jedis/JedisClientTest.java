package cn.e3mall.jedis;

import cn.e3mall.common.jedis.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 01/09/2018
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class JedisClientTest {

    @Test
    public void testJedisClient() {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");

        JedisClient jedisClient = context.getBean(JedisClient.class);

        jedisClient.set("mytest", "jedisClient");

        System.out.println(jedisClient.get("mytest"));



    }
}