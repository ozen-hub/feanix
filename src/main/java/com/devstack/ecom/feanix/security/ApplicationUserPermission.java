package com.devstack.ecom.feanix.security;

import java.util.Set;

public enum ApplicationUserPermission {
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),
    ORDER_WRITE("order:write"),
    ORDER_READ("order:read"),
    USER_ROLE_WRITE("userRole:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }


}
