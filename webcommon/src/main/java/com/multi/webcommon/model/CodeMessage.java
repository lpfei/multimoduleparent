package com.multi.webcommon.model;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lpfei
 * Date: 2019-02-21
 * Time: 19:08
 */
public interface CodeMessage<C> {
    C getCode();
    String getMessage();
}
