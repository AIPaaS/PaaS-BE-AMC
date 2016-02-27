package com.ai.amc.core.vo;

import java.io.Serializable;
import java.util.List;

public class HostVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String host;
	private int hostid;
	private String status;
	private List<InterfaceVo> interfaces;
	private String  ip;
	private String items;
	private String triggers;
	private String available;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getHostid() {
		return hostid;
	}
	public void setHostid(int hostid) {
		this.hostid = hostid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getIp() {
		return this.ip = this.getInterfaces().get(0).getIp();
	}
	public void setIp(String ip) {
		
		this.ip = ip;
	}
	
	
	public List<InterfaceVo> getInterfaces() {
		return interfaces;
	}
	public void setInterfaces(List<InterfaceVo> interfaces) {
		this.interfaces = interfaces;
	}
	@Override
	public String toString() {
		return "Host [ip=" + this.getIp() + ", name=" + host + ", items="
				+ items + ", status=" + status + ", hostid=" + hostid+ ", triggers=" + triggers + "]";
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getTriggers() {
		return triggers;
	}
	public void setTriggers(String triggers) {
		this.triggers = triggers;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}

}
