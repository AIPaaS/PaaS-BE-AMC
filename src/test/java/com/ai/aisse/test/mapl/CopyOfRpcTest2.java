package com.ai.aisse.test.mapl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ai.aisse.core.po.Hostgrouptype;
import com.ai.aisse.core.rest.IHistoryApi;
import com.ai.aisse.core.rest.IHostApi;
import com.ai.aisse.core.rest.IHostgroupApi;
import com.ai.aisse.core.rest.IItemApi;
import com.ai.aisse.core.rest.ITestHostApi;
import com.ai.aisse.core.rest.UserTokenApi;
import com.ai.aisse.core.vo.HistoryVo;
import com.ai.aisse.core.vo.HostVo;
import com.ai.aisse.core.vo.HostgroupVo;
import com.ai.aisse.core.vo.InterfaceVo;
import com.ai.aisse.core.vo.ItemVo;
import com.ai.aisse.core.vo.UserVo;
import com.ai.aisse.test.springcontext.SpringContext;
import com.alibaba.fastjson.JSONArray;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CopyOfRpcTest2 {
	
public static void main(String[] args) throws ParseException{
	System.out.println("");
	    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		demoTest();
		
	}

public static void demoTest(){
	System.out.println("");
	System.out.println("========================================");
	ClassPathXmlApplicationContext context = SpringContext.getContext();
	
	/*String [] names=context.getBeanDefinitionNames();
	System.out.print("Beans:");
	for (String string : names) {
		System.out.print(string);
		System.out.println(",");
	}*/
	
	//IItemApi object =(IItemApi) context.getBean("itemApiImpl");
	//IHistoryApi object =(IHistoryApi) context.getBean("historyApiImpl");
	//Object str = new ArrayList<HistoryVo>();
	 ITestHostApi object =(ITestHostApi) context.getBean("testHostApiImpl");
	 Object str = new ArrayList<HostVo>();
	  
	try {
		str =  object.getHostListByGroupID("17");
		//str =  object.getItemsByHostID("10274");
		System.out.println("-232323--我是结果："+str);
	} catch (Exception e) {
		 
		e.printStackTrace();
		System.out.println("丫的怎么没有出来呢 怎么报错了");
	}
	System.out.println(""); 
	System.out.println("----------我是结果："+str);
	//System.out.println("----------我是结果："+str.get(0).getItemid());
	System.out.println("----------我是结果："+Math.round(System.currentTimeMillis()/1000));
//	System.out.println("--------------------------"+str.get(0).getHostgroupid());
//	System.out.println("--------------------------"+str.get(0).getHostgroupname());
//	System.out.println("--------------------------"+str.get(1).getHostgroupid());
//	System.out.println("--------------------------"+str.get(1).getHostgroupname());
	
}

}
