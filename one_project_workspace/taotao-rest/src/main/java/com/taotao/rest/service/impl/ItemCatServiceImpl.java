package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Override
	public CatResult getItemCatList() {
		CatResult catResult = new CatResult();
		catResult.setData(getCatList(0));
		return catResult;
	}
	private List<?> getCatList(long parentId)
	{
		TbItemCatExample tbItemCatExample = new TbItemCatExample();
		Criteria createCriteria = tbItemCatExample.createCriteria();
		Criteria andIdEqualTo = createCriteria.andParentIdEqualTo(parentId);
		List<TbItemCat> selectByExample = tbItemCatMapper.selectByExample(tbItemCatExample);
		List resultList = new ArrayList<>();
		int count = 0;
		for (TbItemCat tbItemCat : selectByExample) {
			//判读是否为叶子节点。
			if(tbItemCat.getIsParent()){
				CatNode node = new CatNode();
				//第一层。
				if (parentId == 0) {
					node.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
				}
				else{
					node.setName(tbItemCat.getName());
				}
				node.setUrl("/products/"+tbItemCat.getId()+".html");
				node.setItem(getCatList(tbItemCat.getId()));//递归。
				resultList.add(node);
				count++;
				if (count>=14 && parentId == 0) {
					//第一层级，只取14条数据。
					break;
				}
			}
			//是叶子节点。
			else
			{
				resultList.add("/products/"+tbItemCat.getId()+".html|"+tbItemCat.getName());
			}
		}
		return resultList;
	}

}
