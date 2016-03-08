package com.ai.amc.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.amc.core.dao.mapper.Trends_uintMapper;
import com.ai.amc.core.po.Trends_uint;
import com.ai.amc.core.po.Trends_uintKey;
import com.ai.amc.core.service.ITrends_uintSv;
@Repository
@Transactional
public class Trends_uintSvImpl implements ITrends_uintSv {

	@Autowired
	private Trends_uintMapper trends_uintMapper;
	@Override
	public List<Trends_uint> getTrendsByKey(Trends_uintKey key) {
		 
		return trends_uintMapper.selectByPrimaryKey(key);
	}

}
