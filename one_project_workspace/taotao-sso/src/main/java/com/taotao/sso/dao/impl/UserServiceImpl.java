package com.taotao.sso.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.taotao.common.constants.RedisConstant;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.sso.dao.JedisClient;
import com.taotao.sso.service.UserService;
/**
 * 检查数据是否可用。
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper tbUserMapper;
	@Autowired
	private JedisClient jedisClient;
	@Override
	public TaotaoResult chechData(String content, Integer type) {
		// TODO Auto-generated method stub
		TbUserExample example = new TbUserExample();
		Criteria createCriteria = example.createCriteria();
		//对数据进行校验：1.2.3分别代表：username,phone,email.
		if (1==type) {
			createCriteria.andUsernameEqualTo(content);
		}
		else if (2==type) {
			createCriteria.andPhoneEqualTo(content);
		}
		else {

			createCriteria.andEmailEqualTo(content);
		}
		List<TbUser> selectByExample = tbUserMapper.selectByExample(example);
		if (selectByExample == null || selectByExample.size()==0) {
			return TaotaoResult.ok(true);//没有值，说明没有注册过。
		}
		return TaotaoResult.ok(false);//有值。说明已经注册过了。
	}
	/**
	 * 用户注册。	
	 */
	@Override
	public TaotaoResult createUser(TbUser user) {
		// TODO Auto-generated method stub
		user.setUpdated(new Date());
		user.setCreated(new Date());
		//md5加密。
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		tbUserMapper.insert(user);
		return TaotaoResult.ok();
	}
	/**
	 * 用户登录。
	 */
	@Override
	public TaotaoResult userLogin(String username, String password
			,HttpServletRequest request,HttpServletResponse response) {
		TbUserExample example = new TbUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameEqualTo(username);
		//执行查询。
		List<TbUser> selectByExample = tbUserMapper.selectByExample(example);
		//如果没有此用户名。
		if (selectByExample == null || selectByExample.size() == 0) {
			return TaotaoResult.build(400, "用户名或密码错误！！！");
		}
		TbUser tbUser = selectByExample.get(0);
		//比对密码。
		if (!tbUser.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
			return TaotaoResult.build(400, "用户名或密码错误！！！");

		}
		//生成token。
		String token = UUID.randomUUID().toString();
		//保存用户之前将密码清空。
		tbUser.setPassword(null);
		//把用户信息写入redis
		jedisClient.set(RedisConstant.USER_INFO_KEY+":"+token, JsonUtils.objectToJson(tbUser));
		//设置过期时间。
		jedisClient.expire(RedisConstant.USER_INFO_KEY+":"+token, RedisConstant.ITEM_REDIS_KEY_EXPIRE);
		//添加cookie。有效期是，关闭浏览器就失效。
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);
		//返回token。
		return TaotaoResult.ok(token);
	}
	/**
	 * 获取token。
	 */
	@Override
	public TaotaoResult getUserByToken(String token) {
		//从redis中获取token。
		// TODO Auto-generated method stub
		String json = jedisClient.get(RedisConstant.USER_INFO_KEY+":"+token);
		if (json.isEmpty()) {
			return TaotaoResult.build(400, "此session已经过期，请重新登录.");
		}
		//更新过期时间。
		jedisClient.expire(RedisConstant.USER_INFO_KEY+":"+token, RedisConstant.ITEM_REDIS_KEY_EXPIRE);
		TbUser jsonToPojo = JsonUtils.jsonToPojo(json, TbUser.class);
		return TaotaoResult.ok(jsonToPojo);
	}
}