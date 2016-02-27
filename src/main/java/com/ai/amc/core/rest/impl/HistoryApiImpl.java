package com.ai.amc.core.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.amc.core.rest.IHistoryApi;
import com.ai.amc.core.service.IHistorySv;
import com.ai.amc.core.vo.HistoryVo;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class HistoryApiImpl implements IHistoryApi {

	@Autowired
	private IHistorySv iHistorySv;
	@Override
	public List<HistoryVo> getItemsByItemID(String itemid,String value_type) {
		
		return iHistorySv.getItemsByItemID(itemid,value_type);
	}

}
