package com.taotao.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.taotao.common.constants.HttpClientConstant;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.portal.pojo.ItemInfo;
import com.taotao.portal.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	private Logger Log = Logger.getLogger(ItemServiceImpl.class);
	@Override
	public ItemInfo getItemBaseInfo(long itemId) {
		//调用rest服务。
		try {

			String doGet = HttpClientUtil.doGet(HttpClientConstant.BASE_INFO_URL+itemId);
			if (!doGet.isEmpty()) {
				TaotaoResult result = TaotaoResult.formatToPojo(doGet, ItemInfo.class);
				if (result.getStatus() == 200) {
					ItemInfo data = (ItemInfo) result.getData();
					return data;
				}
			}
		} catch (Exception e) {
			Log.error("Get item base Info is failed...");
		}
		return null;
	}
	/**
	 * 商品描述。
	 */
	@Override
	public String getItemDesc(long itemId) {
		try {
			//查询商品描述。
			String doGet = HttpClientUtil.doGet(HttpClientConstant.DESC_INFO_URL+itemId);
			if (!doGet.isEmpty()) {
				TaotaoResult formatToPojo = TaotaoResult.formatToPojo(doGet, TbItemDesc.class);
				if (formatToPojo.getStatus() ==200) {
					TbItemDesc data = (TbItemDesc) formatToPojo.getData();
					return data.getItemDesc();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;


	}
	/**
	 * 查询规格参数。
	 */
	@Override
	public String getItemParam(long itemId) {
		try {
			String doGet = HttpClientUtil.doGet(HttpClientConstant.PARAM_INFO_URL+itemId);
			if (!doGet.isEmpty()) {
				TaotaoResult formatToPojo = TaotaoResult.formatToPojo(doGet, TbItemParamItem.class);
				if (formatToPojo.getStatus() == 200) {
					TbItemParamItem data = (TbItemParamItem) formatToPojo.getData();
					String paramData = data.getParamData();
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

		} catch (Exception e) {
			Log.error("Search Item param is failed ...   ");
		}
		return "";

	}

}
