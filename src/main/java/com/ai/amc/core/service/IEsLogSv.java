package com.ai.amc.core.service;

import java.util.List;

import com.ai.amc.core.vo.EsDockerLogVo;

public interface IEsLogSv {

	public List<EsDockerLogVo> getDockerLogRoll(String dockerName,
			String lastId, String lastTime);
}
