package com.ai.amc.core.constants;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



/**
 * @version 2009-10-11
 */
public final class ConstManagerImpl implements ConstManager {

	private static Map<Object, Object> constMap = null;

	private static final Logger logger = LogManager
			.getLogger(ConstManagerImpl.class.getName());

	private static String DEFAULT_CONFIG_FILE = "context/amc.properties";

	private static String CONFIG_FILE = null;

	private static boolean PARAM_VALID = false;

	private static String PRE_PARAM = "";

	private static String Y_STR = "Y";
	private static String TRUE_STR = "TRUE";

	private static ConstManager manager;

	private ConstManagerImpl() {
	}

	private ConstManagerImpl(String configFile) {
	}

	public synchronized static ConstManager getInstance() {
		if (manager == null) {
			manager = new ConstManagerImpl();
		}
		return manager;
	}

	public synchronized static ConstManager getInstance(String configFile) {
		if (manager == null) {
			manager = new ConstManagerImpl(configFile);
		}
		return manager;
	}

	/**
	 * 按key取值
	 */
	public synchronized Object getConst(Object key) {
		if (constMap == null) {
			constMap = loadConst();
			if (constMap == null) {
				logger.error("配置文件" + CONFIG_FILE == null ? DEFAULT_CONFIG_FILE : CONFIG_FILE + "不存在或读取失败！");
				throw new RuntimeException("配置文件" + CONFIG_FILE == null ? DEFAULT_CONFIG_FILE : CONFIG_FILE
						+ "不存在或读取失败！");
			}
			if (constMap.size() == 0) {
				logger.error("配置文件" + CONFIG_FILE == null ? DEFAULT_CONFIG_FILE : CONFIG_FILE + "中无配置数据！");
				throw new RuntimeException("配置文件：" + CONFIG_FILE == null ? DEFAULT_CONFIG_FILE : CONFIG_FILE
						+ "中无配置数据！");
			}
		}
		if (constMap.containsKey(key)) {
			return constMap.get(key);
		} else {
			logger.error("配置文件：" + CONFIG_FILE == null ? DEFAULT_CONFIG_FILE : CONFIG_FILE + "中没有配置：\"" + key
					+ "\"这个常量！");
			return null;
		}
	}

	public synchronized Map<Object, Object> getConstMap() {
		if (constMap == null) {
			constMap = loadConst();
		}
		return constMap;
	}

	/**
	 * 初始化常量数据,定义了常量前缀的校验。
	 */
	private synchronized Map<Object, Object> loadConst() {
		String filePath;
		if (CONFIG_FILE != null) {
			filePath = CONFIG_FILE;
		} else {
			filePath = DEFAULT_CONFIG_FILE;
		}

		InputStream input = manager.getClass().getClassLoader().getResourceAsStream(filePath);
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			logger.error(e.toString());
			return null;
		} catch (Exception e) {
			logger.error(e.toString());
			return null;
		} finally {
			try {
				input.close();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}

		Map<Object, Object> map = new HashMap<Object, Object>();
		Enumeration<?> enum1 = prop.keys();
		while (enum1.hasMoreElements()) {
			try {
				String id = enum1.nextElement().toString();
				map.put(id, new String(prop.getProperty(id).getBytes("ISO-8859-1"), "GBK"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
				logger.error("字符集不支持", e1);
			}
		}

		if (PARAM_VALID) {
			if (!validateConst(map)) {
				logger.error("常量定义没有用[" + PRE_PARAM + "]打头");
				throw new RuntimeException("常量定义没有用[" + PRE_PARAM + "]打头");
			}
		}
		return map;
	}

	/**
	 * 检测常量数据的配置是否是以CONST_开头的
	 * @param map
	 * @return
	 */
	private boolean validateConst(Map<Object, Object> map) {
		Set<Object> keys = map.keySet();
		for (Iterator<Object> iter = keys.iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			if (!key.substring(0, PRE_PARAM.length()).equals(PRE_PARAM)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param string
	 */
	public void setConfigFile(String string) {
		synchronized (CONFIG_FILE) {
			CONFIG_FILE = string;
		}
	}

	/* 
	 * (non-Javadoc)
	 * @see bss.crm.comanager.common.ConstManager
	 * #getString(java.lang.Object)
	 */
	public String getString(Object key) {
		try {
			Object obj = getConst(key);
			if (obj == null) {
				return null;
			}
			return obj.toString();
		} catch (Exception e) {
			logger.info("取常量时出错，KEY=" + key + "\n" + e.toString());
			throw new RuntimeException("取常量时出错，KEY=" + key + "\n" + e.toString());
		}
	}

	/*
	 *  (non-Javadoc)
	 * @see bss.crm.comanager.common.ConstManager
	 * #getInteger(java.lang.Object)
	 */
	public Integer getInteger(Object key) {
		try {
			String str = getString(key);
			if (str == null) {
				return null;
			}
			return Integer.valueOf(str);
		} catch (Exception e) {
			logger.error("取常量时出错，KEY=" + key + "\n" + e.toString());
			throw new RuntimeException("取常量时出错，KEY=" + key + "\n" + e.toString());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.linkage.bss.crm.order.commons.ConstManager
	 * #getBoolean(java.lang.Object)
	 */
	public boolean getBoolean(Object key) {
		try {
			Object obj = getConst(key);
			if (obj == null) {
				return false;
			}
			String result = obj.toString();
			if (Y_STR.equals(result) || TRUE_STR.equalsIgnoreCase(result)) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.error("取常量时出错，KEY=" + key + "\n" + e.toString());
			throw new RuntimeException("取常量时出错，KEY=" + key + "\n" + e.toString());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.linkage.bss.crm.order.commons.ConstManager#getInteger(java.lang.Object, java.lang.Integer)
	 */
	public Integer getInteger(Object key, Integer defaultValue) {
		Integer value = getInteger(key);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	/*
	 * (non-Javadoc)
	 * @see com.linkage.bss.crm.order.commons.ConstManager#getString(java.lang.Object, java.lang.String)
	 */
	public String getString(Object key, String defaultValue) {
		String value = getString(key);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	/**
	 * 得到符合某一表达式条件的key的所有key,value值
	 */
	public synchronized Map<String, String> getPropertyValueListByRegex(String regex) {
		if (constMap == null) {
			constMap = loadConst();
			if (constMap == null) {
				logger.error("配置文件" + CONFIG_FILE == null ? DEFAULT_CONFIG_FILE : CONFIG_FILE + "不存在或读取失败！");
				throw new RuntimeException("配置文件" + CONFIG_FILE == null ? DEFAULT_CONFIG_FILE : CONFIG_FILE
						+ "不存在或读取失败！");
			}
			if (constMap.size() == 0) {
				logger.error("配置文件" + CONFIG_FILE == null ? DEFAULT_CONFIG_FILE : CONFIG_FILE + "中无配置数据！");
				throw new RuntimeException("配置文件：" + CONFIG_FILE == null ? DEFAULT_CONFIG_FILE : CONFIG_FILE
						+ "中无配置数据！");
			}
		}
		Set<Object> set = constMap.keySet();
		Map<String, String> propertyMap = new HashMap<String, String>();
		for (Object key : set) {
			if (key.toString().contains(regex)) {
				propertyMap.put(key.toString(), String.valueOf(getConst(key)));
			}
		}
		return propertyMap;
	}
}
