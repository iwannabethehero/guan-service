package com.threeg.flow.step;

import java.util.Map;

public class DemoStep implements IStep {
    @Override
    public String run(Map<String, Object> context) {

        context.put("name","abcd");
        context.put("result","woshishen");

        return "xuanze";
    }
}
