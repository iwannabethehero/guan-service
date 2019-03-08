package com.threeg.utils;

import com.threeg.exception.inner.FlowNotFindException;
import com.threeg.flow.Flow;
import com.threeg.flow.step.IStep;

import java.util.Map;

/**
 *
 * 用来处理自定义流程字符串
 * 可能还有坑,但是流程写的专业点应该没啥问题
 * @author hlz
 */
public class FlowBuilder {
    private static final Map<String, IStep> MAPPING = Flow.stepMapping;

    //太JB恶心了
    public static FlowHelper buildFlow(String flow) {
        FlowHelper head = null;
        FlowHelper temp = null;
        int pre = 0;
        boolean flag = true;
        boolean isKeyName = false;
        //忽略模式
        boolean isIgnore = false;
        int count = 0;
        String keyName = null;
        flow = flow.trim();
        flow +=" ";
        for (int i = 0; i < flow.length(); i++) {
            char c = flow.charAt(i);
            if (!isIgnore&&checkIsSign(c)){
                if ((c==' '||c=='>')&&!checkIsSign(flow.charAt(pre))){
                    String sub = flow.substring(pre, i);
                    if (isKeyName){
                        keyName = sub;
                        isKeyName = false;
                    }else if (MAPPING.containsKey(sub)){
                        FlowHelper step = new FlowHelper(MAPPING.get(sub));
                        if (head==null){
                            head = temp = step;
                        }else {
                            temp.setNextStep(step);
                            temp = step;
                        }
                    }else {
                        throw new FlowNotFindException("流程定义不符合规范!");
                    }
                }else if (c == '['){
                    isKeyName = true;
                }else if (c==':'){
                    //开启忽略模式
                    isIgnore = true;
                }
                pre = i;
                flag = true;
            }else if (isIgnore){
                if (c==']'&&count==0){
                    isIgnore = false;
                    isKeyName =false;
                    temp.setStep(keyName,buildFlow(flow.substring(pre+1,i)));
                }else if (c==','&&count==0){
                    isIgnore = false;
                    isKeyName =true;
                    temp.setStep(keyName,buildFlow(flow.substring(pre+1,i)));
                }else if (c == '['){
                    count++;
                }else if (c == ']'){
                    count--;
                }
            } else if (flag){
                pre = i;
                flag = false;
            }
        }
        return head;
    }

    private static boolean checkIsSign(char c){
        return c==' '||c=='>'||c==','||c=='['||c==']'||c==':';
    }

}
