package com.ai.amc.core.vo;

import java.io.Serializable;

public class EsDockerLogVo implements Comparable<EsDockerLogVo> ,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String timeStamp;
	private String type;
	private String logger;
	private String payload;
	private String envVersion;
	private String pId;
	private String hostName;
	private String containerId;
	private String containerName;
	private String containerImage;
	private String uuid;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLogger() {
		return logger;
	}
	public void setLogger(String logger) {
		this.logger = logger;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getEnvVersion() {
		return envVersion;
	}
	public void setEnvVersion(String envVersion) {
		this.envVersion = envVersion;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getContainerId() {
		return containerId;
	}
	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}
	public String getContainerName() {
		return containerName;
	}
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}
	public String getContainerImage() {
		return containerImage;
	}
	public void setContainerImage(String containerImage) {
		this.containerImage = containerImage;
	}
	@Override
	public int compareTo(EsDockerLogVo o) {
		if(this.timeStamp.compareTo(o.timeStamp) == 0){
			return this.id.compareTo(o.id);
		}else{
			return this.timeStamp.compareTo(o.timeStamp);
		}
	}
	@Override
	public String toString() {
		return "EsDockerLog [id=" + id +",timeStamp="+timeStamp+ ", type=" + type + ", payload="
				+ payload + ", containerName=" + containerName+containerId + ", hostName=" + hostName+ ", containerImage=" + containerImage +"]";

	}
	
}
