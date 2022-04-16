package com.iteesoft.storeapp.enums;

public enum Role {
    ADMIN("ADMIN"),
    MANAGER("MANAGER"),
    CASHIER("CASHIER");

    private String value;

    Role(String value) {
        this.value = value;
    }

}
