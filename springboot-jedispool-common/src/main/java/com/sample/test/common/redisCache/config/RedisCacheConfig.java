/**
 * FileName: RedisConfig
 * Author:   huang.yj
 * Date:     2019/11/25 19:07
 * Description: redis配置类
 */
package com.sample.test.common.redisCache.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 〈redis配置类〉
 *
 * @author huang.yj
 * @create 2019/11/25
 * @since 0.0.1
 */
@Configuration
@Slf4j
public class RedisCacheConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisPool redisPool()  throws Exception{
        log.info("JedisPool注入成功！！");
        log.info("redis地址：" + redisProperties.getHost() + ":" + redisProperties.getPort());
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        // 连接池最大连接数
        jedisPoolConfig.setMaxTotal(redisProperties.getMaxActive());
        // 同一时间能够最大保持空闲状态的连接数
        jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
        // 最小空闲(idel)状态的连接数
        jedisPoolConfig.setMinIdle(redisProperties.getMinIdle());
        // 表示当borrow一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getMaxWait());

        /***************其他额外的配置，看情况选择配置，一般配置以上的即可正常使用了*************/
        /*
        // 在borrow一个jedis实例时，是否提前进行alidate操作；如果为true，则得到的jedis实例均是可用的；
        jedisPoolConfig.setTestOnBorrow(true);

        // 如果为true，表示有一个idle object evitor线程对idle object进行扫描，如果validate失败，此object会被从pool中drop掉；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义；
        jedisPoolConfig.setTestWhileIdle(true);

        // 表示idle object evitor两次扫描之间要sleep的毫秒数
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(30000);

        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);

        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);*/

        // 因为连接的redis服务器不需要密码，所以最后一个参数值为null。
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisProperties.getHost(), redisProperties.getPort(), redisProperties.getTimeout(), null);
        return jedisPool;
    }
}