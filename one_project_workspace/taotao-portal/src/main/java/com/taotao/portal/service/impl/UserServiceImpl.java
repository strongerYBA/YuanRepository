package com.taotao.portal.service.impl;

import org.springframework.stereotype.Service;

import com.taotao.common.constants.HttpClientConstant;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbUser;
import com.taotao.portal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public TbUser getUserByToken(String token) {
		try {
			//根据token。获取用户信息。调用sso系统服务。
			String doGet = HttpClientUtil.doGet(HttpClientConstant.SSO_LOGIN_TOKEN_URL+token);
			TaotaoResult result = TaotaoResult.formatToPojo(doGet, TbUser.class);
			//取不到用户信息。做url跳转到登录页面。并将url一起传递过去。做回调用的。
			if (result.getStatus() == 200) {
				TbUser user = (TbUser) result.getData();
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
