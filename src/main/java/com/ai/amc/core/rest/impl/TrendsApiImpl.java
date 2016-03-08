package com.ai.amc.core.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.amc.core.dao.mapper.TrendsMapper;
import com.ai.amc.core.po.Trends;
import com.ai.amc.core.po.TrendsKey;
import com.ai.amc.core.rest.ITrendsApi;
import com.ai.amc.core.service.ITrendsSv;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class TrendsApiImpl implements ITrendsApi {

	@Autowired
	private ITrendsSv iTrendsSv;
	@Override
	public List<Trends> getTrendsbykey(TrendsKey trendsKey) {
		
		return iTrendsSv.getTrendsByKey(trendsKey);
	}

}
