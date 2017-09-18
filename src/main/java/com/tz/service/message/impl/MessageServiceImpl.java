/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.message
 * IMessageService.java
 * 创建人:黄辉业同学 
 * 时间：2015年12月01日 00:54:40
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.bean.Message;
import com.tz.bean.TzParams;
import com.tz.dao.message.IMessageMapper;
import com.tz.service.message.IMessageService;
import com.tz.util.TmStringUtils;

/**
 * 信息管理serviceImpl
 * IMessageService
 * 创建人:黄辉业同学 
 * 时间：2015年12月01日 00:54:40
 * @version 1.0.0
 * 
 */
@Service
public class MessageServiceImpl implements IMessageService{

	@Autowired
	private IMessageMapper messageMapper;
	
	@Override
	public List<Message> findMessages(TzParams params){
		if(TmStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return messageMapper.findMessages(params);
	}
	
	@Override
	public int count(TzParams params){
		return messageMapper.count(params);
	}

	@Override
	public Message get(Integer id) {
		return messageMapper.get(id);
	}

	@Override
	public int save(Message message) {
		return messageMapper.save(message);
	}

	@Override
	public int update(Message message) {
		return messageMapper.update(message);
	}

	@Override
	public int delete(TzParams params) {
		return messageMapper.delete(params);
	}
}
