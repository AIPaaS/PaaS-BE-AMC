package com.ai.amc.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.amc.core.dao.zabbixapi.HostZabbixApi;
import com.ai.amc.core.service.IHostSv;
import com.ai.amc.core.vo.HostVo;
import com.ai.amc.core.vo.HostgroupVo;
import com.ai.amc.core.vo.InterfaceVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Repository
@Transactional
public class HostSvImpl implements IHostSv {

	@Autowired
	private HostZabbixApi hostZabbixApi;
	@Override
	public List<HostVo> getHostListByAuth() {		
		
		JSONArray  hostresult = hostZabbixApi.getHostListByAuth();
		List<HostVo> host  = JSON.parseArray(hostresult.toString(), HostVo.class);
		
		return host;
	}
	@Override
	public List<HostVo> getHostListByGroupID(String groupid) {
		
		JSONArray  hostresult = hostZabbixApi.getHostListByGroupID(groupid);
		List<HostVo> host  = JSON.parseArray(hostresult.toString(), HostVo.class);
		
		return host;
	}
	@Override
	public JSONArray getHostAll() {		
		
		JSONArray  hostresult = hostZabbixApi.getHostListByAuth();
		
		return hostresult;
	}

}
