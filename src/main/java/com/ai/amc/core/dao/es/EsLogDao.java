package com.ai.amc.core.dao.es;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregator;
import org.elasticsearch.search.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Repository;

import com.ai.amc.core.constants.BaseinfoConstants;
import com.ai.amc.core.vo.EsDockerLogVo;
import com.ai.amc.utils.ElasticSearchUtil;

@Repository
public class EsLogDao {

	private static final Logger logger = LogManager.getLogger(EsLogDao.class
			.getName());

	public SearchHits getDockerLogRoll(String dockerName, String lastTime) {
		TransportClient client = ElasticSearchUtil.getTransportClient();
		SearchRequestBuilder builder = client.prepareSearch(
				BaseinfoConstants.ES_INDEXNAME).setSearchType(
				SearchType.DEFAULT);
		BoolQueryBuilder bqb = QueryBuilders.boolQuery().must(
				QueryBuilders.matchQuery("ContainerName", dockerName));
		if (lastTime != null && lastTime.length() > 0) {
			bqb.must(QueryBuilders.rangeQuery("timestamp").from(lastTime));
			builder.addSort(SortBuilders.fieldSort("timestamp").order(
					SortOrder.ASC));
			builder.setFrom(0).setSize(1000);
		}
		builder.setQuery(bqb);
		builder.setPostFilter(QueryBuilders.existsQuery("timestamp"));
		if (lastTime == null || lastTime.length() == 0) {
			builder.addSort(SortBuilders.fieldSort("timestamp").order(
					SortOrder.DESC));
			builder.setFrom(0).setSize(200);
		}
		builder.setExplain(true);
		SearchResponse response = builder.execute().actionGet();
		SearchHits hits = response.getHits();
		return hits;
	}

	public Terms getAppLogPath(String containerName) {
		TransportClient client = ElasticSearchUtil.getTransportClient();
		SearchRequestBuilder builder = client.prepareSearch(
				BaseinfoConstants.ES_INDEXNAME).setSearchType(
				SearchType.DEFAULT);
		containerName = QueryParser.escape(containerName);
		 BoolQueryBuilder bqb =
		 QueryBuilders.boolQuery().must(QueryBuilders.termQuery("ContainerName",
		 containerName));
		builder.setQuery(bqb);
		builder.addAggregation(AggregationBuilders.terms("agg1").field(
				BaseinfoConstants.ES_LOG_FILE_FIELD));
		SearchResponse response = builder.execute().actionGet();
		Terms hits = response.getAggregations().get("agg1");
		return hits;
	}

	public SearchHits getAppLogRoll(String containerName, String keyword,String[] filePaths
			,String startTime,String endTime,int queryType,String logTime) {
		TransportClient client = ElasticSearchUtil.getTransportClient();
		SearchRequestBuilder builder = client.prepareSearch(
				BaseinfoConstants.ES_INDEXNAME).setSearchType(
				SearchType.DEFAULT);
		BoolQueryBuilder bqb = QueryBuilders.boolQuery().must(
				QueryBuilders.termQuery("ContainerName",containerName));
		if(filePaths != null && filePaths.length > 0){
			bqb.must(QueryBuilders.termsQuery(BaseinfoConstants.ES_LOG_FILE_FIELD, filePaths));
		}
		if(keyword != null && keyword.length() > 0){
			bqb.must(QueryBuilders.termQuery("payload", keyword));
			builder.addHighlightedField("payload");
		}
		if(queryType == BaseinfoConstants.ES_APP_LOG_NORMAL){
			if(startTime != null && startTime.length() > 0){
				bqb.must(QueryBuilders.rangeQuery("timestamp").from(startTime).to(endTime));
			}
			builder.addSort(SortBuilders.fieldSort("timestamp").order(
					SortOrder.DESC));
		}else if(queryType == BaseinfoConstants.ES_APP_LOG_BACK){
			bqb.must(QueryBuilders.rangeQuery("timestamp").to(logTime));
			builder.addSort(SortBuilders.fieldSort("timestamp").order(
					SortOrder.DESC));
		}else if(queryType == BaseinfoConstants.ES_APP_LOG_FRONT){
			bqb.must(QueryBuilders.rangeQuery("timestamp").from(logTime));
			builder.addSort(SortBuilders.fieldSort("timestamp").order(
					SortOrder.ASC));
		}else {return null;}
		builder.setQuery(bqb);
		builder.setPostFilter(QueryBuilders.existsQuery("timestamp"));
		builder.setFrom(0).setSize(100);
		SearchResponse response = builder.execute().actionGet();
		SearchHits hits = response.getHits();
		return hits;
	}
	

}
