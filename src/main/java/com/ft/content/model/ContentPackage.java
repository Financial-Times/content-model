package com.ft.content.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentPackage {

    private final String description;

    private final String listLink;

    public ContentPackage(@JsonProperty("description") String description,
                          @JsonProperty("listLink") String listLink) {
        this.description = description;
        this.listLink = listLink;
    }

    public String getDescription() {
        return description;
    }

    public String getListLink() {
        return listLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentPackage that = (ContentPackage) o;

        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        return listLink != null ? listLink.equals(that.listLink) : that.listLink == null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description, listLink);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("description", description)
                .add("listLink", listLink)
                .toString();
    }
}
