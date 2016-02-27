package com.ai.amc.core.rest;

import java.util.List;

import com.ai.amc.core.vo.ItemVo;
import com.alibaba.fastjson.JSONArray;

public interface IItemApi {

	JSONArray getItemListByHostID(String hostid);
	List<ItemVo> getItemsByHostID(String hostid);
}
