package cn.com.demo.frameworkl.listen;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import cn.com.demo.frameworkl.util.ContextUtil;

public class WebContextLoaderListener extends ContextLoaderListener {
	
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		WebApplicationContext context = super.initWebApplicationContext(servletContext);
		ContextUtil.initialize(context.getAutowireCapableBeanFactory());
		return context;
	}
}
