package com.ft.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;

public class Member {

    private final String uri;

    public Member(@JsonProperty("uri") String uri) {
        if (uri == null) {
            throw new IllegalArgumentException("Member uri must not be null.");
        }
        this.uri = uri;
    }

    @NotNull
    public String getUri() {
        return uri;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Member other = (Member) obj;

        return uri.equals(other.uri);
    }

    @Override
    public int hashCode() {
        return uri.hashCode();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this.getClass())
                .add("uri", uri)
                .toString();
    }
}
