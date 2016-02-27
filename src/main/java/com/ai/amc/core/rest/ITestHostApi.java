package com.ai.amc.core.rest;

import java.util.List;

import com.ai.amc.core.vo.HostVo;
import com.alibaba.fastjson.JSONArray;

public interface ITestHostApi {

	List<HostVo> getHostListByAuth();
	List<HostVo> getHostListByGroupID(String groupid);
}
