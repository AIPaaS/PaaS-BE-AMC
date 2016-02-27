package com.ai.amc.core.rest;

import com.ai.amc.core.vo.UserVo;

public interface UserTokenApi {

	public  UserVo getTokenByUser(UserVo user);	
}
