package com.ft.content.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.collect.Maps;

public enum Syndication {
    YES("yes"),
    NO("no"),
    VERIFY("verify");

	private static Map<String, Syndication> syndicationMap = Maps.newHashMap();

	private String canBeSyndicated;
    
	static {
		for (Syndication s : values()) {
			syndicationMap.put(s.getCanBeSyndicated(), s);
		}
	}

    Syndication(String canBeSyndicated) {
        this.canBeSyndicated = canBeSyndicated;
    }

    @JsonValue
    public String getCanBeSyndicated() {
        return canBeSyndicated;
    }
    
	public static Syndication fromString(String value) {
		return syndicationMap.get(value.toLowerCase());
	}
}
