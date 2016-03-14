package com.ai.amc.core.constants;


import java.util.Map;

/**
 * @version 2009-10-11
 */
public interface ConstManager {

	/**
	 * 根据传入的key，在const的配置文件或数据库中查找对应的常量值，如果没有配置，默认返回空
	 * @param key
	 * @return
	 */
	public String getString(Object key);

	/**
	 * 根据传入的key，在const的配置文件或数据库中查找对应的常量值，如果没有配置，默认返回空
	 * @param key
	 * @param defaultValue 如果根据key值获取的值为空，那么返回默认值
	 * @return
	 */
	public String getString(Object key, String defaultValue);

	/**
	 * 根据传入的key，在const的配置文件或数据库中查找对应的常量值，如果没有配置，默认返回null
	 * @param key
	 * @return
	 */
	public Integer getInteger(Object key);

	/**
	 * 根据传入的key，在const的配置文件或数据库中查找对应的常量值，如果没有配置，默认返回null
	 * @param key
	 * @param defaultValue 如果根据key值获取的值为空，那么返回默认值
	 * @return
	 */
	public Integer getInteger(Object key, Integer defaultValue);

	/**
	 * 根据传入的key，在const的配置文件或数据库中查找对应的常量值，如果没有配置，默认返回false
	 * @param key
	 * @return
	 */
	public boolean getBoolean(Object key);

	/**
	 * 获取常量定义的MAP
	 * @return
	 */
	public Map getConstMap();

	/**
	 * 得到符合某一表达式条件的key的所有key,value值
	 */
	public Map<String, String> getPropertyValueListByRegex(String regex);
}
