package com.ai.amc.core.rest;

import java.util.List;

import com.ai.amc.core.po.Trends;
import com.ai.amc.core.po.TrendsKey;
import com.ai.amc.core.po.Trends_uint;
import com.ai.amc.core.po.Trends_uintKey;
import com.ai.amc.core.vo.HistoryVo;

public interface ITrends_uintApi {
	List<Trends_uint> getTrendsbykey(Trends_uintKey trends_uintKey);
}
