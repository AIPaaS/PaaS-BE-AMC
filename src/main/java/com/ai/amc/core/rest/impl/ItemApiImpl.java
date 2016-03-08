package com.ai.amc.core.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.amc.core.rest.IItemApi;
import com.ai.amc.core.service.IItemSv;
import com.ai.amc.core.vo.ItemVo;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
@Service
public class ItemApiImpl implements IItemApi {

	@Autowired
	private IItemSv iItemSv;
	
	@Override
	public JSONArray getItemListByHostID(String hostid) {
		
		return iItemSv.getItemListByHostID(hostid);
	}

	@Override
	public List<ItemVo> getItemsByHostID(String hostid) {
		return iItemSv.getItemsByHostID(hostid);
	}

	@Override
	public List<ItemVo> getItemsByName(String name) {
		
		
		return iItemSv.getItemsByName(name);
	}

}
