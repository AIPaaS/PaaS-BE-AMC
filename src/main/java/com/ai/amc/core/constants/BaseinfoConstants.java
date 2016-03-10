package com.ai.amc.core.constants;

import java.util.HashMap;
import java.util.Map;

import com.ai.amc.utils.ZabbixApiUtil;
import com.alibaba.fastjson.JSON;

/**
 * 常用静态参数
 * @author monica
 *
 */
public class BaseinfoConstants {

	public static ConstManager constManager = ConstManagerFactory.getConstManagerImpl();
        //请求zabbix接口的api地址
	   // public static final String URL      = "http://10.1.31.18/api_jsonrpc.php";
	   public static final String ZABBIX_URL   = constManager.getString("zabbix.url"); 
	   //ElasticSearch地址配置
	   public static final String ES_URL = constManager.getString("es.url");
	   public static final String ES_CLUSTERNAME = constManager.getString("es.clusterName");
	   public static final String ES_INDEXNAME = constManager.getString("es.indexName");
	   public static final String ES_USER = constManager.getString("es.user");
	   public static final String ES_PASSWD = constManager.getString("es.passwd");
	    //zabbix用户的token 后期用NT账号换
	  //  public static final String AUTH     = "687947605d8e44bfce23d776434dc351";
	    
	    //35ee4149ce4f75d1b230f3dcc3107150
	    //2e34126116976b306f0695f5429282c3   70d3dcf8ca819c96d21bd0b38c0463bd
	    //88c0ec1350384fff5fcab3af33201e8d
	    //用户名
	    public static   String USERNAME = "Admin";
	    //密码
	    public static  String PASSWORD = "zabbix";
	    
	    public static final String getAuth(){
	    	Map<String, Object> params = new HashMap<String, Object>();
			params.put("user", USERNAME);
			params.put("password",PASSWORD);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("jsonrpc", "2.0");
			map.put("method", "user.login");
			map.put("params", params);
			map.put("auth", null);
			map.put("id", 0);
			String param = JSON.toJSONString(map);
			String json = null;
			String response;
			try {
				response = ZabbixApiUtil.sendPost(param);
				json = JSON.parseObject(response).getString("result");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("用户名密码不正确！");
			}
			
			return json;
	    	
	    }

}
