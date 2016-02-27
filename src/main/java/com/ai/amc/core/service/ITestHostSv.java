package com.ai.amc.core.service;

import java.util.List;

import com.ai.amc.core.vo.HostVo;
import com.alibaba.fastjson.JSONArray;

public interface ITestHostSv {
     
	List<HostVo> getHostListByAuth();
	List<HostVo> getHostListByGroupID(String groupid);
}
