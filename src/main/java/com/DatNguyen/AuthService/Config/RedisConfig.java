package com.DatNguyen.AuthService.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

@Configuration
public class RedisConfig {
    private String redisUrl = "http://127.0.0.1:6379";

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        try {
            URI redisUri = new URI(redisUrl);

            RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
            System.out.println("Connecting to Redis at " + redisUri);
            config.setHostName(redisUri.getHost());
            System.out.println("Host: " + redisUri.getHost());
            config.setPort(redisUri.getPort());
            System.out.println("Port: " + redisUri.getPort());

            // Extract password from URI userInfo
            if (redisUri.getUserInfo() != null) {
                config.setPassword(redisUri.getUserInfo().split(":", 2)[1]);
                System.out.println("Password: " + redisUri.getUserInfo().split(":", 2)[1]);
            }

            LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                    .commandTimeout(Duration.ofSeconds(5))
                    .shutdownTimeout(Duration.ofSeconds(5))
                    .build();

            LettuceConnectionFactory factory = new LettuceConnectionFactory(config, clientConfig);
            factory.setValidateConnection(true);
            factory.afterPropertiesSet();
            return factory;
        } catch (URISyntaxException e) {
            throw new RuntimeException("Redis URL is invalid", e);
        }
    }

    @Bean
    @Primary
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setEnableDefaultSerializer(false);
        template.afterPropertiesSet();
        return template;
    }
}