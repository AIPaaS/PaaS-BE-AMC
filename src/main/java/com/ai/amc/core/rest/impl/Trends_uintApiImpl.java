package com.ai.amc.core.rest.impl;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;

import com.ai.amc.core.po.Trends_uint;
import com.ai.amc.core.po.Trends_uintKey;
import com.ai.amc.core.rest.ITrends_uintApi;
import com.ai.amc.core.service.ITrends_uintSv;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class Trends_uintApiImpl implements ITrends_uintApi {

	@Autowired
	private ITrends_uintSv iTrends_uintSv;
	@Override
	public List<Trends_uint> getTrendsbykey(Trends_uintKey trends_uintKey) {
	
		return iTrends_uintSv.getTrendsByKey(trends_uintKey);
	}

}
