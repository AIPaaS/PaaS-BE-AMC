package com.ai.amc.core.dao.zabbixapi;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.CountByExampleElementGenerator;
import org.springframework.stereotype.Repository;

import com.ai.amc.core.constants.BaseinfoConstants;
import com.ai.amc.core.vo.InterfaceVo;
import com.ai.amc.utils.ZabbixApiBase;
import com.ai.amc.utils.ZabbixApiUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.xmlrpc.base.Array;
@Repository
public class ItemZabbixApi extends ZabbixApiBase{

	private static final Logger logger = LogManager
			.getLogger(ItemZabbixApi.class.getName());
	
	
	/*
	 * 获取指定主机下的指标项
	 */
	public JSONArray getItemListByHostID(String hostid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("output", "extend");
		params.put("hostids", hostid);
		params.put("selectApplications", "extend");
		Map<String, Object> map = super.getConditions();
		map.put("method", "item.get");
		map.put("params", params);
		JSONArray json = null;

		try {
			json = super.getJSONArray(map);
			logger.info("Item 的  ZabbixApi getItemListByHostID 返回成功");
		} catch (Exception e) {
			logger.info("Item 的  ZabbixApi getItemListByHostID返回失败"+e);
			System.out.println("Host 的  ZabbixApi getItemListByHostID 返回失败");
		}
		return json;

	}
	/*
	 * 获取模糊姓名匹配的所有item
	 */
	public JSONArray getItemListByName(String name) {
		Map<String, Object> search = new HashMap<String, Object>();
		search.put("name", name);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("output", "extend");
		params.put("search", search);
		params.put("selectApplications", "extend");
		Map<String, Object> map = super.getConditions();
		map.put("method", "item.get");
		map.put("params", params);
		JSONArray json = null;

		try {
			json = super.getJSONArray(map);
			logger.info("Item 的  ZabbixApi getItemListByHostID 返回成功");
		} catch (Exception e) {
			logger.info("Item 的  ZabbixApi getItemListByHostID返回失败"+e);
			System.out.println("Host 的  ZabbixApi getItemListByHostID 返回失败");
		}
		return json;

	}
	
}
