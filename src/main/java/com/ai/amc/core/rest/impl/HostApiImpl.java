package com.ai.amc.core.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.amc.core.dao.zabbixapi.HostZabbixApi;
import com.ai.amc.core.rest.IHostApi;
import com.ai.amc.core.service.IHostSv;
import com.ai.amc.core.vo.HostVo;
import com.ai.amc.core.vo.InterfaceVo;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
@Service
public class HostApiImpl implements IHostApi {

	@Autowired
	private IHostSv iHostSv;
	@Override
	public List<HostVo> getHostListByAuth() {
		
		return iHostSv.getHostListByAuth();
	}
	@Override
	public List<HostVo> getHostListByGroupID(String groupid) {
	
		return iHostSv.getHostListByGroupID(groupid);
	}
	@Override
	public JSONArray getHostAll() {
		
		return iHostSv.getHostAll();
	}

}
