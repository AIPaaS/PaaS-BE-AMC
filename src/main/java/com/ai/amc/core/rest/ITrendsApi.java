package com.ai.amc.core.rest;

import java.util.List;

import com.ai.amc.core.po.Trends;
import com.ai.amc.core.po.TrendsKey;
import com.ai.amc.core.vo.HistoryVo;

public interface ITrendsApi {
	List<Trends> getTrendsbykey(TrendsKey trendsKey);
}
