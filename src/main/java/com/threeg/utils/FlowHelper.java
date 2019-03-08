package com.threeg.utils;

import com.threeg.flow.step.IStep;

import java.util.HashMap;
import java.util.Map;

/**
 * 此类相当于单向链表的节点,存储Step
 */
public class FlowHelper {
    /**
     * key为分支name,默认default
     */
    public Map<String,FlowHelper> linkedStep = new HashMap<>();

    public IStep thisStep;

    public FlowHelper(IStep thisStep){
        this.thisStep = thisStep;
    }

    public void setNextStep(IStep step){
        FlowHelper flowHelper = new FlowHelper(step);
        linkedStep.put("default",flowHelper);
    }

    public void setStep(String name ,IStep step){
        FlowHelper flowHelper = new FlowHelper(step);
        linkedStep.put(name,flowHelper);
    }

}
