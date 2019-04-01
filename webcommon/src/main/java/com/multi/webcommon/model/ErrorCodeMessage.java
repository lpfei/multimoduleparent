package com.multi.webcommon.model;

/**
 * Description:
 *
 * @author lpfei
 * Date: 2019-02-22
 */
public class ErrorCodeMessage implements CodeMessage<String> {

    private String code;
    private String message;

    public ErrorCodeMessage(String code, String message) {
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

    public static ErrorCodeMessage build(String code, String message) {
        return new ErrorCodeMessage(code, message);
    }
}
