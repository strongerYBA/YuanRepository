package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

/**
 * 分页测试。
 * @author Administrator
 *
 */
public class TestPageHelper 
{
	@Test
	public void testPageHelper()
	{
		//创建一个spring容器。
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获得mapper的代理对象。
		TbItemMapper mapper = context.getBean(TbItemMapper.class);
		//执行查询。并分页。
		TbItemExample example = new TbItemExample();
		//分页处理。
		PageHelper.startPage(1, 10);//1页10条数据。
		List<TbItem> list = mapper.selectByExample(example);
		//取商品列表。
		for (TbItem tbItem :list)
		{
			System.out.println(tbItem.getTitle());
		}
		//取分頁信息。
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品信息:"+total);
	}
}