package com.ai.amc.core.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.amc.core.rest.ITestHostApi;
import com.ai.amc.core.service.ITestHostSv;
import com.ai.amc.core.vo.HostVo;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
@Service
public class TestHostApiImpl implements ITestHostApi {

	@Autowired
	private ITestHostSv iTestHostSv;
	@Override
	public List<HostVo> getHostListByAuth() {
		
		return iTestHostSv.getHostListByAuth();
	}
	@Override
	public List<HostVo> getHostListByGroupID(String groupid) {
		return iTestHostSv.getHostListByGroupID(groupid);
	}

}
