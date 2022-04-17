package com.iteesoft.storeapp.enums;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE"),
    OTHER("OTHER");

    private String value;

    Gender(String value) {
        this.value = value;
    }
}
