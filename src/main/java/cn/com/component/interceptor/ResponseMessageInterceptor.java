package cn.com.component.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ResponseMessageInterceptor implements HandlerInterceptor {
	
	
	/**
	 * 日志
	 */
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("i'am coming");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj, ModelAndView modelandview) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj, Exception exception) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
