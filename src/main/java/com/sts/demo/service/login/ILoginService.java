package com.sts.demo.service.login;

import com.sts.demo.entities.ResultVO;
import com.sts.demo.entities.datasource.LoginParamVO;

public interface ILoginService {

    /**用户登录*/
    ResultVO login(LoginParamVO params);
}
