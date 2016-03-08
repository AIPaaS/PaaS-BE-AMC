package com.ai.amc.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.amc.core.dao.mapper.TrendsMapper;
import com.ai.amc.core.po.Trends;
import com.ai.amc.core.po.TrendsKey;
import com.ai.amc.core.service.ITrendsSv;
import com.ai.amc.core.vo.HistoryVo;
@Repository
@Transactional
public class TrendsSvImpl implements ITrendsSv {
	@Autowired
	private TrendsMapper trendsMapper;
	@Override
	public List<Trends> getTrendsByKey(TrendsKey key) {
		
		return trendsMapper.selectByPrimaryKey(key);
	}

}
