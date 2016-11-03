package com.ft.content.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Syndication {
    YES("yes"),
    NO("no"),
    VERIFY("verify");

    private String canBeSyndicated;

    Syndication(String canBeSyndicated) {
        this.canBeSyndicated = canBeSyndicated;
    }

    @JsonValue
    public String getCanBeSyndicated() {
        return canBeSyndicated;
    }
}
