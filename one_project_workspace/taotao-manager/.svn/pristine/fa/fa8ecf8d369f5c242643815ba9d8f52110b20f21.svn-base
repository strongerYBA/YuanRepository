package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.common.utils.NoSuccessedException;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;
/**
 * 商品管理Service。
 * @author Administrator
 *
 */
@Service
public class ItemServiceImpl implements ItemService
{
	private Logger logger  = LoggerFactory.getLogger(ItemServiceImpl.class);
	@Autowired
	private TbItemMapper tbItemMapper;
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper;
	@Override
	public TbItem getItemById(long itemId) {
		TbItemExample example = new TbItemExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(itemId);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		if(list !=null && list.size()>0)
		{
			return list.get(0);
		}
		return null;
	}
	/**
	 * 商品列表查询。
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表。
		TbItemExample example = new TbItemExample();
		//分页处理。
		PageHelper.startPage(page,rows);
		List<TbItem> selectByExample = tbItemMapper.selectByExample(example);
		//创建一个返回值对象。
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(selectByExample);
		//取记录总条数。
		PageInfo<TbItem> info = new PageInfo<>(selectByExample);
		long total = info.getTotal();
		result.setTotal(total);
		return result;
	}
	/**
	 * 添加商品。
	 * @throws NoSuccessedException 
	 */
	@Override
	public TaotaoResult creatItem(TbItem item,String desc,String itemParam) throws NoSuccessedException {
		//Item补全。
		//1.id
		Long itemId = IDUtils.genItemId();
		item.setId(itemId);
		item.setStatus((byte)1);//1.正常。2.下架。3.删除。
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//插入到数据库。。
		tbItemMapper.insert(item);	
		TaotaoResult insertItemDesc = insertItemDesc(itemId, desc);
		//捕获异常。用于未能添加成功时。spring进行事务回退。
		if(insertItemDesc.getStatus() != 200)
		{
			throw new NoSuccessedException("商品详情未添加成功!!!");
		}
		//添加规格参数呢。
		TaotaoResult insertItemParam = insertItemParam(itemId, itemParam);
		if(insertItemParam.getStatus() != 200)
		{
			throw new NoSuccessedException("商品详情未添加成功!!!");
		}
		logger.error("添加商品详情成功！！！");
		return TaotaoResult.ok();
	}
	private TaotaoResult insertItemDesc(Long itemId, String des)
	{
		TbItemDesc desc = new TbItemDesc();
		desc.setItemId(itemId);
		desc.setItemDesc(des);
		desc.setCreated(new Date());
		desc.setUpdated(new Date());
		tbItemDescMapper.insert(desc);
		return TaotaoResult.ok();
	}
	/**
	 * 添加规格参数。
	 * @param itemId
	 * @param itemParam
	 * @return
	 */
	private TaotaoResult insertItemParam(Long itemId,String itemParam)
	{
		//创建一个pojo
		TbItemParamItem tbItemParamItem = new TbItemParamItem();
		tbItemParamItem.setItemId(itemId);
		tbItemParamItem.setParamData(itemParam);
		tbItemParamItem.setCreated(new Date());
		tbItemParamItem.setUpdated(new Date());
		tbItemParamItemMapper.insert(tbItemParamItem);
		return TaotaoResult.ok();
		
	}
}
