package com.ai.aisse.core.service;

import java.util.List;

import com.ai.aisse.core.vo.HostVo;
import com.alibaba.fastjson.JSONArray;

public interface ITestHostSv {
     
	List<HostVo> getHostListByAuth();
	List<HostVo> getHostListByGroupID(String groupid);
}
