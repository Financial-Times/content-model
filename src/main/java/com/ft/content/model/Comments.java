package com.ft.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class Comments {
    private boolean enabled;

    public Comments(@JsonProperty("enabled") boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comments that = (Comments) o;

        return Objects.equal(this.enabled, that.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(enabled);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        boolean enabled;

        public Builder withEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Comments build() {
            return new Comments(enabled);
        }
    }
}
