package com.taotao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.pojo.TbItemParamItemExample.Criteria;
import com.taotao.service.ItemParamItemService;
/**展示商品规格参数。
 * 
 * @author Administrator
 *
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {
	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper;
	@Override
	public String getItemParamById(long itemId) {
		TbItemParamItemExample example = new TbItemParamItemExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andItemIdEqualTo(itemId);
		List<TbItemParamItem> selectByExample = tbItemParamItemMapper.selectByExampleWithBLOBs(example);
		if(selectByExample.size()==0 || selectByExample.isEmpty())
		{
			return "";
		}
		//取规格参数。	
		TbItemParamItem tbItemParamItem = selectByExample.get(0);
		String paramData = tbItemParamItem.getParamData();
		//生成html
		//参数转换成java对象。
		List<Map> jsonToList = JsonUtils.jsonToList(paramData, Map.class);
		StringBuffer sb=new StringBuffer();
		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width =\"100%\" border=\"1\" class=\"Ptable\">\n" );
		sb.append("	<tbody>\n" );
		for(Map m1:jsonToList)
		{
			sb.append("		<tr>\n" );
			sb.append("			<th class=\"tdTitle\" colspan = \"2\">"+m1.get("group")+"</th>\n" );
			sb.append("		</tr>\n" );
			List<Map> m2 = (List<Map>) m1.get("params");
			for(Map map	 : m2)
			{
				sb.append("		<tr>\n" );
				sb.append("			<td class=\"tdTitle\" >"+map.get("k")+"</td>\n" );
				sb.append("			<td>"+map.get("v")+"</td>\n" );
				sb.append("		</tr>\n" );
			}
		}
		sb.append("	</tbody>\n" );
		sb.append("</table>");
		return sb.toString();

	}

}
