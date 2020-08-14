package cn.test;

import cn.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    @Test
    public void test1() {
        // 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 操作
        jedis.set("username", "pig");
        String username = jedis.get("username");
        System.out.println("username = " + username);
        // 可以使用setex()方法存储可以指定过期时间的key-value
        // 20秒后自动删除
        jedis.setex("activecode", 20, "20-later-destroy");
        // 关闭连接
        jedis.close();
    }

    @Test
    public void test2() {
        // 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 操作
        jedis.hset("hash-test", "name", "name1");
        jedis.hset("hash-test", "age", "20");
        String name = jedis.hget("hash-test", "age");
        System.out.println(name);
        Map<String, String> map = jedis.hgetAll("hash-test");
        System.out.println(map);
        // 关闭连接
        jedis.close();
    }

    @Test
    public void test3() {
        // 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 操作
        jedis.lpush("list-test", "a", "b", "c");
        jedis.rpush("list-test", "a", "b", "c");
        // list-test [c, b, a, a, b, c]
        List<String> list = jedis.lrange("list-test", 0, -1);
        System.out.println(list);
        String lpop1 = jedis.lpop("list-test");
        System.out.println(lpop1); // c
        String rpop1 = jedis.rpop("list-test");
        System.out.println(rpop1); // c
        // 关闭连接
        jedis.close();
    }

    @Test
    public void test4() {
        // 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 操作
        jedis.sadd("set-test", "a", "b", "c");
        Set<String> set = jedis.smembers("set-test");
        System.out.println(set); // [a, b, c]
        // 关闭连接
        jedis.close();
    }

    @Test
    public void test5() {
        // 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // 操作
        jedis.zadd("sorted-test", 20, "a");
        jedis.zadd("sorted-test", 30, "b");
        jedis.zadd("sorted-test", 25, "c");
        Set<String> set = jedis.zrange("sorted-test", 0, -1);
        System.out.println(set); // [a, c, b]
        // 关闭连接
        jedis.close();
    }

    @Test
    public void test6() {
        // 创建JedisPool
        JedisPool jedisPool = new JedisPool();
        // 获取连接
        Jedis jedis = jedisPool.getResource();
        // 使用jedis...
        // 关闭jedis，恢复到连接池中
        jedis.close();
    }

    @Test
    public void test7() {
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.close();
    }
}
