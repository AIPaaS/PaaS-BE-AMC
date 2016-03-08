package com.ai.amc.core.service;

import java.util.List;

import com.ai.amc.core.vo.HostVo;
import com.ai.amc.core.vo.ItemVo;
import com.alibaba.fastjson.JSONArray;

public interface IItemSv {
     

	JSONArray getItemListByHostID(String hostid);
	List<ItemVo> getItemsByHostID(String hostid);
	List<ItemVo> getItemsByName(String name);
}
