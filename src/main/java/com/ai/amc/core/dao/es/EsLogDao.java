package com.ai.amc.core.dao.es;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Repository;

import com.ai.amc.core.constants.BaseinfoConstants;
import com.ai.amc.utils.ElasticSearchUtil;

@Repository
public class EsLogDao {

	private static final Logger logger = LogManager
			.getLogger(EsLogDao.class.getName());
	
	public SearchHits getDockerLogRoll(String dockerName,String lastTime){
		TransportClient client = ElasticSearchUtil.getTransportClient();
		SearchRequestBuilder builder = client.prepareSearch(BaseinfoConstants.ES_INDEXNAME)
		        .setSearchType(SearchType.DEFAULT);
		BoolQueryBuilder bqb = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("ContainerName", dockerName));
        if(lastTime != null && lastTime.length() > 0){
        	bqb.must(QueryBuilders.rangeQuery("timestamp").from(lastTime));
        	builder.addSort(SortBuilders.fieldSort("timestamp").order(SortOrder.ASC));
        	builder.setFrom(0).setSize(1000);
        }
        builder.setQuery(bqb);
        builder.setPostFilter(QueryBuilders.existsQuery("timestamp"));
        if(lastTime == null || lastTime.length() == 0){
        	builder.addSort(SortBuilders.fieldSort("timestamp").order(SortOrder.DESC));
        	builder.setFrom(0).setSize(200);
        }
        builder.setExplain(true);
		SearchResponse response = builder.execute().actionGet();
		SearchHits hits = response.getHits();
		return hits;
	}

	
}
