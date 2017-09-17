package cn.com.demo.controller;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import cn.com.demo.dao.UserInfoMapper;
import cn.com.demo.model.UserInfo;

@Controller
@RequestMapping("demoConreoller")
public class DemoController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public String str = "str";
	
	@Resource
	private UserInfoMapper userInfoMapper;
	
	@RequestMapping("demoMethod")
	@ResponseBody
	public Object demoMethod() {
		UserInfo userInfo = userInfoMapper.selectByPrimaryKey("99hbEhO4DjNpcnwQC3hX");
		return userInfo;
	}
	
	@RequestMapping("amqTest")
	@ResponseBody
	public Object activeMqTestSendMsg() {
		logger.debug("----------start send message-----------");
		BeanFactory b = ContextLoader.getCurrentWebApplicationContext().getAutowireCapableBeanFactory();
		Destination destination = (Destination) b.getBean("queueDestination");
		JmsTemplate jmsTemplate = (JmsTemplate) b.getBean("jmsQueueTemplate");
		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("Hello World");
			}
		});
		logger.debug("----------send message end-----------");
		return true;
		
	}
}
