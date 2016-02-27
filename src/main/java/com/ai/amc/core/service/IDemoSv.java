package com.ai.amc.core.service;

import com.ai.amc.core.po.DemoTable;

/**
 * 实例
 * 
 * @author archer
 * 
 */
public interface IDemoSv {
	public int insertdemo(DemoTable param);

	public int selectone(int sid);

}
