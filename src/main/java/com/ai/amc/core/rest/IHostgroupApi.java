package com.ai.amc.core.rest;

import java.util.List;

import com.ai.amc.core.po.Hostgrouptype;
import com.ai.amc.core.vo.HostgroupVo;
import com.ai.amc.core.vo.UserVo;

public interface IHostgroupApi {
	
	
	
       List<HostgroupVo> getgroupByAuth( ) throws Exception;
       Hostgrouptype gettyprBygroupID(int groupid);
       List<HostgroupVo> getgroupByType();
       
}
