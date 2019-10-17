package com.sts.demo.entities.datasource;

/**
 * 用户表
 * */
public class UserVO {

    //主键
    private String userid;
    //用户名
    private String username;

    //密码
    private String password;

    //启用状态 1：未启用 2： 已启用 3：已停用
    private int status;

    //数据状态 1：已删除 0：可用
    private int dr;

    //邮箱
    private String email;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }
}
