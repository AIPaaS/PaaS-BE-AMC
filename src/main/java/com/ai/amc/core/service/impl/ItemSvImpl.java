package com.ai.amc.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.amc.core.dao.zabbixapi.ItemZabbixApi;
import com.ai.amc.core.service.IItemSv;
import com.ai.amc.core.vo.ItemVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
@Repository
@Transactional
public class ItemSvImpl implements IItemSv {

	@Autowired
	private ItemZabbixApi itemZabbixApi;
	
	
	@Override
	public JSONArray getItemListByHostID(String hostid) {
		
		return itemZabbixApi.getItemListByHostID(hostid);
	}


	@Override
	public List<ItemVo> getItemsByHostID(String hostid) {
		List<ItemVo> items =null;
		items = JSON.parseArray(itemZabbixApi.getItemListByHostID(hostid).toString(), ItemVo.class);
		return items;
	}

}
