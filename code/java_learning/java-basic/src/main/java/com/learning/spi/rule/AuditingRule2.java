package com.learning.spi.rule;

import com.learning.spi.RuleProvider;

public class AuditingRule2 implements RuleProvider {
    /**
     * get rule name
     *
     * @return String
     * @author morning
     * @date 2020/11/28 13:30
     * @since 0.0.1
     */
    @Override public String getRuleName() {
        return "rule2";
    }

    @Override public void checkRule() {
        System.out.println("rule 2 check");
    }
}
