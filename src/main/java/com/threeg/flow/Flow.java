package com.threeg.flow;

import com.threeg.flow.step.DemoStep;
import com.threeg.flow.step.IStep;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义DSL
 * 根据配置的flow顺序执行对应类的run方法
 */
public enum Flow {

    DEMO_FLOW("模板步骤1 >> 模板步骤2 >> [ 选择A : 模板步骤3 >> 模板步骤6, 选择B : 模板步骤4 ] >> 模板步骤5");



    /**
     * 加流程先把新步骤注入
     */
    public static Map<String,IStep> stepMapping = new HashMap<>();
    static {
        stepMapping.put("模板步骤1",new DemoStep());
        stepMapping.put("模板步骤2",new DemoStep());
        stepMapping.put("模板步骤3",new DemoStep());
        stepMapping.put("模板步骤4",new DemoStep());
        stepMapping.put("模板步骤5",new DemoStep());
        stepMapping.put("模板步骤6",new DemoStep());
    }





    public String flows;
    Flow(String flows){
        this.flows = flows;
    }
}
