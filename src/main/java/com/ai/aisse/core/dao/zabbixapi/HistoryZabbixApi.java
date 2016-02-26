package com.ai.aisse.core.dao.zabbixapi;

import java.sql.Timestamp;
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
public class HistoryZabbixApi {
	private static final Logger logger = LogManager
			.getLogger(HistoryZabbixApi.class.getName());
	private String Auth = BaseinfoConstants.AUTH;
	public JSONArray getHistoyByItemID(String itemid,String value_type) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("output", "extend");
		params.put("itemids", itemid);
		params.put("history", value_type);
		params.put("time_till", Math.round(System.currentTimeMillis()/1000));
		params.put("time_from", Math.round(System.currentTimeMillis()/1000)-3600);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jsonrpc", "2.0");
		map.put("method", "history.get");
		map.put("params", params);
		map.put("auth", Auth);
		map.put("id", 0);
		String param = JSON.toJSONString(map);
		JSONArray json = null;

		try {
			String response = ZabbixApiUtil.sendPost(param);
			json = JSON.parseObject(response).getJSONArray("result");
			logger.info("History 的  ZabbixApi getHistoyByItemID 返回成功");
			System.out.println("History 的  ZabbixApi getHistoyByItemID 返回成功");
		} catch (Exception e) {
			logger.info("History 的  ZabbixApi getHistoyByItemID返回失败"+e);
			System.out.println("History 的  ZabbixApi getHistoyByItemID 返回失败");
		}
		return json;

	}
}
