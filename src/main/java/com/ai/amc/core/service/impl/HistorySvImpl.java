package com.ai.amc.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.amc.core.dao.zabbixapi.HistoryZabbixApi;
import com.ai.amc.core.service.IHistorySv;
import com.ai.amc.core.vo.HistoryVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
@Repository
@Transactional
public class HistorySvImpl implements IHistorySv {
	@Autowired
	private HistoryZabbixApi historyZabbixApi;
	@Override
	public List<HistoryVo> getItemsByItemID(String itemid,String value_type,int time) {
		
		JSONArray history = historyZabbixApi.getHistoyByItemID(itemid,value_type,time);
		List<HistoryVo> historylist = JSON.parseArray(history.toString(), HistoryVo.class);
		return historylist;
	}

}
