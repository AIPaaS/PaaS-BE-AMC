package com.ai.amc.core.rest.impl;









import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.amc.core.constants.BaseinfoConstants;
import com.ai.amc.core.dao.zabbixapi.HostgroupZabbixApi;
import com.ai.amc.core.rest.IHostgroupApi;
import com.ai.amc.core.service.IHostgroupSv;
import com.ai.amc.core.vo.HostgroupVo;
import com.ai.amc.core.vo.UserVo;
import com.ai.amc.utils.ZabbixApiUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
public class HostgroupApiImpl implements IHostgroupApi {

	@Autowired
	private IHostgroupSv iHostgroupSv;
	@Override
	public List<HostgroupVo> getgroupByAuth() throws Exception {
		
        
        return iHostgroupSv.getgroupByAuth();
	}
	@Override
	public List<HostgroupVo> getgroupByType() {
		System.out.println("---------------HostgroupApiImpl啦啦啦啦啦");
		return iHostgroupSv.getgroupByType();
	}

}
