package com.taotao.controller;

import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 商品内容管理。
 * @author Administrator
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.service.ContentCategoryService;
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	private Logger Logger  = LoggerFactory.getLogger(ContentCategoryController.class);
	@Autowired
	private ContentCategoryService contentCategoryService;
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCategoryList(@RequestParam(value="id",defaultValue="0")long parentId)
	{
		List<EUTreeNode> categoryList = contentCategoryService.getCategoryList(parentId);
		return categoryList;
		
	}
	/**
	 * 添加分类。
	 * @return
	 */
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult insertContentCategory(long parentId,String name)
	{
		Logger.error("Insert ContentCategory,parentId = {}"+parentId +"   name = {},"+name);
		TaotaoResult addCategory = contentCategoryService.addCategory(parentId, name);
		return addCategory;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContentCategory(Long parentId,Long id)
	{
		Logger.error("Delete ContentCategory,parentId = {}"+parentId +"   id = {},"+id);
		TaotaoResult deleteCategory = contentCategoryService.deleteCategory(parentId, id);
		return null;
	}
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult updateContentCategory(long id,String name)
	{
		TaotaoResult updateCategory = contentCategoryService.updateCategory(id, name);
		return updateCategory;
	}
}
