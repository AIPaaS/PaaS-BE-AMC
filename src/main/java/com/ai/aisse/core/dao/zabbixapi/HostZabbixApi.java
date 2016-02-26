package com.ai.aisse.core.dao.zabbixapi;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ai.aisse.core.constants.BaseinfoConstants;
import com.ai.aisse.utils.ZabbixApiUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
@Repository
public class HostZabbixApi {

	private static final Logger logger = LogManager
			.getLogger(HostZabbixApi.class.getName());
	
	private String Auth = BaseinfoConstants.AUTH;
	/*
	 * 获取用户下所有主机
	 */
	public JSONArray getHostListByAuth() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("output", "extend");
		params.put("selectInterfaces", "extend");
		params.put("selectGroups", "extend");
		params.put("selectItems", "count");
		params.put("selectTriggers", "count");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jsonrpc", "2.0");
		map.put("method", "host.get");
		map.put("params", params);
		map.put("auth", Auth);
		map.put("id", 0);
		String param = JSON.toJSONString(map);
		JSONArray json = null;

		try {
			String response = ZabbixApiUtil.sendPost(param);
			json = JSON.parseObject(response).getJSONArray("result");
			logger.info("Host 的  ZabbixApi getHostByAuth 返回成功");
			System.out.println("Host 的  ZabbixApi getHostByAuth 返回成功");
		} catch (Exception e) {
			logger.info("Host 的  ZabbixApi getHostByAuth返回失败"+e);
			System.out.println("Host 的  ZabbixApi getHostByAuth 返回失败");
		}
		return json;

	}
	/*
	 * 
	 */
	public JSONArray getHostListByGroupID(String groupid) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("output", "extend");
		params.put("selectInterfaces", "extend");
		params.put("selectGroups", "extend");
		params.put("selectItems", "count");
		params.put("selectTriggers", "count");
		if(!groupid.equals("all")){
			params.put("groupids", groupid);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jsonrpc", "2.0");
		map.put("method", "host.get");
		map.put("params", params);
		map.put("auth", Auth);
		map.put("id", 0);
		String param = JSON.toJSONString(map);
		JSONArray json = null;

		try {
			String response = ZabbixApiUtil.sendPost(param);
			json = JSON.parseObject(response).getJSONArray("result");
			logger.info("Host 的  ZabbixApi getHostListByGroupID 返回成功");
			System.out.println("Host 的  ZabbixApi getHostListByGroupID 返回成功");
		} catch (Exception e) {
			logger.info("Host 的  ZabbixApi getHostListByGroupID返回失败"+e);
			System.out.println("Host 的  ZabbixApi getHostListByGroupID 返回失败");
		}
		return json;

	}
	
}
