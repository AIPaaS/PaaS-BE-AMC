package com.ai.amc.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.ai.amc.core.constants.BaseinfoConstants;

/**
 * 向Zabbix发送Post请求工具类
 * @author monica
 *
 */
public class ZabbixApiUtil {
	 /**
     * 向Zabbix发送Post请求，并返回json格式字符串
     * 
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public static String sendPost(String param) throws Exception {
        HttpURLConnection connection = null;
        DataOutputStream out = null;
        BufferedReader reader = null;
        StringBuffer sb = null;
        try {
            //创建连接
            URL url = new URL(BaseinfoConstants.ZABBIX_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式  
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式  

            connection.connect();

            //POST请求
            out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(param);
            out.flush();

            //读取响应
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return sb.toString();

    }

}
