package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.constants.HttpClientConstant;
import com.taotao.common.constants.RedisConstant;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.service.ContentManagerService;
@Service
public class ContentManagerServiceImpl implements ContentManagerService
{
	@Autowired
	private TbContentMapper tbContentMapper;
	private String URL = HttpClientConstant.REST_BASE_URL;
	public EUDataGridResult getContentList(long categoryId, int page, int rows) {
		// 查询分类列表。
		TbContentExample example = new TbContentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCategoryIdEqualTo(categoryId);
		PageHelper.startPage(page, rows);
		List<TbContent> selectByExample = tbContentMapper.selectByExample(example);
		//创建一个返回值对象。
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(selectByExample);
		//取记录总条数》
		PageInfo<TbContent> info = new PageInfo<>(selectByExample);
		long total = info.getTotal();
		result.setTotal(total);
		return result;
	}
	public TaotaoResult insertContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		tbContentMapper.insert(content);
		//添加缓存同步逻辑。调用服务层服务。采用HTTPClient进行远程服务调用。
		try {
			HttpClientUtil.doGet(URL+content.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TaotaoResult.ok();
	}

}
