package com.taotao.controller;

import java.util.concurrent.LinkedBlockingDeque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentManagerService;

/**
 * 内容管理。
 * @author Administrator
 *
 */
@Controller
public class ContentManagerController {
	@Autowired
	private ContentManagerService contentManagerService;
	
	@RequestMapping("/content/query/list")
	@ResponseBody
	public EUDataGridResult getContentManager(Long categoryId,int page,int rows)
	{
		EUDataGridResult contentList = contentManagerService.getContentList(categoryId, page, rows);
		return contentList;
	}
	@RequestMapping("/content/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content)
	{
		return contentManagerService.insertContent(content);
	}
}
