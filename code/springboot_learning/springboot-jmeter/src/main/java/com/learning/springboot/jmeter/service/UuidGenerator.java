package com.learning.springboot.jmeter.service;

import java.util.UUID;

public final class UuidGenerator {
    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
