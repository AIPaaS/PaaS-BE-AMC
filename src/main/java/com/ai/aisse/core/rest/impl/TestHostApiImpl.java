package com.ai.aisse.core.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.aisse.core.rest.ITestHostApi;
import com.ai.aisse.core.service.ITestHostSv;
import com.ai.aisse.core.vo.HostVo;
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
