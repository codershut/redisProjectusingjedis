package com.redisproject.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Jedis;

@Configuration
public class ConfigurationFile {

	@Value("${rapiRedis.host}")
	private String hostRapi;
	
	@Value("${rapiRedis.port}")
	private int portRapi;
	
	@Value("${rapiRedis.pass}")
	private String passRapi;

	@Bean(name="rapiRedis")
	public Jedis getJedisBean() {
		Jedis jedis = new Jedis(hostRapi, portRapi);
		jedis.auth(passRapi);
		return jedis;
	}
	
	@Bean(name = "localRedis")
	public Jedis getJedisBean2() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		return jedis;
	}
}
