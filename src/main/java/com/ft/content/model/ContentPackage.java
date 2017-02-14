package com.ft.content.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentPackage {

    private final String description;

    private final String listId;

    public ContentPackage(@JsonProperty("description") String description,
                          @JsonProperty("listId") String listId) {
        this.description = description;
        this.listId = listId;
    }

    public String getDescription() {
        return description;
    }

    public String getListId() {
        return listId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentPackage that = (ContentPackage) o;

        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        return listId != null ? listId.equals(that.listId) : that.listId == null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(description, listId);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("description", description)
                .add("listId", listId)
                .toString();
    }
}
