package com.ai.amc.test.springcontext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {
	public static ClassPathXmlApplicationContext getContext() {		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( new String[] {"classpath*:spring/applicationContext-consumer.xml"});
		context. start();		
		return context;
	}

}
