package com.qwe;

import com.qwe.utils.JedisClient;
import com.qwe.utils.JedisClientPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Success1Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Success1Application.class, args);
    }

    @Value("${spring.redis.host}")
    String host;
    @Value("${spring.redis.port}")
    int port;

    @Bean
    public JedisClient getJedisClient(){
        JedisClientPool jedisClient = new JedisClientPool();
        JedisPool jedisPool = new JedisPool(host,port);
        jedisClient.setJedisPool(jedisPool);
        return jedisClient;

    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
