package com.imooc.mall.service.impl;

import com.imooc.mall.dao.UserMapper;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName UserServiceImpl
 * @Author Administrator
 * @Date 2020/3/9 9:55
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public ResponseVo<User> register(User user) {
//        userName不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername>0){
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }
//        email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail>0){
            return ResponseVo.error(ResponseEnum.EMAIL_EXIST);
        }
        //通常开始注册都是普通用户。
        user.setRole(RoleEnum.CUSTOMER.getCode());

        //MD5加密(密码加密) Digest摘要算法。spring 自带
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(
                user.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(md5DigestAsHex);

//        写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username,String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null){
            //用户不存在。(返回用户名或者密码错误)
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        //用户名或密码错误。（安全措施。）
        //MD5加密(密码加密) Digest摘要算法。spring 自带,判断密码。
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(
                password.getBytes(StandardCharsets.UTF_8));
        if (!user.getPassword().equalsIgnoreCase(md5DigestAsHex)){
            //密码错误。(返回用户名或者密码错误)
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        user.setPassword("");
        return ResponseVo.success(user);
    }
}
