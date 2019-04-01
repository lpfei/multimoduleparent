package com.multi.webcommon.model;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lpfei
 * Date: 2019-02-21
 * Time: 19:10
 */
public enum CodeMessageEnum implements CodeMessage<String> {

    SIGN_ERROR("10001", "签名错误"),

    PARAM_ERROR("20001", "参数错误"),

    BUG_ERROR("30001", "处理错误"),

    ERROR("40001", "处理错误"),

    OFTEN_ERROR("43001", "请求频繁,请稍后重试"),

    PERMISSION_ERROR("50001", "暂无权限");


    String code;
    String message;

    CodeMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
