package com.xiaopantx.alibaba.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panxj
 */
@SpringBootApplication
public class SentinelApp {

    public static void main(String[] args) {
        init();
        SpringApplication.run(SentinelApp.class, args);
    }

    private static void init(){
        // 加载流量控制规则
        List<FlowRule> flowRules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("PersonService.info");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // QPS100
        rule.setCount(100);

        flowRules.add(rule);
        FlowRuleManager.loadRules(flowRules);
    }
}
