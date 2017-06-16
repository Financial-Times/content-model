package com.ft.content.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.Maps;

public enum Distribution {
    YES("yes"),
    NO("no"),
    VERIFY("verify");

	private static Map<String, Distribution> distributionMap = Maps.newHashMap();
    
	private String distributionStatus;

	static {
		for (Distribution d : values()) {
			distributionMap.put(d.getDistributionStatus(), d);
		}
	}

    Distribution(String distributionStatus) {
        this.distributionStatus = distributionStatus;
    }

    @JsonValue
    public String getDistributionStatus() {
        return distributionStatus;
    }
    
	public static Distribution fromString(String value) {
		return distributionMap.get(value.toLowerCase());
	}
}
