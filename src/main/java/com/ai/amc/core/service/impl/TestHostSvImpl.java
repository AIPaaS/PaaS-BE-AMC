package com.ai.amc.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.amc.core.dao.zabbixapi.HostZabbixApi;
import com.ai.amc.core.dao.zabbixapi.TestHostZabbixApi;
import com.ai.amc.core.service.ITestHostSv;
import com.ai.amc.core.vo.HostVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
@Repository
@Transactional
public class TestHostSvImpl implements ITestHostSv {
	
	@Autowired
	private TestHostZabbixApi testHostZabbixApi;
	@Override
	public List<HostVo> getHostListByAuth() {
		JSONArray  hostresult = testHostZabbixApi.getHostListByAuth();
		List<HostVo> host  = JSON.parseArray(hostresult.toString(), HostVo.class);
		return host;

	}
	@Override
	public List<HostVo> getHostListByGroupID(String groupid) {
		JSONArray  hostresult = testHostZabbixApi.getHostListByGroupID(groupid);
		List<HostVo> host  = JSON.parseArray(hostresult.toString(), HostVo.class);
		return host;
	}

	

}
