/**
 * tzdesk系统平台
 * moovip_admin
 * com.tz.web
 * IndexController.java
 * 创建人:xuchengfei 
 * 时间：2015年11月23日-下午11:46:36 
 * 2015潭州教育公司-版权所有
 */
package com.tz.web;

import static com.tz.util.TzConstant.SESSION_USER;
import static com.tz.util.TzConstant.SESSION_USER_USERNAME;
import net.sf.ehcache.CacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.bean.AdminUser;
import com.tz.bean.TzParams;
import com.tz.core.BaseController;
import com.tz.service.user.IUserService;
import com.tz.util.TmStringUtils;
/**
 * 
 * IndexController
 * 创建人:xuchengfei 
 * 时间：2015年11月23日-下午11:46:36 
 * @version 1.0.0
 * 
 */
@Controller
public class LoginController extends BaseController{
	
	@Autowired
	private IUserService  service;
	

	@RequestMapping("/login")
	public String login(){
		return "login";
	}

	/**
	 * 登陆方法
	 * com.tz.web 
	 * 方法名：logined
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2015年11月24日-上午1:13:34 
	 * @param params
	 * @return 
	 * 返回类型：String
	 * @exception 
	 * @since  1.0.0
	 */
	@ResponseBody
	@RequestMapping(value="/logined",method=RequestMethod.POST)
	public String logined(TzParams params){
		if(params!=null){
			if(TmStringUtils.isNotEmpty(params.getAccount()) && TmStringUtils.isNotEmpty(params.getPassword())){
				params.setPassword(TmStringUtils.md5Base64(params.getPassword()));
				AdminUser user = service.getLogin(params);
				if(user!=null){
					if(user.getForbiden()==0){
						return "forbiden";
					}else{
						session.setAttribute(SESSION_USER, user);
						session.setAttribute(SESSION_USER_USERNAME, user.getUsername());
						return "success";
					}
				}else{
					return "fail";
				}
			}else{
				return "null";//请输入账号和密码
			}
		}else{
			return "error";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(){
		session.invalidate();
		return "redirect:login";
	}
}