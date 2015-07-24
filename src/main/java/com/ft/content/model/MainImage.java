package com.ft.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;

public class MainImage {

    private final String uuid;

    public MainImage(@JsonProperty("uuid") final String uuid) {
        this.uuid = uuid;
    }

    @NotNull
    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainImage that = (MainImage) o;
        return Objects.equal(this.uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }
}
