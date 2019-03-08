package com.threeg.flow.step;

import java.util.Map;

public class DemoStep implements IStep {
    @Override
    public String run(Map<String, Object> context) {


        return "payload";
    }
}
