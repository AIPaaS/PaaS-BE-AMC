package com.ai.amc.core.constants;
/**
 * 常用异常静态参数
 * @author archer
 *
 */
public class ExceptionConstants {	

	/**
	 * 请求
	 * @author archer
	 *
	 */
	public static class Request {

		public static final String PARAM_IS_NULL = "100100"; // "请求参数为空!"

		public static final String PARAM_IS_NOT_VALID = "100101"; // "请求参数格式不合法!"
	}

	
		
      

	
	
	/**
	 * 返回
	 * @author archer
	 *
	 */
	public static class Response {

		public static final String TRADE_SUCCESS = "000000";  //"处理成功";

		public static final String TRADE_FAILURE = "999999";  //"系统繁忙，请稍后重试!"
		
		public static final String NO_RESULT = "200000"; // 查询结果为空

	}

}
