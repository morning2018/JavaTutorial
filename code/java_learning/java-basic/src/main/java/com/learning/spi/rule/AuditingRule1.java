package com.learning.spi.rule;

import com.learning.spi.RuleProvider;

public class AuditingRule1 implements RuleProvider {
    /**
     * get rule name
     *
     * @return String
     * @author morning
     * @date 2020/11/28 13:30
     * @since 0.0.1
     */
    @Override public String getRuleName() {
        return "rule1";
    }

    @Override public void checkRule() {
        System.out.println("rule 1 check");
    }
}
