/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.service.message
 * IMessageService.java
 * 创建人:黄辉业同学 
 * 时间：2015年12月01日 00:54:40
 * 2015潭州教育公司-版权所有
 */
package com.tz.service.message;

import java.util.List;

import com.tz.bean.Message;
import com.tz.bean.TzParams;

/**
 * 
 * IMessageService
 * 创建人:黄辉业同学 
 * 时间：2015年12月01日 00:54:40
 * @version 1.0.0
 * 
 */
public interface IMessageService {


	/**
	 * 
	 * com.tz.service.message 
	 * 方法名：findMessages
	 * 创建人：黄辉业同学 
	 * 手机号码:546476456
	 * 时间：2015年12月01日 00:54:40
	 * @param params
	 * @return 
	 * 返回类型：List<Message>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Message> findMessages(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.message 
	 * 方法名：count
	 * 创建人：黄辉业同学 
	 * 手机号码:546476456
	 * 时间：2015年12月01日 00:54:40
	 * @param id
	 * @return 
	 * 返回类型：List<Message>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.service.message 
	 * 方法名：findMessages
	 * 创建人：黄辉业同学 
	 * 手机号码:546476456
	 * 时间：2015年12月01日 00:54:40
	 * @param params
	 * @return 
	 * 返回类型：List<Message>
	 * @exception 
	 * @since  1.0.0
	 */
	public Message get(Integer id);
	
	/**
	 * 保存信息管理
	 * com.tz.service.message 
	 * 方法名：save
	 * 创建人：黄辉业同学 
	 * 手机号码:546476456
	 * 时间：2015年12月01日 00:54:40 
	 * @param message
	 * @return 
	 * 返回类型：Message
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Message message);
	
	/**
	 * 更新信息管理
	 * com.tz.service.message 
	 * 方法名：update
	 * 创建人：黄辉业同学 
	 * 手机号码:546476456
	 * 时间：2015年12月01日 00:54:40
	 * @param message
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Message message);
	
	/**
	 * 删除信息管理
	 * com.tz.service.message 
	 * 方法名：delete
	 * 创建人：黄辉业同学 
	 * 手机号码:546476456
	 * 时间：2015年12月01日 00:54:40
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
}
