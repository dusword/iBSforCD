package com.lxjtest.constant;

public enum ApiErrorCode {

    SUCCESS("200","成功"),

    FAIL("500","服务失败"),

    PARAM_INVALID("1001", "参数非法"),

    FUNC_INVALID("1002","服务不存在"),

    RIGHT_INVALID("600","鉴权失败");

    private String code;
    private String desc;

    private ApiErrorCode(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getCode() {
        return this.code;
    }
}