package com.ai.amc.core.rest.impl;

import java.util.List;
import java.util.Map;

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
	@Override
	public List<String> getFilePathListByContainer(String containerName) {
		return esLogSv.getFilePathListByContainer(containerName);
	}
	@Override
	public List<EsDockerLogVo> getAppLogRoll(String containerName,
			String keyword, List<String> filePaths, String startTime,
			String endTime, int queryType, String id, String logTime) {
		return esLogSv.getAppLogRoll(containerName, keyword, filePaths, 
				startTime, endTime, queryType, id, logTime,true);
	}
	@Override
	public Map<String,List<EsDockerLogVo>> getAppLogContext(String containerName,
			String filePath, String id, String logTime) {
		return esLogSv.getAppLogContext(containerName, filePath, id, logTime);
	}

}
