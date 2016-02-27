package com.ai.amc.core.dao.zabbixapi;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ai.amc.utils.ZabbixApiBase;
import com.alibaba.fastjson.JSONArray;

@Repository
public class HistoryZabbixApi extends ZabbixApiBase {
	private static final Logger logger = LogManager
			.getLogger(HistoryZabbixApi.class.getName());
	public JSONArray getHistoyByItemID(String itemid,String value_type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("output", "extend");
		params.put("itemids", itemid);
		params.put("history", value_type);
		params.put("time_till", Math.round(System.currentTimeMillis()/1000));
		params.put("time_from", Math.round(System.currentTimeMillis()/1000)-3600);
		Map<String, Object> map = super.getConditions();
		map.put("method", "history.get");
		map.put("params", params);
		JSONArray json = null;
		try {
			json = super.getJSONArray(map);
			logger.info("History 的  ZabbixApi getHistoyByItemID 返回成功");
		} catch (Exception e) {
			logger.info("History 的  ZabbixApi getHistoyByItemID返回失败"+e);
			System.out.println("History  返回失败");
		}
		return json;

	}
}
