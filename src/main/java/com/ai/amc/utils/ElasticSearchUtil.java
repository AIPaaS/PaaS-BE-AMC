package com.ai.amc.utils;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.ai.amc.core.constants.BaseinfoConstants;

public class ElasticSearchUtil {
	static Map<String, String> m = new HashMap<String, String>();
    // 设置client.transport.sniff为true来使客户端去嗅探整个集群的状态，把集群中其它机器的ip地址加到客户端中，
    static Settings settings = Settings.settingsBuilder()
            .put("cluster.name", BaseinfoConstants.ES_CLUSTERNAME).put("client.transport.sniff", true).build();
 
    // 创建私有对象
    private static TransportClient client;
 
    static {
        try {
        	client = TransportClient.builder().settings(settings).build();
            for(String url : BaseinfoConstants.ES_URL.split(",",-1)){
            	String host = url.split(":",-1)[0];
            	Integer port = Integer.valueOf(url.split(":",-1)[1]);
            	client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
 
    // 取得实例
    public static synchronized TransportClient getTransportClient() {
        return client;
    }
    
}
