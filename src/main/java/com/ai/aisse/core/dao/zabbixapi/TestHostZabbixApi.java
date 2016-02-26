package com.ai.aisse.core.dao.zabbixapi;

import java.util.HashMap;
import java.util.Map;

import oracle.net.ano.SupervisorService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ai.aisse.core.constants.BaseinfoConstants;
import com.ai.aisse.utils.ZabbixApiBase;
import com.ai.aisse.utils.ZabbixApiUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
@Repository
public class TestHostZabbixApi extends ZabbixApiBase{

	private static final Logger logger = LogManager
			.getLogger(TestHostZabbixApi.class.getName());
	
	/*
	 * 获取用户下所有主机
	 */
	public JSONArray getHostListByAuth() {
		Map<String, Object> map = super.getConditions();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("output", "extend");
		params.put("selectInterfaces", "extend");
		params.put("selectGroups", "extend");
		params.put("selectItems", "count");
		params.put("selectTriggers", "count");
		map.put("method", "host.get");
		map.put("params", params);
		JSONArray json = super.getJSONArray(map);
		return json;

	}
	/*
	 * 
	 */
	public JSONArray getHostListByGroupID(String groupid) {
		
		Map<String, Object> map = super.getConditions();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("output", "extend");
		params.put("selectInterfaces", "extend");
		params.put("selectGroups", "extend");
		params.put("selectItems", "count");
		params.put("selectTriggers", "count");
		if(!groupid.equals("all")){
			params.put("groupids", groupid);
		}
		map.put("method", "host.get");
		map.put("params", params);
		JSONArray json = super.getJSONArray(map);
		return json;

	}
	
}
