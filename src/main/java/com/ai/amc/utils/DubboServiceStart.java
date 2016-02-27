package com.ai.amc.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  启动发布Dubbo 服务
 */
public class DubboServiceStart {
	private static final Logger log = LogManager
			.getLogger(DubboServiceStart.class.getName());

	@SuppressWarnings("resource")
	private static void startDubboService() {
		log.info("开始启动  Dubbo 服务---------------------------");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath*:spring/applicationContext.xml" });
		context.registerShutdownHook();
		context.start();
		log.info(" Dubbo 服务启动完毕---------------------------");
		while (true) {
			try {
				Thread.currentThread();
				Thread.sleep(3000L);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		startDubboService();
	}
}
