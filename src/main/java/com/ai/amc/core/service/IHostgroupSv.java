package com.ai.amc.core.service;

import java.util.List;

import com.ai.amc.core.vo.HostgroupVo;

public interface IHostgroupSv {

	List<HostgroupVo> getgroupByAuth();
	List<HostgroupVo> getgroupByType();
	
}
