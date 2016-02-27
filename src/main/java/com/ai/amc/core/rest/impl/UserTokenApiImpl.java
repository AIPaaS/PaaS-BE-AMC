package com.ai.amc.core.rest.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.amc.core.constants.BaseinfoConstants;
import com.ai.amc.core.rest.UserTokenApi;
import com.ai.amc.core.service.IDemoSv;
import com.ai.amc.core.vo.UserVo;
import com.ai.amc.utils.ZabbixApiUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/*
 * 获取用户token的实现
 * monica
 * 
 */
@Service
public class UserTokenApiImpl implements UserTokenApi {

	@Autowired
	private  IDemoSv demoSv;
	
	@Override
	public UserVo getTokenByUser(UserVo user) {
		System.out.println("==");
		System.out.println("===============as long as you are here===============================");
		try {
			user = setAuth();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("------------为毛找不到--------------");
		}
		return user;
	}
	
	
	@SuppressWarnings("unused")
	private static UserVo setAuth() throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        String username = BaseinfoConstants.USERNAME;
        String password = BaseinfoConstants.PASSWORD;
        params.put("user", username);
        params.put("password", password);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jsonrpc", "2.0");
        map.put("method", "user.login");
        map.put("params", params);
        map.put("auth", null);
        map.put("id", 0);
        String param = JSON.toJSONString(map);
        String response = ZabbixApiUtil.sendPost(param);
        JSONObject json = JSON.parseObject(response);
        
        
        String AUTH = json.getString("result");
        
        UserVo user= new UserVo();
        user.setUsername(username);
        user.setPassword(password);
        user.setToken(AUTH);
        return user;
    }

}
