package com.ge.ttcpredixtraining.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;

@Component
public class UserActionsDao {

	@Value("${redis.host}")
	private String redisHost;

	@Value("${redis.port}")
	private int redisPort;

	@Value("${redis.password}")
	private String redisPassword;

	private static final String USER_ACTIONS = "USER_ACTIONS";

	public List<String> getUserActions() {
		Jedis jedis = getJedisInstance();
		List<String> lrange = jedis.lrange(USER_ACTIONS, 0, 10);
		return lrange;
	}

	public void saveUserAction(String action) {
		Jedis jedis = getJedisInstance();
		jedis.lpush(USER_ACTIONS, action + " "
				+ (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")).format(Calendar.getInstance().getTime()));
	}

	private Jedis getJedisInstance() {
		Jedis jedis = new Jedis(redisHost, redisPort);
		jedis.auth(redisPassword);
		return jedis;
	}

	public void deleteUserActions() {
		Jedis jedis = getJedisInstance();
		jedis.del(USER_ACTIONS);
		
	}

}
