package cn.com.demo.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DemoHTTPRequest implements Controller {
	
	private Logger logger = LoggerFactory.getLogger(DemoHTTPRequest.class);
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws Exception {
		System.out.println("Hello World");
		// ContextLoaderListener c = new ContextLoaderListener();
		// @SuppressWarnings("static-access")
		// BeanFactory b =
		// c.getCurrentWebApplicationContext().getAutowireCapableBeanFactory();
		// Object o = b.getBean("properties");
		// Class clazz = o.getClass();
		// Method method = clazz.getMethod("", clazz);
		// method.invoke(o, "");
		logger.info("logger info " + "Hello World");
		return null;
	}

}
