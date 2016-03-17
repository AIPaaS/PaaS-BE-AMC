package com.ai.amc.test.mapl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ai.amc.core.po.Trends;
import com.ai.amc.core.po.TrendsKey;
import com.ai.amc.core.po.Trends_uint;
import com.ai.amc.core.po.Trends_uintKey;
import com.ai.amc.core.rest.IHistoryApi;
import com.ai.amc.core.rest.IHostApi;
import com.ai.amc.core.rest.IHostgroupApi;
import com.ai.amc.core.rest.IItemApi;
import com.ai.amc.core.rest.ITestHostApi;
import com.ai.amc.core.rest.ITrendsApi;
import com.ai.amc.core.rest.ITrends_uintApi;
import com.ai.amc.core.rest.UserTokenApi;
import com.ai.amc.core.vo.HistoryVo;
import com.ai.amc.core.vo.HostVo;
import com.ai.amc.core.vo.HostgroupVo;
import com.ai.amc.core.vo.InterfaceVo;
import com.ai.amc.core.vo.ItemVo;
import com.ai.amc.core.vo.UserVo;
import com.ai.amc.test.springcontext.SpringContext;
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
	IHistoryApi object =(IHistoryApi) context.getBean("historyApiImpl");
	//Object str = new ArrayList<HistoryVo>();
	 //ITestHostApi object =(ITestHostApi) context.getBean("testHostApiImpl");
	// IHostApi object =(IHostApi) context.getBean("hostApiImpl");
	//IHostgroupApi object =(IHostgroupApi) context.getBean("hostgroupApiImpl");
	//ITrendsApi object =(ITrendsApi) context.getBean("trendsApiImpl");
	//ITrends_uintApi object =(ITrends_uintApi) context.getBean("trends_uintApiImpl");
	//List<Trends_uint> str = new ArrayList<Trends_uint>();
	//Trends_uintKey key = new Trends_uintKey();
	//TrendsKey key = new TrendsKey();
	List<HistoryVo> str = new ArrayList<HistoryVo>();
	//List<HistoryVo> str = new ArrayList<HistoryVo>();
	try {
		//str =  object.getItemsByName("adoring_hodgkin:Free memory");
		str = object.getItemsByItemID("30795", "0", 600);
		//str = object.getItemsByName("prickly_liskov:Used memory");
		//str = object.getItemsByItemID("30795", "0", 60);
		//str =  object.getItemsByHostID("10274");
		//System.out.println("-232323--我是结果："+str.get(0).getItemid()+"dd"+str.get(0).getClock()+"sss"+str.get(0).getValueAvg());
		//System.out.println("-232323--我是结果："+str.get(1).getItemid()+"dd"+str.get(1).getClock()+"sss"+str.get(1).getValueAvg());
		//System.out.println("-232323--我是结果："+str.get(0).getNewclock());
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
