package com.sts.demo.entities.datasource;

/**
 * 登录相关的参数
 * */
public class LoginParamVO {

    //用户名
    private String username;
    //密码
    private String password;
    //校验码
    private String checkCode;

    //登陆时间
    private String loginTime;

    //创建时间
    private String createTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
