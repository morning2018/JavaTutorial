package com.learning.spi;

public interface RuleProvider {
    /**
     * get rule name
     * @author morning
     * @date 2020/11/28 13:30
     * @since 0.0.1
     * @return  String
     */
    String getRuleName();

    void checkRule();
}
