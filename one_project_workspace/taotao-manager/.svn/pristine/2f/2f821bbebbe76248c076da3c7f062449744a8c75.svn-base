package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.service.ItemParamService;
/**
 * 查询规格参数。
 * @author Administrator
 *
 */
@Service
public class ItemParamServiceImpl implements ItemParamService
{
	private Logger logger = Logger.getLogger(ItemParamServiceImpl.class);
	@Autowired
	private TbItemParamMapper tbItemParamMapper;

	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		TbItemParamExample example = new TbItemParamExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> selectByExample = tbItemParamMapper.selectByExampleWithBLOBs(example);
		if(!selectByExample.isEmpty()&&selectByExample.size()>0)
		{
			logger.error("查询商品分类成功！！！");
			return TaotaoResult.ok(selectByExample.get(0));
		}
		logger.error("改商品规格已经添加！！！");
		return TaotaoResult.ok();
	}
	/**
	 * 插入商品分类。
	 */
	@Override
	public TaotaoResult insertItemParam(TbItemParam tbItemParam) {
		//补全。
		tbItemParam.setCreated(new Date());
		tbItemParam.setUpdated(new Date());
		tbItemParamMapper.insert(tbItemParam);
		return TaotaoResult.ok();
	}
	
}
