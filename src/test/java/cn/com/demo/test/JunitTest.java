package cn.com.demo.test;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import cn.com.demo.controller.DemoController;
import cn.com.demo.frameworkl.util.ContextUtil;

/**
 * Junit 测试类
 * 
 * @author 李东林 (ldl@yitong.com.cn)
 * @date : 2017年7月12日 下午4:09:09
 * @ClassName : JunitTest
 * @Description :
 * @version 1.0
 */
public class JunitTest {
	
	Logger logger = LoggerFactory.getLogger(JunitTest.class);
	
	private ApplicationContext context;
	
	/**
	 * 初始化
	 * 
	 * @Title : startTest
	 * @date : 2017年7月12日 下午4:09:30 void -
	 */
	@Before
	public void startTest() {
		logger.info("start");
		context = new ClassPathXmlApplicationContext("classpath:config/spring/spring-context.xml", "classpath:config/spring/spring-mvc.xml");
		ContextUtil.initialize(context.getAutowireCapableBeanFactory());
	}
	
	
	public void test() {
		logger.info("test");
		DemoController demo = ContextUtil.getBean(DemoController.class);
		logger.info(JSON.toJSONString(demo.demoMethod()));
	}
	
	@Test
	public void test2(){
		 String text = "http://www.baidu.com";  
         int width = 300;  
         int height = 300;  
         //二维码的图片格式  
         String format = "gif";  
         Hashtable hints = new Hashtable();  
         //内容所使用编码  
         hints.put(EncodeHintType.CHARACTER_SET, "utf-8");  
         BitMatrix bitMatrix = null;
		try {
			bitMatrix = new MultiFormatWriter().encode(text,  
			         BarcodeFormat.QR_CODE, width, height, hints);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         //生成二维码  
         File outputFile = new File("d:"+File.separator+"new.gif");  
         try {
			MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
