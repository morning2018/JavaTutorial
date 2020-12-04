package com.learning.spi;

import java.util.ServiceLoader;

public final class AuditingEngine {
    private static final AuditingEngine AUDITING_ENGINE = new AuditingEngine();
    private AuditingEngine() {
        loadRule();
    }

    public static AuditingEngine getInstance() {
        return  AUDITING_ENGINE;
    }

    private void loadRule() {
        ServiceLoader<RuleProvider> serviceLoader = ServiceLoader.load(RuleProvider.class);
        while (serviceLoader.iterator().hasNext()) {
            RuleProvider ruleProvider = serviceLoader.iterator().next();
            System.out.println(ruleProvider.getClass().getName());
        }
    }
}
