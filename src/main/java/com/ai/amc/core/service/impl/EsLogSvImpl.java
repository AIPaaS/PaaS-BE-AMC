package com.ai.amc.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	            	String payload = (String)hit.getSource().get("Payload");
	                String timestamp =  (String) hit.getSource().get("@timestamp");
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

}
