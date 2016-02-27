package com.ai.amc.core.dao.mapper;

import com.ai.amc.core.po.DemoTable;

/**
 * 实例
 * @author archer
 *
 */

public interface IDemoTableDao {
	
	public int insertdemo(DemoTable user);
	public DemoTable selectone(int sid);
	
}
