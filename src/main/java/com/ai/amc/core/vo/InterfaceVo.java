package com.ai.amc.core.vo;

import java.io.Serializable;

public class InterfaceVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String port;
	private String ip;
	private String interfaceid;
	private String dns;
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getInterfaceid() {
		return interfaceid;
	}
	public void setInterfaceid(String interfaceid) {
		this.interfaceid = interfaceid;
	}
	public String getDns() {
		return dns;
	}
	public void setDns(String dns) {
		this.dns = dns;
	}
	

}
