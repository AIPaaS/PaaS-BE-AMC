package com.ai.amc.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.amc.core.constants.BaseinfoConstants;
import com.ai.amc.core.dao.es.EsLogDao;
import com.ai.amc.core.service.IEsLogSv;
import com.ai.amc.core.vo.EsDockerLogVo;
@Repository
@Transactional
public class EsLogSvImpl implements IEsLogSv {
	private static final Logger logger = LogManager
			.getLogger(EsLogSvImpl.class.getName());
	@Autowired
	private EsLogDao esLogDao;
	
	@Override
	public List<EsDockerLogVo> getDockerLogRoll(String dockerName,
			String lastId, String lastTime) {
	     SearchHits hits = esLogDao.getDockerLogRoll(dockerName, lastTime);
	     List<EsDockerLogVo> list = new ArrayList<EsDockerLogVo>();
	     SearchHit[] searchHists = hits.getHits();
	     if(searchHists.length>0){
             for(SearchHit hit:searchHists){
	            	String payload = (String)hit.getSource().get("payload");
	                String timestamp =  (String) hit.getSource().get("timestamp");
	                String id =  (String) hit.getId();
	                EsDockerLogVo vo = new EsDockerLogVo();
	                vo.setPayload(payload);
	                vo.setTimeStamp(timestamp);
	                vo.setId(id);
	                if(lastTime!= null && lastTime.length() > 0 &&
	                		timestamp.equals(lastTime)){
	                	if(lastId != null && id.compareTo(lastId) > 0){
	                		list.add(vo);
	                	}
	                }else{
	                	list.add(vo);
	                }
	            }
	         Collections.sort(list);
	     }
		 return list;
	}

	@Override
	public List<String> getFilePathListByContainer(String containerName) {
		List<String> pathList = new  ArrayList<String>();
		Terms hits = esLogDao.getAppLogPath(containerName);
		for (Terms.Bucket bucket : hits.getBuckets()) {
			pathList.add(bucket.getKeyAsString());
		}
		return pathList;	
	}

	@Override
	public List<EsDockerLogVo> getAppLogRoll(String containerName,
			String keyword, List<String> filePaths, String startTime,
			String endTime, int queryType, String _id, String logTime,boolean highLight) {
		 SearchHits hits = esLogDao.getAppLogRoll(containerName, keyword, filePaths.toArray(new String[filePaths.size()]), startTime, endTime, queryType, logTime);
		 List<EsDockerLogVo> list = new ArrayList<EsDockerLogVo>();
	     SearchHit[] searchHists = hits.getHits();
	     if(searchHists.length>0){
             for(SearchHit hit:searchHists){
            	 	String payload = "";
            	 	if(highLight&&keyword!=null&&keyword.length()>0){
            	 		Map<String, HighlightField> hf = hit.highlightFields();
                	 	Text[] f = hf.get("payload").getFragments();
                	 	for (int i = 0; i < f.length; i++) {
                	 		payload += f[i].toString();
    					}
            	 	}else{
            	 		payload = (String) hit.getSource().get("payload");
            	 	}
	                String timestamp =  (String) hit.getSource().get("timestamp");
	                String id =  (String) hit.getId();
	                String filePath = (String) hit.getSource().get(BaseinfoConstants.ES_LOG_FILE_FIELD);
	                EsDockerLogVo vo = new EsDockerLogVo();
	                vo.setPayload(payload);
	                vo.setTimeStamp(timestamp);
	                vo.setId(id);
	                vo.setFilePath(filePath);
	                if(logTime!= null && logTime.length() > 0 &&
	                		timestamp.equals(logTime)){
	                	if(_id != null && id.compareTo(_id) > 0 && queryType == BaseinfoConstants.ES_APP_LOG_FRONT){
	                		list.add(vo);
	                	}else if(_id != null && id.compareTo(_id) < 0 && queryType == BaseinfoConstants.ES_APP_LOG_BACK){
	                		list.add(vo);
	                	}
	                }else{
	                	list.add(vo);
	                }
	            }
	         Collections.sort(list);
	     }
		return list;
	}

	@Override
	public Map<String,List<EsDockerLogVo>> getAppLogContext(String containerName,
			String filePath, String _id, String logTime) {
		Map<String,List<EsDockerLogVo>> map = new HashMap<String, List<EsDockerLogVo>>();
		List<String> filePaths = new ArrayList<String>();
		filePaths.add(filePath);
		List<EsDockerLogVo> backList= getAppLogRoll(containerName,
				null, filePaths, null,
				null, BaseinfoConstants.ES_APP_LOG_BACK, _id, logTime,false);
		List<EsDockerLogVo> frontList= getAppLogRoll(containerName,
				null, filePaths, null,
				null, BaseinfoConstants.ES_APP_LOG_FRONT, _id, logTime,false);
		map.put("backList", backList);
		map.put("frontList", frontList);
		return map;
	}

}
