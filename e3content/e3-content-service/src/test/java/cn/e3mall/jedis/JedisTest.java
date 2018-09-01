package cn.e3mall.jedis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 01/09/2018
 * Time: 16:36
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class JedisTest {

    @Test
    public void testJedis() {
//        Jedis jedis = new Jedis("10.211.55.7", 7001);
        Jedis jedis = new Jedis("localhost", 6379);


        jedis.set("test123", "myfirst jedis test");


        String test123 = jedis.get("test123");

        System.out.println(test123);

        jedis.close();
    }


    @Test
    public void testJedisPool() {

        JedisPool jedisPool = new JedisPool("localhost", 6379);

        Jedis jedis = jedisPool.getResource();
        jedis.set("test456", "myfirst jedis test");


        String test123 = jedis.get("test123");

        System.out.println(test123);

        jedis.close();
        jedisPool.close();
    }


    @Test
    public void testJedisCluster() {
        Jedis jedis = new Jedis("localhost", 6379);

        Set <HostAndPort> nodes = new HashSet <>();

        nodes.add(new HostAndPort("10.211.55.7", 7001));
        nodes.add(new HostAndPort("10.211.55.7", 7002));
        nodes.add(new HostAndPort("10.211.55.7", 7003));
        nodes.add(new HostAndPort("10.211.55.7", 7004));
        nodes.add(new HostAndPort("10.211.55.7", 7005));
        nodes.add(new HostAndPort("10.211.55.7", 7006));


        JedisCluster jedisCluster = new JedisCluster(nodes);


        jedisCluster.set("cluster", "myfirst jedis test");


        String test123 = jedisCluster.get("cluster");

        System.out.println(test123);

        jedisCluster.close();
    }

}