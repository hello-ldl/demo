package org.springframework.redis.connection.jedis;

import redis.clients.jedis.JedisPoolConfig;

public class NewJedisPoolConfig extends JedisPoolConfig {
	
	public NewJedisPoolConfig(){
		setTestWhileIdle(true);
        setMinEvictableIdleTimeMillis(60000L);
        setTimeBetweenEvictionRunsMillis(30000L);
        setNumTestsPerEvictionRun(-1);
	}

}
