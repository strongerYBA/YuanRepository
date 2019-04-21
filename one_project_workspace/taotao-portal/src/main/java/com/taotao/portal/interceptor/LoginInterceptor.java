package com.taotao.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.common.constants.HttpClientConstant;
import com.taotao.common.utils.CookieUtils;
import com.taotao.pojo.TbUser;
import com.taotao.portal.service.UserService;
/**
 * 登录拦截器。
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private UserService userService;

	/**
	 * 在handler执行之前执行。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//1.判断用户是否登录。
		try {
			//从cookie中取token。	
			String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
			TbUser user = userService.getUserByToken(token);
			if (null == user) {
				//跳转登录页面。
				response.sendRedirect(HttpClientConstant.SSO_LOGIN_URL+"?redirect="+request.getRequestURL());
				return false;
			}
			//将用户信息放入request。
			request.setAttribute("user", user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	/**
	 * handler执行之后，返回modelandview之前执行。
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}
	/**
	 * 返回modelandview之后执行。响应用户之后。可以获取异常。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
