package com.jose.spring_secure_api.util;

import lombok.AllArgsConstructor;


import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public enum Role {
    CUSTOMER(List.of(
            Permission.READ_ALL_PRODUCTS,
            Permission.READ_MY_USER
    )),
    ADMINISTRATOR(List.of(
            Permission.SAVE_ONE_PRODUCT,
            Permission.READ_ALL_PRODUCTS,
            Permission.READ_ALL_USERS,
            Permission.READ_MY_USER
    ));

    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
