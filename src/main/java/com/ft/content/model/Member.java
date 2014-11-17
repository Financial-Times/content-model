package com.ft.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;

public class Member {

    private final String id;

    public Member(@JsonProperty("id") String id) {
        if (id == null) {
            throw new IllegalArgumentException("Member id must not be null.");
        }
        this.id = id;
    }

    @NotNull
    public String getId() {
        return id;
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

        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this.getClass())
                .add("id", id)
                .toString();
    }
}
