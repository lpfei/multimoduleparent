package com.multi.webcommon.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Description:service result
 *
 * @author lpfei
 * Date: 2019-02-21
 */
public class ServerResult<T, C> implements Serializable {
    private static final String DEF_CODE = "000000";
    private static final CodeMessage<String> SUCCESS = new DefaultMessage<>(DEF_CODE, "success");

    private T data;
    private CodeMessage<C> message;
    private boolean isSuccess;

    ServerResult(boolean isSuccess, CodeMessage<C> message, T data) {
        this.data = data;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public T getData() {
        return data;
    }

    public CodeMessage<C> getCodeMessage() {
        return message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public static <D, C> ServerResult<D, String> success() {
        ServerResultBuilder<D, String> success = success(SUCCESS);
        return success.build();
    }

    public static <D> ServerResult<D, String> success(D data) {
        ServerResultBuilder<D, String> success = success(SUCCESS);
        return success.data(data).build();
    }

    public static <D, C> ServerResult<D, C> error(CodeMessage<C> codeMessage) {
        ServerResultBuilder<D, C> builder = builder();
        return builder.isSuccess(false).code(codeMessage.getCode()).message(codeMessage.getMessage()).build();
    }

    public static <D, C> ServerResult<D, C> error(CodeMessage<C> codeMessage, String msg) {
        ServerResultBuilder<D, C> builder = builder();
        return builder.isSuccess(false).code(codeMessage.getCode()).message(msg).build();
    }

    public static <D, C> ServerResult<D, C> error(String message) {
        ServerResultBuilder<D, C> builder = builder();
        return builder.isSuccess(false).code((C) DEF_CODE).message(message).build();
    }

    public static <D, C> ServerResultBuilder<D, C> success(CodeMessage<C> codeMessage) {
        ServerResultBuilder<D, C> builder = builder();
        return builder.isSuccess(true).code(codeMessage.getCode()).message(codeMessage.getMessage());
    }

    static <D, C> ServerResultBuilder<D, C> builder() {
        return new ServerResultBuilder<>();
    }

    public static class DefaultMessage<C> implements CodeMessage<C>, Serializable {

        private C code;
        private String message;

        public DefaultMessage(C code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public C getCode() {
            return code;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }


    public static class ServerResultBuilder<T, C> {

        private T data;
        private C code;
        private String message;
        private boolean isSuccess;

        ServerResultBuilder() { //package private
        }

        public ServerResultBuilder<T, C> data(T data) {
            this.data = data;
            return this;
        }

        ServerResultBuilder<T, C> isSuccess(boolean isSuccess) {
            this.isSuccess = isSuccess;
            return this;
        }

        public ServerResultBuilder<T, C> code(C code) {
            this.code = code;
            return this;
        }

        public ServerResultBuilder<T, C> message(String message) {
            this.message = message;
            return this;
        }

        public ServerResult<T, C> build() {
            Objects.requireNonNull(code, "code");
            Objects.requireNonNull(message, "message");
            return new ServerResult<>(isSuccess, new DefaultMessage<>(code, message), data);
        }
    }

    @Override
    public String toString() {
        return "ServiceResult{" +
                "data=" + data +
                ", message=" + message +
                ", isSuccess=" + isSuccess +
                '}';
    }

    public static void main(String[] args) {
        ServerResult<List<String>, String> s = ServerResult.success(Arrays.asList("1", "2", "3"));
        s.isSuccess(); //true
        ServerResult<?, String> e1 = ServerResult.error(CodeMessageEnum.ERROR);
        e1.isSuccess(); //false
        ServerResult<?, Long> e2 = ServerResult.error(new ServerResult.DefaultMessage(100, ""));
        e2.isSuccess(); //false
        //ServiceResult{data=[1, 2, 3], message=DefaultMessage{code=00000000, message='success'}, isSuccess=true}
        System.out.println(s);
        //ServiceResult{data=null, message=DefaultMessage{code=1001, message='错误信息。'}, isSuccess=false}
        System.out.println(e1);
        //ServiceResult{data=null, message=DefaultMessage{code=1000, message='error'}, isSuccess=false}
        System.out.println(e2);
        ServerResult.success();
        ServerResult<?, Integer> e11 = ServerResult.error("错误");

    }

}
