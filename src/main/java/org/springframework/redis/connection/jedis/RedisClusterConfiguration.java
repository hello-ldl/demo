package org.springframework.redis.connection.jedis;

import org.springframework.data.redis.connection.RedisNode;

public class RedisClusterConfiguration {
	
	public RedisClusterConfiguration(String nodes, int maxRedirects, String password) {
		String[] clusterNodes = nodes.trim().split(",");
		String[] arr;
		for (String node : clusterNodes) {
			arr = node.split(":");
		}
	}
	
	/**
	 * password
	 */
	private String password;
	
	public String getPassword() {
		return password;
	}
	
}
