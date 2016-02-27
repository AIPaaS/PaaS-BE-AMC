package com.ai.amc.core.vo;

import java.io.Serializable;

public class HostgroupVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String internal;
	private String groupid;
	private String name;
	private String flags;
	public String getInternal() {
		return internal;
	}
	public void setInternal(String internal) {
		this.internal = internal;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlags() {
		return flags;
	}
	public void setFlags(String flags) {
		this.flags = flags;
	}
	
	

}
