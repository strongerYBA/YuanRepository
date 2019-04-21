package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.portal.service.ContentService;

/**
 * 首页展示。
 * @author Administrator
 *
 */
@Controller
public class IndexController {

	@Autowired
	private ContentService contentService;
	@RequestMapping("/index")
	public String showIndex(Model model)
	{
		String contentList = contentService.getContentList();
		model.addAttribute("ad1", contentList);
		return "index";
	}
	@RequestMapping(value ="/httpclient/post", method=RequestMethod.POST)
	public TaotaoResult testPost()
	{
		return TaotaoResult.ok();
	}
}
