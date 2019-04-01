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
public class ServiceResult<T, C> implements Serializable {
    private static final String DEF_CODE = "000000";
    private static final CodeMessage<String> SUCCESS = new DefaultMessage<>(DEF_CODE, "success");

    private T data;
    private CodeMessage<C> message;
    private boolean isSuccess;

    ServiceResult(boolean isSuccess, CodeMessage<C> message, T data) {
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

    public static <D, C> ServiceResult<D, String> success() {
        ServiceResultBuilder<D, String> success = success(SUCCESS);
        return success.build();
    }

    public static <D> ServiceResult<D, String> success(D data) {
        ServiceResultBuilder<D, String> success = success(SUCCESS);
        return success.data(data).build();
    }

    public static <D, C> ServiceResult<D, C> error(CodeMessage<C> codeMessage) {
        ServiceResultBuilder<D, C> builder = builder();
        return builder.isSuccess(false).code(codeMessage.getCode()).message(codeMessage.getMessage()).build();
    }

    public static <D, C> ServiceResult<D, C> error(CodeMessage<C> codeMessage, String msg) {
        ServiceResultBuilder<D, C> builder = builder();
        return builder.isSuccess(false).code(codeMessage.getCode()).message(msg).build();
    }

    public static <D, C> ServiceResult<D, C> error(String message) {
        ServiceResultBuilder<D, C> builder = builder();
        return builder.isSuccess(false).code((C) DEF_CODE).message(message).build();
    }

    public static <D, C> ServiceResultBuilder<D, C> success(CodeMessage<C> codeMessage) {
        ServiceResultBuilder<D, C> builder = builder();
        return builder.isSuccess(true).code(codeMessage.getCode()).message(codeMessage.getMessage());
    }

    static <D, C> ServiceResultBuilder<D, C> builder() {
        return new ServiceResultBuilder<>();
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


    public static class ServiceResultBuilder<T, C> {

        private T data;
        private C code;
        private String message;
        private boolean isSuccess;

        ServiceResultBuilder() { //package private
        }

        public ServiceResultBuilder<T, C> data(T data) {
            this.data = data;
            return this;
        }

        ServiceResultBuilder<T, C> isSuccess(boolean isSuccess) {
            this.isSuccess = isSuccess;
            return this;
        }

        public ServiceResultBuilder<T, C> code(C code) {
            this.code = code;
            return this;
        }

        public ServiceResultBuilder<T, C> message(String message) {
            this.message = message;
            return this;
        }

        public ServiceResult<T, C> build() {
            Objects.requireNonNull(code, "code");
            Objects.requireNonNull(message, "message");
            return new ServiceResult<>(isSuccess, new DefaultMessage<>(code, message), data);
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
        ServiceResult<List<String>, String> s = ServiceResult.success(Arrays.asList("1", "2", "3"));
        s.isSuccess(); //true
        ServiceResult<?, String> e1 = ServiceResult.error(CodeMessageEnum.ERRER );
        e1.isSuccess(); //false
        ServiceResult<?, Long> e2 = ServiceResult.error(new ServiceResult.DefaultMessage(100, ""));
        e2.isSuccess(); //false
        //ServiceResult{data=[1, 2, 3], message=DefaultMessage{code=00000000, message='success'}, isSuccess=true}
        System.out.println(s);
        //ServiceResult{data=null, message=DefaultMessage{code=1001, message='错误信息。'}, isSuccess=false}
        System.out.println(e1);
        //ServiceResult{data=null, message=DefaultMessage{code=1000, message='error'}, isSuccess=false}
        System.out.println(e2);
        ServiceResult.success();
        ServiceResult<?, Integer> e11 = ServiceResult.error("错误");

    }

}
