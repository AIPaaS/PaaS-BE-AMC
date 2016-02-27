package com.ai.amc.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * dao层参数生成
 * @author mapl
 *
 */
public  class DaoCpParamsUtil {	
	
	private static final Logger logger = LogManager.getLogger(DaoCpParamsUtil.class.getName());	
	
	public static Map<String,Object> cpObject2Map(Object model) throws Exception {
		logger.info(" input DaoCpParamsUtil class cpObject2Map function ...");
		Field[] field = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			for (int j = 0; j < field.length; j++) { // 遍历所有属性
				String name = field[j].getName(); // 获取属性的名字
				name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
				String type = field[j].getGenericType().toString(); // 获取属性的类型
				if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
					Method m = model.getClass().getMethod("get" + name);
					String value = (String) m.invoke(model); // 调用getter方法获取属性值
					if (value != null) {
						map.put(name, value);
					}
				}
				if (type.equals("class java.lang.Integer")) {
					Method m = model.getClass().getMethod("get" + name);
					Integer value = (Integer) m.invoke(model);
					if (value != null) {
						map.put(name, value);
					}
				}
				if (type.equals("class java.lang.Short")) {
					Method m = model.getClass().getMethod("get" + name);
					Short value = (Short) m.invoke(model);
					if (value != null) {
						map.put(name, value);
					}
				}
				if (type.equals("class java.lang.Double")) {
					Method m = model.getClass().getMethod("get" + name);
					Double value = (Double) m.invoke(model);
					if (value != null) {
						map.put(name, value);
					}
				}
				if (type.equals("class java.lang.Boolean")) {
					Method m = model.getClass().getMethod("get" + name);
					Boolean value = (Boolean) m.invoke(model);
					if (value != null) {
						map.put(name, value);
					}
				}
				if (type.equals("class java.sql.Date")) {
					Method m = model.getClass().getMethod("get" + name);
					Date value = (Date) m.invoke(model);
					if (value != null) {
						map.put(name, value);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);;
           throw e;
		}
		logger.info(" output DaoCpParamsUtil class cpObject2Map function ...");
		return map;
	}
	
	
	
	/**
	 * select 语句 的 where子句生成
	 * @param params
	 * @return
	 */
	public static String whereClause(Map<String,Object>  params) {
		StringBuffer buffer = new StringBuffer();
		int firstTag = 0;
		buffer.append(" where ");
		for (String key : params.keySet()) {
			  if(0 == firstTag){
				  buffer.append(key).append(" = ").append(":").append(key);
				  firstTag ++;
			  }else{
				  buffer.append(" and ").append(key).append(" = ").append(":").append(key);
			  }
		}
		
		return buffer.toString();
	}
	
	/**
	 * select 语句的 where子句生成
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public static String whereClause(Object  object) throws Exception {
		Map<String,Object>  params = cpObject2Map(object);
		String clause = whereClause(params); 
		return clause;
	}
	
	
	/**
	 * insert 语句 的 插入的属性子句生成
	 * @param params 
	 * @return
	 */
	public static String insertAttributeClause(Map<String,Object>  params) {
		StringBuffer attributebuffer = new StringBuffer();
		StringBuffer valuebuffer = new StringBuffer();
		Set<String> set  = params.keySet();
		int index = set.size();
		
		attributebuffer.append(" ( ");
		valuebuffer.append(" values (");
		for (String key : params.keySet()) {
			  if(1 == index){
				  attributebuffer.append(key);
				  valuebuffer.append(":").append(key);
				  index --;
			  }else{
				  attributebuffer.append(key).append(" , ");
				  valuebuffer.append(":").append(key).append(" , ");
				  index --;
			  }
		}
		
		attributebuffer.append(" ) ");
		valuebuffer.append(" )");
		
		attributebuffer.append(valuebuffer);
		
		return attributebuffer.toString();
	}
	
	/**
	 * insert 语句 的 插入的属性子句生成
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public static String insertAttributeClause(Object  object) throws Exception {
		Map<String,Object>  params = cpObject2Map(object);
		String clause = insertAttributeClause(params); 
		return clause;
	}
	
	
	/**
	 * 复制查询结果到类实例
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public static Object cpRs2Bean(Object  object,ResultSet rs)  {
		logger.info(" input DaoCpParamsUtil class cpRs2Bean function ...");
		Class<?> cls = object.getClass(); 
		
		Field[] field = cls.getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
		try {
			for (int j = 0; j < field.length; j++) { // 遍历所有属性
				String name = field[j].getName(); // 获取属性的名字
				name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
				Type type = field[j].getGenericType();
				String typeStr = type.toString(); // 获取属性的类型
				
				if (typeStr.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
					Method model = cls.getMethod("set" + name, new Class[] { String.class});
					model.invoke(object,rs.getString(name)); // 调用getter方法获取属性值				
					
				}
				if (typeStr.equals("class java.lang.Integer")) {
					Method model = cls.getMethod("set" + name, new Class[] { Integer.class });
					model.invoke(object,rs.getInt(name)); // 调用getter方法获取属性值
				}
				if (typeStr.equals("class java.lang.Short")) {
					Method model = cls.getMethod("set" + name, new Class[] { Short.class });
					model.invoke(object,rs.getShort(name)); // 调用getter方法获取属性值
				}
				if (typeStr.equals("class java.lang.Double")) {
					Method model = cls.getMethod("set" + name, new Class[] { Double.class });
					model.invoke(object,rs.getDouble(name)); // 调用getter方法获取属性值
				}
				if (typeStr.equals("class java.lang.Boolean")) {
					Method model = cls.getMethod("set" + name, new Class[] { Boolean.class });
					model.invoke(object,rs.getBoolean(name)); // 调用getter方法获取属性值
				}
				if (typeStr.equals("class java.sql.Date")) {
					Method model = cls.getMethod("set" + name, new Class[] { Date.class });
					model.invoke(object,rs.getDate(name)); // 调用getter方法获取属性值
				}
			}		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);;
		}
		logger.info(" output DaoCpParamsUtil class cpRs2Bean function ...");
		return object;
		
	}
	
	
	public static void main(String[] args){
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("qaz", "1");		
		params.put("wsx", "2");		
		params.put("edc", "3");
		StringBuffer attributebuffer = new StringBuffer();
		StringBuffer valuebuffer = new StringBuffer();
		Set<String> set  = params.keySet();
		int index = set.size();
		
		attributebuffer.append(" ( ");
		valuebuffer.append(" values (");
		for (String key : params.keySet()) {
			  if(1 == index){
				  attributebuffer.append(key);
				  valuebuffer.append(":").append(key);
				  index --;
			  }else{
				  attributebuffer.append(key).append(" , ");
				  valuebuffer.append(":").append(key).append(" , ");
				  index --;
			  }
		}
		
		attributebuffer.append(" ) ");
		valuebuffer.append(" )");
		
		attributebuffer.append(valuebuffer);
		
		
	}

}
