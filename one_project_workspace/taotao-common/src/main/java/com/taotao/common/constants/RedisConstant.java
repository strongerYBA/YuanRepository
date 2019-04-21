package com.taotao.common.constants;

public final class RedisConstant
{
	/**
	 * 内容分类管理redis中的hkey.
	 */
	public static final String INDEX_CONTENT_REDIS_KEY = "index_content_redis_key";
	
	/**
	 * 基础key。
	 */
	public static final String ITEM_REDIS_KEY = "ITEM_REDIS_KEY";
	/**
	 * 过去时间。expire
	 */
	public static final int ITEM_REDIS_KEY_EXPIRE = 86400;
	/**
	 *用户信息。key
	 */
	public static final String USER_INFO_KEY = "USER_INFO_KEY";
	/**
	 * 订单号生成key
	 */
	public static final String ORDER_KEY = "ORDER_KEY";
	/**
	 * 订单明细生成key
	 */
	public static final String ORDER_ITEM_KEY = "ORDER_ITEM_KEY";
}
