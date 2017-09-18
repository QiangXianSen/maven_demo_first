/**
 * kekeblog系统平台
 * moonvip_admin
 * com.tz.dao.content
 * IContentMapper.java
 * 创建人:xuchengfei 
 * 时间：2015年11月28日-下午10:47:13 
 * 2015潭州教育公司-版权所有
 */
package com.tz.dao.content;

import java.util.List;

import com.tz.bean.Content;
import com.tz.bean.TzParams;

/**
 * 
 * IContentMapper
 * 创建人:xuchengfei 
 * 时间：2015年11月28日-下午10:47:13 
 * @version 1.0.0
 * 
 */
public interface IContentMapper {

	/**
	 * 
	 * com.tz.dao.content 
	 * 方法名：findContents
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年11月28日-下午10:50:32 
	 * @param params
	 * @return 
	 * 返回类型：List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Content> findContents(TzParams params);
	
	/**
	 * 求总数
	 * com.tz.dao.content 
	 * 方法名：count
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年11月30日-下午11:30:11 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(TzParams params);
	
	/**
	 * 
	 * com.tz.dao.content 
	 * 方法名：findContents
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年11月28日-下午10:50:32 
	 * @param params
	 * @return 
	 * 返回类型：List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	public Content get(Integer id);
	
	
	/**
	 * 保存内容
	 * com.tz.dao.content 
	 * 方法名：save
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年11月29日-上午12:58:05 
	 * @param content
	 * @return 
	 * 返回类型：Content
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Content content);
	
	/**
	 * 更新内容
	 * com.tz.dao.content 
	 * 方法名：update
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年11月29日-上午12:58:42 
	 * @param content
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Content content);
	
	/**
	 * 删除内容
	 * com.tz.dao.content 
	 * 方法名：delete
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年11月29日-上午12:58:48 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(TzParams params);
	
}
