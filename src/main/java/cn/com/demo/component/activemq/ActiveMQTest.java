package cn.com.demo.component.activemq;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActiveMQTest implements MessageListener {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onMessage(Message arg0) {
		logger.debug("onMessage：" + arg0.toString());
	}
	
}
