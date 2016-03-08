package com.ai.amc.core.dao.mapper;

import java.util.List;

import com.ai.amc.core.po.Trends_uint;
import com.ai.amc.core.po.Trends_uintKey;

public interface Trends_uintMapper {
   

    List<Trends_uint> selectByPrimaryKey(Trends_uintKey key);
}