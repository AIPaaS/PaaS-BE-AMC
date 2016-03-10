package com.ai.amc.core.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ai.amc.core.rest.IEsLogApi;
import com.ai.amc.core.service.IEsLogSv;
import com.ai.amc.core.vo.EsDockerLogVo;
import com.alibaba.dubbo.config.annotation.Service;
@Service
public class EsLogApiImpl implements IEsLogApi {

	@Autowired
	private IEsLogSv esLogSv;
	@Override
	public List<EsDockerLogVo> getDockerLogRoll(String dockerName,
			String lastId, String lastTime) {
		return esLogSv.getDockerLogRoll(dockerName, lastId, lastTime);
	}

}
