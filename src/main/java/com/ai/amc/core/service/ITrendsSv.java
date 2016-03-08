package com.ai.amc.core.service;

import java.util.List;

import com.ai.amc.core.po.Trends;
import com.ai.amc.core.po.TrendsKey;
import com.ai.amc.core.vo.HistoryVo;


public interface ITrendsSv {
     
	List<Trends> getTrendsByKey(TrendsKey key);
}
