package com.sts.demo.entities.datasource;

/**
 * 单点登录相关的参数
 * */
public class ThirdLoginParamVO {

    //类型 固定为type_security
    private String type;
    //数据源名称，必须项
    private String dsname;
    //ncc用户编码，必须项
    private String usercode;
    //多语语种
    private String langcode;
    //账套编码
    private String busicentercode;
    //第三方系统加签时间
    private String ts;
    //第三方系统ID，必须项
    private String client_id;
    //第三方系统由共同维护的秘钥对根据给定的加密算法生成的秘钥，必须项
    private String security;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDsname() {
        return dsname;
    }

    public void setDsname(String dsname) {
        this.dsname = dsname;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getLangcode() {
        return langcode;
    }

    public void setLangcode(String langcode) {
        this.langcode = langcode;
    }

    public String getBusicentercode() {
        return busicentercode;
    }

    public void setBusicentercode(String busicentercode) {
        this.busicentercode = busicentercode;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }
}
