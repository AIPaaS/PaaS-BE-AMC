package com.ai.amc.core.vo;

import java.io.Serializable;


public class EventVo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int ID;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
}
