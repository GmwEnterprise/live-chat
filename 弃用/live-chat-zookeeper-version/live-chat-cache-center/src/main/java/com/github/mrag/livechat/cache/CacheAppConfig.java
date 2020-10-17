package com.github.mrag.livechat.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URL;

/**
 * @author Gmw
 */
@Configuration
@MapperScan(basePackages = "com.github.mrag.livechat.cache.dao")
public class CacheAppConfig {

    @Bean
    public RedissonClient redissonClient() throws IOException {
        URL resource = getClass().getResource("/redisson.yaml");
        Config config = Config.fromYAML(resource);
        return Redisson.create(config);
    }
}
