package com.sts.demo.service.login.impl;

import com.sts.demo.Entity.ResultVO;
import com.sts.demo.Entity.login.LoginParamVO;
import com.sts.demo.service.login.ILoginService;
import com.sts.demo.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {
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
            result.setSuccess(true);
        }
        return result;
    }
}
