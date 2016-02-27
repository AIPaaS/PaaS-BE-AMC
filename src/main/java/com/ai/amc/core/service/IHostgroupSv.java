package com.ai.amc.core.service;

import java.util.List;

import com.ai.amc.core.po.Hostgrouptype;
import com.ai.amc.core.vo.HostgroupVo;

public interface IHostgroupSv {

	List<HostgroupVo> getgroupByAuth();
	 Hostgrouptype gettyprBygroupID(int groupid);
	List<HostgroupVo> getgroupByType();
	
}
