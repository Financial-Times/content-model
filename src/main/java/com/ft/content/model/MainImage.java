package com.ft.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;

public class MainImage {

    private final String id;

    public MainImage(@JsonProperty("id") final String id) {
        this.id = id;
    }

    @NotNull
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainImage that = (MainImage) o;
        return Objects.equal(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
