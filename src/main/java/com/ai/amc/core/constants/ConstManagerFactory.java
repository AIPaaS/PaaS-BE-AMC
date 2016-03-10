package com.ai.amc.core.constants;


/**
 * @version 2009-10-11
 */
public class ConstManagerFactory {
	public static ConstManager getConstManagerImpl() {
		return ConstManagerImpl.getInstance();
	}

	public static ConstManager getConstManagerImpl(String configFile) {
		return ConstManagerImpl.getInstance(configFile);
	}
}
