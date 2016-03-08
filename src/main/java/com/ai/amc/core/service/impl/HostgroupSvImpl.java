package com.ai.amc.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.amc.core.dao.zabbixapi.HostgroupZabbixApi;
import com.ai.amc.core.service.IHostgroupSv;
import com.ai.amc.core.vo.HostgroupVo;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.LLOAD;
@Repository
@Transactional
public class HostgroupSvImpl implements IHostgroupSv {

	@Autowired
	private HostgroupZabbixApi hostgroupZabbixApi;
	
	@Override
	public List<HostgroupVo> getgroupByAuth() {
		 List<HostgroupVo> ss =null;
         String string = hostgroupZabbixApi.getgroupByAuth().toString();
         //将json对象转换成java对象
         ss = JSON.parseArray(string, HostgroupVo.class);
		return ss;
	}
	@Override
	public List<HostgroupVo> getgroupByType() {
		 List<HostgroupVo> ss =null;
         String string = hostgroupZabbixApi.getgroupByAuth().toString();
         //将json对象转换成java对象
         ss = JSON.parseArray(string, HostgroupVo.class);
         //判断主机组的类型 1为虚机组 0为容器
//         int ll = 0;
//         int isnot = 0;
//         for (int i = 0; i < ss.size(); i++) {
//			ll = Integer.valueOf(ss.get(i).getGroupid());
//			isnot =Integer.valueOf(hostgrouptypeMapper.selectByGroupid(ll).getType());
//			if(isnot==1)
//				ss.remove(i);
//		}
         
		return ss;
	}

}
