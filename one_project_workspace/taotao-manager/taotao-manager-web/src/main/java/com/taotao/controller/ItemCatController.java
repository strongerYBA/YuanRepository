package com.taotao.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.service.ItemCatService;
/**
 * 商品分类管理controller。
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController 
{
	private Logger Logger  = LoggerFactory.getLogger(ItemCatController.class);
	@Autowired
	private ItemCatService itemCatService;
	@RequestMapping("/list")
	@ResponseBody
	public List categoryList(@RequestParam(value="id",defaultValue="0")Long parentId)
	{
//		List catList = new ArrayList<>();
		//查询数据库。
		List<EUTreeNode>  list = itemCatService.getCatList(parentId);
//		for (EUTreeNode euTreeNode : list)
//		{
//			Map node  = new HashMap();
//			node.put("id", euTreeNode.getId());
//			node.put("text", euTreeNode.getText());
//			//如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
//			node.put("state", euTreeNode.getState());
//			catList.add(node);
//		}
		return list;
	}
}
