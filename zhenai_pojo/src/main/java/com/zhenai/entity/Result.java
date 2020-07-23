package com.zhenai.entity;

import java.io.Serializable;

public class Result implements Serializable {
    private Integer code;//返回的业务代码    0：成功  1：失败
    private String message;//信息

    public Result() {
        this.code = 0;
        this.message = "执行成功";
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
