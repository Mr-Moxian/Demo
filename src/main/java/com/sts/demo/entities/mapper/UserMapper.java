package com.sts.demo.entities.mapper;

import com.sts.demo.entities.datasource.LoginParamVO;

public interface UserMapper {

    /**
     * 判断用户是否存在
     * @param loginParamVO 登录用户用户名密码等信息
     * */
    int checkUserNameAndPass(LoginParamVO loginParamVO);
}
