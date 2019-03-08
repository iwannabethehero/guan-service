package com.threeg.utils;

import com.threeg.exception.inner.FlowNotFindException;
import com.threeg.flow.Flow;
import com.threeg.flow.step.IStep;

import java.util.Map;

public class FlowBuilder {
    private static final Map<String,IStep> MAPPING = Flow.stepMapping;

    public static FlowHelper buildFlow(String flow){
        if (flow==null){
            throw new FlowNotFindException("流程不允许为空");
        }
        flow = flow.trim();

        FlowHelper head = null;
        FlowHelper temp = null;
        int pre = 0;
        for (int i = 0; i < flow.length(); i++) {
            //遇到 空格, > , ] , [ 停下
            switch (flow.charAt(i)) {
                case 32 : {
                }
            }
        }
        return head;
    }
}
