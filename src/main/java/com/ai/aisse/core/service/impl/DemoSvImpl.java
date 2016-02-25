package com.ai.aisse.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aisse.core.dao.mapper.IDemoTableDao;
import com.ai.aisse.core.dao.mapper.SysuserMapper;
import com.ai.aisse.core.po.DemoTable;
import com.ai.aisse.core.service.IDemoSv;



@Repository
@Transactional
public class DemoSvImpl implements IDemoSv{
	
	@Autowired
	private  SysuserMapper demoTableDao;

	

	@Override
	public int insertdemo(DemoTable param) {
		System.out.println("-------111111111111---------------111111111111-");
		return 0;
	}



	@Override
	public int selectone(int sid) {
		
		
		return 2;
	}
	

}
