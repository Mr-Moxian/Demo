package com.sts.demo.entities.mapper;

import com.sts.demo.entities.datasource.LoginParamVO;

import java.util.Date;

public interface UserMapper {

    /**
     * 判断用户是否存在
     * @param loginParamVO 登录用户用户名密码等信息
     * */
    int checkUserNameAndPass(LoginParamVO loginParamVO);

    /**
     * 删除失败的登录记录
     * @param loginParamVO 需要删除的用户的用户名密码等信息
     * */
    void deleteFailLoginRecord(LoginParamVO loginParamVO);

    /**
     * 查询当前错误的登陆次数
     * @param loginParamVO 需要查询的登录错误次数的用户的用户名密码等信息
     * */
    int queryFailLoginRecordTimes(LoginParamVO loginParamVO);

    /**
     * 查询最近一次登录错误的时间
     * @param loginParamVO
     * */
    Date queryLastFailRecordTime(LoginParamVO loginParamVO);

    /**
     * 插入登录错误记录
     * @param loginParamVO
     * */
    void insertLoginFailRecord(LoginParamVO loginParamVO);

}
