package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService
{
	private Logger Logger  = LoggerFactory.getLogger(ItemCatServiceImpl.class);
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		//创建查询条件。
		TbItemCatExample example = new TbItemCatExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		//根据条件查询。
		List<TbItemCat> selectByExample = tbItemCatMapper.selectByExample(example);
		//转换成TreeNode,List。
		List<EUTreeNode> list = new ArrayList<>();
		for (TbItemCat tbItemCat : selectByExample) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			list.add(node);
		}
		return list;
	}

}
