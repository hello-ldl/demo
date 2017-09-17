package org.springframework.redis.connection.jedis;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.JedisPoolConfig;

public class RedisConnectionFactory implements InitializingBean, DisposableBean, org.springframework.data.redis.connection.RedisConnectionFactory {
	
	/**
	 * redis连接工厂
	 */
	private JedisConnectionFactory factory = null;
	
	/**
	 * 哨兵
	 * 
	 * @param sentinelConfig
	 * @param sentinelNodes
	 */
	public RedisConnectionFactory(RedisSentinelConfiguration sentinelConfig, JedisPoolConfig poolConfig) {
		org.springframework.data.redis.connection.RedisSentinelConfiguration jedisConnectionFactory = new org.springframework.data.redis.connection.RedisSentinelConfiguration(sentinelConfig.getMasters().get(0), sentinelConfig.getNodes());
		this.factory = new JedisConnectionFactory(jedisConnectionFactory, poolConfig);
		if (this.factory != null) {
			this.factory.setPassword(sentinelConfig.getPassword());
		}
	}
	
	public RedisConnectionFactory(RedisClusterConfiguration clusterConfig, JedisPoolConfig poolConfig) {
		this.factory = new JedisConnectionFactory(clusterConfig, poolConfig);
		if (this.factory != null) {
		}
	}
	
	public RedisConnectionFactory(JedisConnectionFactory factory, JedisPoolConfig poolConfig) {
		factory.setPoolConfig(poolConfig);
		this.factory = factory;
	}
	
	@Override
	public DataAccessException translateExceptionIfPossible(RuntimeException arg0) {
		return this.factory.translateExceptionIfPossible(arg0);
	}
	
	@Override
	public RedisClusterConnection getClusterConnection() {
		return this.factory.getClusterConnection();
	}
	
	@Override
	public RedisConnection getConnection() {
		return this.factory.getConnection();
	}
	
	@Override
	public boolean getConvertPipelineAndTxResults() {
		return this.factory.getConvertPipelineAndTxResults();
	}
	
	@Override
	public RedisSentinelConnection getSentinelConnection() {
		return this.factory.getSentinelConnection();
	}
	
	@Override
	public void destroy() throws Exception {
		this.factory.destroy();
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.factory.afterPropertiesSet();
		
	}
	
}
