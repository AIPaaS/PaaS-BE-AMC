package com.ai.amc.core.vo;

import java.io.Serializable;
import java.util.List;

public class Application implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String hostid;
	private String applicationid;
	private List<String> templateids;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHostid() {
		return hostid;
	}
	public void setHostid(String hostid) {
		this.hostid = hostid;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public List<String> getTemplateids() {
		return templateids;
	}
	public void setTemplateids(List<String> templateids) {
		this.templateids = templateids;
	}
}
