/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.web.message
 * MessageController.java
 * 创建人:黄辉业同学
 * 时间：2015年12月01日 00:54:40
 * 2015潭州教育公司-版权所有
 */
package com.tz.web.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tz.bean.Message;
import com.tz.bean.TzParams;
import com.tz.service.message.IMessageService;

/**
 * 信息管理web
 * MessageController
 * 创建人:黄辉业同学
 * 时间：2015年12月01日 00:54:40
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/message")
public class MessageController {
	
	@Autowired
	private IMessageService messageService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(TzParams params){
		return "message/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(TzParams params){
		ModelAndView modelAndView = new ModelAndView();
		List<Message> messages = messageService.findMessages(params);
		int count = messageService.count(params);
		modelAndView.setViewName("message/template");
		modelAndView.addObject("datas",messages);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
}
