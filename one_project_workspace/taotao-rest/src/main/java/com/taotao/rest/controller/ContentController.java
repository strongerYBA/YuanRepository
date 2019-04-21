package com.taotao.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.rest.service.ContentService;

/**
 * 内容列表。
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	@RequestMapping("/list/contentCategoryId")
	public TaotaoResult getContentList(@PathVariable long contentCategoryId)
	{
		try {
			
			List<TbContent> contentList = contentService.getContentList(contentCategoryId);
			return TaotaoResult.ok(contentList);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, 	ExceptionUtil.getStackTrace(e));
		}
	}
}
