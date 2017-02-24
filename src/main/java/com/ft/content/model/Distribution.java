package com.ft.content.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Distribution {
    YES("yes"),
    NO("no"),
    VERIFY("verify");

    private String distributionStatus;

    Distribution(String distributionStatus) {
        this.distributionStatus = distributionStatus;
    }

    @JsonValue
    public String getDistributionStatus() {
        return distributionStatus;
    }
}
