package cn.com.demo.frameworkl.util;

import org.springframework.beans.factory.BeanFactory;

public class ContextUtil {
	
	private static BeanFactory BEAN_FACRORY = null;
	
	public static void initialize(BeanFactory beanFactory) {
		BEAN_FACRORY = beanFactory;
	}
	
	public static BeanFactory getBeanFactory() {
		return BEAN_FACRORY;
	}
	
	/**
	 * 通过 Bean Name 获取bean
	 * 
	 * @Title : getBean
	 * @date : 2017年7月12日 下午4:11:57
	 * @param beanName
	 * @param t
	 * @return T -
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName, Class<T> t) {
		Object bean = BEAN_FACRORY.getBean("beanName");
		if (bean == null) {
			return null;
		}
		return (T) bean;
	}
	
	/**
	 * 通过类型获取bean
	 * 
	 * @Title : getBean
	 * @date : 2017年7月12日 下午4:13:38
	 * @param T
	 * @return T -
	 */
	public static <T> T getBean(Class<T> t) {
		return BEAN_FACRORY.getBean(t);
	}

}
