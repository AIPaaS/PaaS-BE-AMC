package com.ai.amc.core.rest;

import java.util.List;

import com.ai.amc.core.vo.HistoryVo;

public interface IHistoryApi {
	List<HistoryVo> getItemsByItemID(String itemid,String value_type,int time);
}
