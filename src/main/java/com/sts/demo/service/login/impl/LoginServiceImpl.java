package com.sts.demo.service.login.impl;

import com.sts.demo.entities.ResultVO;
import com.sts.demo.entities.datasource.LoginParamVO;
import com.sts.demo.entities.mapper.UserMapper;
import com.sts.demo.service.login.ILoginService;
import com.sts.demo.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ResultVO login(LoginParamVO params) {
        ResultVO result = new ResultVO();
        if(params == null){
            result.setSuccess(false);
            result.setMessage("登录参数不可为空");
        }
        else if(StringUtils.isEmpty(params.getUsername())){
            result.setSuccess(false);
            result.setMessage("用户名不可为空");
        }
        else if(StringUtils.isEmpty(params.getPassword())){
            result.setSuccess(false);
            result.setMessage("密码不可为空");
        }
        else if(StringUtils.isEmpty(params.getCheckCode())){
            result.setSuccess(false);
            result.setMessage("校验码不可为空");
        }
        else{
            // 判断用户名密码是否匹配
            int checkResult = userMapper.checkUserNameAndPass(params);
            if(checkResult > 0){
                //校验通过，可以登录
                result.setMessage("用户名/密码匹配成功，允许登陆！");
                result.setSuccess(true);
            }
            else{
                //用户不存在，禁止登陆
                result.setMessage("用户名或密码错误！");
                result.setSuccess(false);
            }
        }
        return result;
    }
}
