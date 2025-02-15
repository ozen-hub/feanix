package com.devstack.ecom.feanix.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdGenerator {
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
