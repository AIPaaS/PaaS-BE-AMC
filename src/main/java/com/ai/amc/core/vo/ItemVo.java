package com.ai.amc.core.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String itemid;
	private String key_;
	private String name;
	private Long lastclock;
	private String newlastclockDate;
	private String lastvalue;
	private String units;
	private String value_type;//0 - numeric float; 1 - character; 2 - log; 3 - numeric unsigned; 4 - text.
	private String status;// 0 - (default) enabled item; 1 - disabled item.
	private String state;//  0 - (default) normal; 1 - not supported.   是否支持    
	private List<String> appnameList;
	private List<Application>  applications;
	
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getKey_() {
		return key_;
	}
	public void setKey_(String key_) {
		this.key_ = key_;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastvalue() {
		return lastvalue;
	}
	public void setLastvalue(String lastvalue) {
		this.lastvalue = lastvalue;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Application> getApplications() {
		return applications;
	}
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
	@Override
	public String toString() {
		return "item [id=" + itemid +",value_type="+value_type+ ", key_=" + key_ + ", name="
				+ name + ", lastvalue=" + lastvalue+units + ", status=" + status+ ", state=" + state + ", appame=" + this.getAppnameList()+ ",newlastclockDate="+this.getNewlastclockDate()+"]";
	}
	public List <String> getAppnameList() {
		List <String> aa = new ArrayList<String>();
		int a = applications.size();
		for (int i = 0; i < a; i++) {
			aa.add(this.getApplications().get(i).getName());
		}
	//	aa.add(this.getApplications().get(0).getName());
		return aa;
	}
	public void setAppnameList(List<String> appnameList) {
		this.appnameList = appnameList;
	}
	public Long getLastclock() {
		return lastclock;
	}
	public void setLastclock(Long lastclock) {
		this.lastclock = lastclock;
	}
	public String getNewlastclockDate() 
	{
		Long ssssLong =this.getLastclock();
		Date swsDate =new Date(ssssLong*1000);
		SimpleDateFormat bartDateFormat =  new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");  
		return bartDateFormat.format(swsDate);
	}
	public void setNewlastclockDate(String newlastclockDate) {
		this.newlastclockDate = newlastclockDate;
	}
	public String getValue_type() {
		return value_type;
	}
	public void setValue_type(String value_type) {
		this.value_type = value_type;
	}
}
