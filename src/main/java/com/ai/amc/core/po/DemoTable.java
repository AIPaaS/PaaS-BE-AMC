package com.ai.amc.core.po;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

/**
 * 与数据库操作的字段一致
 * @author archer
 *
 */
@Repository(value = "user") 
public class DemoTable implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String account;
	
	private String dname;
	
	private String password;
	
	private String token;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

	
}
