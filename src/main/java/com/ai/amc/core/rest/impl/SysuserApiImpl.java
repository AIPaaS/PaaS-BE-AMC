package com.ai.amc.core.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.amc.core.po.Sysuser;
import com.ai.amc.core.rest.SysuserApi;
import com.ai.amc.core.service.ISysuserSv;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class SysuserApiImpl implements SysuserApi {

	@Autowired
	private ISysuserSv sysSv;
	
	@Override
	public Sysuser selectByPrimaryKey(Integer id) {
		Sysuser sysuser = new Sysuser();
		sysuser =sysSv.selectByPrimaryKey(id);
		
		return sysuser;
	}

}
