package cn.com.dubbo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.dubbo.interfaces.DubboDemo;

public class DubboDemoImpl implements DubboDemo {
	
	Logger logger = LoggerFactory.getLogger(DubboDemoImpl.class);
	
	@Override
	public String testDubbo(String name) {
		logger.debug("Dubbo Success");
		return "success";
	}
	
}
