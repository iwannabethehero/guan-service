package com.threeg.utils;

import java.util.Map;

public class FlowUtils {
    public static Object runFlow(FlowHelper flowHelper,Map<String, Object> context) {
        if (flowHelper == null||flowHelper.thisStep==null){
            return null;
        }
        String run = flowHelper.thisStep.run(context);
        if (flowHelper.linkedStep.size()>0){
            if (flowHelper.linkedStep.containsKey(run)){
                runFlow(flowHelper.linkedStep.get(run),context);
                runFlow(flowHelper.linkedStep.get("default"),context);
            }else{
                runFlow(flowHelper.linkedStep.get("default"),context);
            }
        }
        return context.get("result");
    }
}
