package org.springframework.redis.connection.jedis;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RedisSentinelConfiguration {
	
	/**
	 * masters
	 */
	private List<String> masters = null;
	
	/**
	 * nodes
	 */
	private Set<String> nodes = new LinkedHashSet<String>();
	/**
	 * redis password
	 */
	private String password;
	
	public List<String> getMasters() {
		return masters;
	}
	
	public Set<String> getNodes() {
		return nodes;
	}
	
	public String getPassword() {
		return password;
	}
	
	public RedisSentinelConfiguration(String masters, String sentinelNodes, String password) {
		this.masters = Arrays.asList(masters.trim().split(","));
		String[] arr = sentinelNodes.trim().split(",");
		for (String node : arr) {
			this.nodes.add(node);
		}
	}
}
