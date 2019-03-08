package com.threeg.exception.inner;

import com.threeg.exception.InnerBaseException;

/**
 * 内部异常
 */
public class FlowNotFindException extends InnerBaseException {

    public String message;

    /**
     * 必须要有message
     * @param message
     */
    public FlowNotFindException(String message){
        this.message = message;
    }
}
