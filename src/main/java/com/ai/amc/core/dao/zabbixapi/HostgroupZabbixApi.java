package com.ai.amc.core.dao.zabbixapi;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


import com.ai.amc.utils.ZabbixApiBase;
import com.alibaba.fastjson.JSONArray;

@Repository
public class HostgroupZabbixApi extends ZabbixApiBase{

	private static final Logger logger = LogManager
			.getLogger(HostgroupZabbixApi.class.getName());

	public JSONArray getgroupByAuth()  {
		Map<String, Object> map = super.getConditions();
		map.put("method", "hostgroup.get");
		JSONArray json = null;
		try {
			json = super.getJSONArray(map);
			logger.info("Hostgroup 的  ZabbixApi 返回成功");
		} catch (Exception e) {
			logger.info("Hostgroup 的  ZabbixApi 返回失败");
			System.out.println("Hostgroup 的  ZabbixApi 返回失败");
		}
		return json;
	}
}
