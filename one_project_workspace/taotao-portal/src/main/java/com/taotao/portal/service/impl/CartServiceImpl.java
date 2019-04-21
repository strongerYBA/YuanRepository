package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.taotao.common.constants.HttpClientConstant;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;
/**
 * 添加购物车商品。
 * @author Administrator
 *
 */
@Service
public class CartServiceImpl implements CartService {

	@Override
	public TaotaoResult addCartItem(HttpServletRequest request,
			HttpServletResponse response,long itemId, int num) {
		CartItem cartItem = null;
		//取购物车的商品信息列表。从cookie中获取。
		List<CartItem> cartItemList = getCartItemList(request);
		//判断商品列表中是否存在此商品。
		for (CartItem item : cartItemList) {
			if (itemId == item.getId()) {
				//增加商品数量。
				item.setNum(item.getNum()+num);
				cartItem = item;
				break;
			}
		}
		//取商品信息。
		if (cartItem == null) {
			cartItem = new CartItem();
			//根据商品id。查询商品基本信息。
			String json = HttpClientUtil.doGet(HttpClientConstant.BASE_INFO_URL+itemId);
			TaotaoResult formatToPojo = TaotaoResult.formatToPojo(json, TbItem.class);
			if (formatToPojo.getStatus() == 200) {
				TbItem tbItem = (TbItem) formatToPojo.getData();
				cartItem.setId(tbItem.getId());
				cartItem.setImage(tbItem.getImage()==null?"":tbItem.getImage().split(",")[0]);
				cartItem.setNum(num);
				cartItem.setPrice(tbItem.getPrice());
				cartItem.setTitle(tbItem.getTitle());

			}
		}
		//添加到购物车列表。
		cartItemList.add(cartItem);
		//把购物车列表写入cookie。
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(cartItemList), true);
		return TaotaoResult.ok();
	}
	private List<CartItem> getCartItemList(HttpServletRequest request)
	{
		//从cookie中取商品列表。
		String json = CookieUtils.getCookieValue(request, "TT_CART", true);
		if (json == null) {
			return new ArrayList<>();
		}
		try {
			//把json转换成商品列表。
			List<CartItem> jsonToList = JsonUtils.jsonToList(json, CartItem.class);
			return jsonToList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	/**
	 * 获取购物车列表。
	 */
	@Override
	public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<CartItem> cartItemList = getCartItemList(request);
		return cartItemList;
	}
	/**
	 * 删除购物车。
	 */
	@Override
	public TaotaoResult deleteCartItem(long itemId,HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		//从cookie中取出商品信息。
		List<CartItem> cartItemList = getCartItemList(request);
		for (CartItem cartItem : cartItemList) {
			if (cartItem.getId() == itemId) {
				cartItemList.remove(cartItem);
				break;
			}
		}
		//重新写入cookie
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(cartItemList), true);
		return TaotaoResult.ok();
	}
}
