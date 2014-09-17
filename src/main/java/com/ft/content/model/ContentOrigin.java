package com.ft.content.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class ContentOrigin {
    private String originatingSystem;
    private String originatingIdentifier;

    public ContentOrigin(@JsonProperty("originatingSystem") String originatingSystem,
                          @JsonProperty("originatingIdentifier") String originatingIdentifier) {

        this.originatingSystem = originatingSystem;
        this.originatingIdentifier = originatingIdentifier;
    }

    @NotNull
    public String getOriginatingSystem() {
        return originatingSystem;
    }

    @NotNull
    public String getOriginatingIdentifier() {
        return originatingIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContentOrigin)) return false;

        ContentOrigin that = (ContentOrigin) o;

        if (originatingIdentifier != null ? !originatingIdentifier.equals(that.originatingIdentifier) : that.originatingIdentifier != null)
            return false;
        if (originatingSystem != null ? !originatingSystem.equals(that.originatingSystem) : that.originatingSystem != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(originatingIdentifier, originatingSystem);
    }
}


