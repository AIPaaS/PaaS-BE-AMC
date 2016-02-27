package com.ai.amc.core.rest;


import com.ai.amc.core.po.DemoTable;
import com.ai.amc.core.vo.DemoTableVo;

/**
 * DemoApi 示例Api接口定义
 * @author archer
 *  *
 */

public interface IDemoApi {	
	
	
	public int  insertDemo(DemoTable param);	
	public DemoTable  selectone(int sid);	
	

}
