package com.threeg.exception.output;

import com.threeg.constant.StatusCode;
import com.threeg.exception.OutPutBaseException;

public class NonSupportFlowException extends OutPutBaseException {
    /**
     * 还需要加方法补充code status 等
     * @param msg
     */
    public NonSupportFlowException(String msg){
        this.msg = msg;
    }
}
