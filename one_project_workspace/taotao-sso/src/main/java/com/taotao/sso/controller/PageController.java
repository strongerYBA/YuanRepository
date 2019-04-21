package com.taotao.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller。
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/page")
public class PageController {
	/**
	 * 注册功能的实现。
	 * @return
	 */
	@RequestMapping("/register")
	public String showRegister()
	{
		return "register";
	}
	@RequestMapping("/login")
	public String showLogin(String redirect,Model model)
	{
		model.addAttribute("redirect", redirect);//加上回调url。
		return "login";
	}
}
