package com.ai.amc.core.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.amc.core.po.DemoTable;
import com.ai.amc.core.rest.IDemoApi;
import com.ai.amc.core.service.IDemoSv;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class DemoApiImpl implements IDemoApi {	
	
	@Autowired
	private  IDemoSv demoSv;
	
	@Override
	public int insertDemo(DemoTable param) {
		
		demoSv.insertdemo(param);
		System.out.println("------sssssssssssssssssssss--------------11sssssssssssssssss");
		return 2;
	}

	@Override
	public DemoTable selectone(int sid) {
		DemoTable demoTable =new DemoTable();
		demoTable.setDname("ssss");
		return demoTable;
	}

	
}
