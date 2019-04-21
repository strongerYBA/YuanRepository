package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;
/**
 * 根据parentId查询内容分类列表。
 * @author Administrator
 *
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	private Logger Logger  = LoggerFactory.getLogger(ContentCategoryServiceImpl.class);
	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;
	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> selectByExample = tbContentCategoryMapper.selectByExample(example);
		List<EUTreeNode> list  = new ArrayList<>();
		for (TbContentCategory category : selectByExample) {
			//创建一个节点。
			EUTreeNode node = new EUTreeNode();
			node.setId(category.getId());
			node.setText(category.getName());
			node.setState(category.getIsParent()?"closed":"open");
			list.add(node);
		}
		return list;
	}
	/**
	 * 添加内容分类。
	 */
	@Override
	public TaotaoResult addCategory(long parentId, String name) {
		TbContentCategory category = new TbContentCategory();
		category.setName(name);
		category.setParentId(parentId);
		category.setIsParent(false);
		category.setStatus(1);//1正常，2删除。
		category.setSortOrder(1);
		category.setCreated(new Date());
		category.setUpdated(new Date());
		//添加。
		tbContentCategoryMapper.insert(category);
		//查看父节点。是否为true.
		TbContentCategory selectByPrimaryKey = tbContentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为true。
		if(!selectByPrimaryKey.getIsParent())
		{
			selectByPrimaryKey.setIsParent(true);
			//更新父节点。
			tbContentCategoryMapper.updateByPrimaryKey(selectByPrimaryKey);
		}
		return TaotaoResult.ok(category);
	}
	/**
	 * 删除分类。
	 */
	@Override
	public TaotaoResult deleteCategory(Long parentId, Long  id) {
		Logger.error("Delete ContentCategory start...");
		//子节点信息。
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(id);
		tbContentCategoryMapper.deleteByExample(example);
		//查询父节点，下所有的子节点信息。。
		if(parentId == null)
		{
			return TaotaoResult.ok();
		}
		TbContentCategoryExample example1 = new TbContentCategoryExample();
		Criteria createCriteria1 = example1.createCriteria();
		createCriteria1.andParentIdEqualTo(parentId);
		List<TbContentCategory> selectByExample = tbContentCategoryMapper.selectByExample(example1);
		//查询父节点信息。
		TbContentCategory selectByPrimaryKey = tbContentCategoryMapper.selectByPrimaryKey(parentId);
		//如果没有子节点。则父节点为false。
		if(selectByExample.isEmpty()||selectByExample.size()<=0)
		{
			selectByPrimaryKey.setIsParent(false);
			//更新。
			tbContentCategoryMapper.updateByPrimaryKey(selectByPrimaryKey);
		}
		Logger.error("Delete ContentCategory end...");
		return TaotaoResult.ok();
	}
	/**
	 * 更新操作。
	 */
	@Override
	public TaotaoResult updateCategory(Long id, String name) {
		TbContentCategory selectByPrimaryKey = tbContentCategoryMapper.selectByPrimaryKey(id);
		TbContentCategory category = new TbContentCategory();
		category.setName(name);
		category.setId(id);
		category.setCreated(new Date());
		category.setIsParent(selectByPrimaryKey.getIsParent());
		category.setParentId(selectByPrimaryKey.getParentId());
		category.setSortOrder(selectByPrimaryKey.getSortOrder());
		category.setStatus(selectByPrimaryKey.getStatus());
		category.setUpdated(new Date());
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(id);
		tbContentCategoryMapper.updateByExample(category, example);
		return TaotaoResult.ok();
	}

}
