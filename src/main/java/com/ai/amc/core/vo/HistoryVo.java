package com.ai.amc.core.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemid;
    private Long clock;
    private String newclock;
    private String value;
    private Long ns;
    public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public Long getClock() {
		return clock;
	}
	public void setClock(Long clock) {
		this.clock = clock;
	}
	public String getNewclock() {
		Long oldc =this.getClock();
		Date newc = new Date(oldc*1000);
		SimpleDateFormat bartDateFormat =  new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		return bartDateFormat.format(newc);
	}
	public void setNewclock(String newclock) {
		this.newclock = newclock;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Long getNs() {
		return ns;
	}
	public void setNs(Long ns) {
		this.ns = ns;
	}
	@Override
	public String toString() {
		return "History [itemid=" + itemid + ", clock=" + clock + ", newclock="
				+ this.getNewclock() + ", value=" + value  + "]";
	}
	
}
