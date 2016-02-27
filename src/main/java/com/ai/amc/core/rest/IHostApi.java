package com.ai.amc.core.rest;

import java.util.List;

import com.ai.amc.core.vo.HostVo;
import com.alibaba.fastjson.JSONArray;

public interface IHostApi {

	List<HostVo> getHostListByAuth();
	List<HostVo> getHostListByGroupID(String groupid);
	JSONArray getHostAll();
}
