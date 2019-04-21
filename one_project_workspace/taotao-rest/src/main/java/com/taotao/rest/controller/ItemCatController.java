package com.taotao.rest.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
/**
 * 商品分类列表。
 * @author Administrator
 *
 */
@Controller
public class ItemCatController {
	private Logger log = Logger.getLogger(ItemCatController.class);
	@Autowired
	private  ItemCatService itemCatService;
	//	@RequestMapping(value="/itemcat/list",produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	//	@ResponseBody
	//	public String getItemCatLists(String callback)//入参。方法名称。
	//	{
	//		CatResult itemCatList = itemCatService.getItemCatList();
	//		
	//		//把对象转换成字符串。
	//		String objectToJson = JsonUtils.objectToJson(itemCatList);
	//		log.error(objectToJson);
	//		//拼装返回值。
	//		String result = callback+"("+objectToJson+");";
	//		return result;
	//	}
	@RequestMapping(value="/itemcat/list",produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public Object getItemCatLists(String callback)//入参。方法名称。
	{
		CatResult itemCatList = itemCatService.getItemCatList();
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(itemCatList);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}
}
