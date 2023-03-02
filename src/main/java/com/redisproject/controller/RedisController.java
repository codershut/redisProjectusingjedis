package com.redisproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redisproject.model.RedisModel;

import redis.clients.jedis.Jedis;

@RestController
public class RedisController {
	
	@Autowired
	@Qualifier(value = "localRedis")
	Jedis jedis1;
	
	@Autowired
	@Qualifier(value = "rapiRedis")
	Jedis jedis2;
	
	@PostMapping("/api2/post")
	public void setRedisDataUsingJedis(@RequestBody RedisModel model) {
		try {
			jedis2.set("testtttttingRedis", "myvalue");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	@PostMapping("/api2/setDataWithExpiry")
	public void setDataWithExpiry(@RequestBody RedisModel model) {
		try {
			jedis2.set("testtttttingRedisexpire", "myvalue");
			jedis2.expire("testtttttingRedisexpire", 15);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
}
