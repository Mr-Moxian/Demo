package com.sts.demo.entities;

import java.util.List;

/**
 * 返回结果VO
 * */
public class ResultVO {

    //是否成功标识
    private boolean success ;

    //返回信息
    private String message ;

    //返回结果集
    private List<?> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
