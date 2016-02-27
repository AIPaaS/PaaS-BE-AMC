package com.ai.amc.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ai.amc.core.constants.BaseinfoConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class ZabbixApiBase {
	
	private static final Logger logger = LogManager
			.getLogger(ZabbixApiBase.class.getName());
	
	public String Auth = BaseinfoConstants.AUTH;
	
	public JSONArray getJSONArray(Map<String, Object> map) throws Exception {
		String param = JSON.toJSONString(map);
		JSONArray json = null;
		
			String response = ZabbixApiUtil.sendPost(param);
			json = JSON.parseObject(response).getJSONArray("result");
	
		return json;
	}
	
	public Map<String, Object> getConditions() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("output", "extend");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jsonrpc", "2.0");
		map.put("params", params);
		map.put("auth", Auth);
		map.put("id", 0);
		return map;
	}
}
