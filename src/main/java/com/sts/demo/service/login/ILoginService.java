package com.sts.demo.service.login;

import com.sts.demo.Entity.ResultVO;
import com.sts.demo.Entity.login.LoginParamVO;

public interface ILoginService {

    /**用户登录*/
    ResultVO login(LoginParamVO params);
}
