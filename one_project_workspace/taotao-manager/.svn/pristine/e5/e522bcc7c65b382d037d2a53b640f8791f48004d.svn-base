package com.taotao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 页面展示。
 * @author Administrator
 *
 */
@Controller
public class PageController
{
	private Logger Logger  = LoggerFactory.getLogger(PageController.class);
	/**
	 * 后台页面首页。
	 * @return
	 */
	@RequestMapping("/")
	public String indexShow()
	{
		return "index";
	}
	@RequestMapping("/{page}")
	public String pageShow(@PathVariable String page)
	{
		return page;
	}
}
