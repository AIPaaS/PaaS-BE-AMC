package com.ai.amc.core.service;

import java.util.List;
import java.util.Map;

import org.elasticsearch.search.SearchHits;

import com.ai.amc.core.vo.EsDockerLogVo;

public interface IEsLogSv {

	/**
	 * 获取标准日志
	 * @param dockerName 容器名称 （必填）
	 * @param lastId 最后的ID（可为空）
	 * @param lastTime最后的时间（可为空）
	 * @return
	 */
	public List<EsDockerLogVo> getDockerLogRoll(String dockerName,
			String lastId, String lastTime);
	
	/**
	 * 获取日志源
	 * @param containerName 容器名称 （必填）
	 * @return
	 */
	public List<String> getFilePathListByContainer(String containerName);
	
	/**
	 * 获取应用日志
	 * @param containerName 容器名称 （必填）
	 * @param keyword 搜索关键词 （可以为空）
	 * @param filePaths 搜索日志路径（可以为空）
	 * @param startTime 开始时间 （必填）
	 * @param endTime 结束时间 （必填）
	 * @param queryType 搜索类型（必填，-1：更早的日志，0：正常搜索，1：之后的日志）
	 * @param id 基准id(ES中的_id，搜索类型不为0时有效且必填)
	 * @param logTime 基准日志时间(ES中的日志时间，搜索类型不为0时有效且必填)
	 * @return 日志列表
	 */
	public List<EsDockerLogVo> getAppLogRoll(String containerName, String keyword,List<String> filePaths
			,String startTime,String endTime,int queryType,String id,String logTime,boolean highLight);
	
	
	
	/**
	 * 获取应用日志上下文
	 * @param containerName 容器名称 （必填）
	 * @param filePath 搜索日志路径（必填）
	 * @param id 基准id(必填)
	 * @param logTime 基准日志时间(必填)
	 * @return 日志列表
	 */
	public Map<String,List<EsDockerLogVo>> getAppLogContext(String containerName, String filePath
			,String id,String logTime);
}
