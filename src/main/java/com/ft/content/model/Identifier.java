package com.ft.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

import javax.validation.constraints.NotNull;

public class Identifier implements Comparable<Identifier> {
    private String authority;
    private String identifierValue;

    public Identifier(@JsonProperty("authority") String authority,
                      @JsonProperty("identifierValue") String identifierValue) {

        this.authority = authority;
        this.identifierValue = identifierValue;
    }

    @NotNull
    public String getAuthority() {
        return authority;
    }

    @NotNull
    public String getIdentifierValue() {
        return identifierValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identifier)) return false;

        Identifier that = (Identifier) o;

        if (identifierValue != null ? !identifierValue.equals(that.identifierValue) : that.identifierValue != null)
            return false;
        if (authority != null ? !authority.equals(that.authority) : that.authority != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identifierValue, authority);
    }

    @Override
    public int compareTo(Identifier that) {
        return ComparisonChain.start()
                .compare(this.authority, that.authority)
                .compare(this.identifierValue, that.identifierValue)
                .result();
    }
}


