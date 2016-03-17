package com.ai.amc.core.rest;

import java.util.List;

import com.ai.amc.core.vo.EsDockerLogVo;

public interface IEsLogApi {

	List<EsDockerLogVo> getDockerLogRoll(String dockerName,String lastId,String lastTime);
}
