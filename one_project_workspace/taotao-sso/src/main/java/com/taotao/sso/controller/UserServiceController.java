package com.taotao.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbUser;
import com.taotao.sso.service.UserService;
/**
 * 用户controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserServiceController {
	private Logger Log  = Logger.getLogger(UserServiceController.class);
	@Autowired
	private UserService userService;
	/**
	 * 校验参数。
	 * @param param
	 * @param type
	 * @return
	 */
	@RequestMapping("/check/{param}/{type}")
	@ResponseBody
	public Object checkData(@PathVariable String param,@PathVariable Integer type,String callback)
	{
		TaotaoResult result = null;
		Log.error("Check Data is start ... type = {},"+type);
		//参数有效性校验。
		if (StringUtils.isBlank(param)) {
			result = TaotaoResult.build(400, "校验内容不能为空！！！");
		}
		if (type == null) {
			result = TaotaoResult.build(400, "校验类型不能为空！！！");
		}
		if (type !=1 && type != 2 && type != 3 ) {
			result = TaotaoResult.build(400, "校验内容错误！！！");
		}
		//校验出错。支持jsonp
		if (null != result) {
			if (null != callback) {
				MappingJacksonValue value =  new MappingJacksonValue(result);
				value.setJsonpFunction(callback);
				return value;
			}
			else
			{
				return result;
			}
		}
		//调用服务。
		try {
			TaotaoResult chechData = userService.chechData(param , type);
			Log.error("Check Data is succeed ... status = {},"+chechData.getStatus());
			result = chechData;
		} catch (Exception e) {
			result = TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		//支持jsonp。
		if (null != callback) {
			MappingJacksonValue value =  new MappingJacksonValue(result);
			value.setJsonpFunction(callback);
			return value;
		}
		else
		{
			return result;//没有回调。直接返回。
		}
	}
	/**
	 *创建用户。
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createUser(TbUser user)
	{
		try {
			TaotaoResult createUser = userService.createUser(user);
			return createUser;
		} catch (Exception e) {
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult userLogin(String username,String password
			,HttpServletRequest request,HttpServletResponse response)
	{
		try {

			TaotaoResult userLogin = userService.userLogin(username, password,request,response);
			return userLogin;
		} catch (Exception e) {
			// TODO: handle exception
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	/**
	 * 获取token。
	 * @param token
	 * @return
	 */
	@RequestMapping("/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token,String callback)
	{
		TaotaoResult result = null;
		try {

			TaotaoResult userByToken = userService.getUserByToken(token);
			result = userByToken;
		} catch (Exception e) {
			result = TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		//判断是否为jsonp调用，
		if (StringUtils.isBlank(callback)) {
			return result;
		}

		else
		{
			MappingJacksonValue value = new MappingJacksonValue(result);
			value.setJsonpFunction(callback);
			return value;
		}
	}
}
