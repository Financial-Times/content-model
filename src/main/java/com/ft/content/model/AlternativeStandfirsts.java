package com.ft.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.Objects;

public class AlternativeStandfirsts {

    private final String promotionalStandfirst;

    public static AlternativeStandfirsts.Builder builder() {
        return new AlternativeStandfirsts.Builder();
    }

    public AlternativeStandfirsts(@JsonProperty("promotionalStandfirsts") String promotionalStandfirsts) {
        this.promotionalStandfirst = promotionalStandfirsts;
    }


    public String getPromotionalStandfirst() {
        return promotionalStandfirst;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("promotionalStandfirst", promotionalStandfirst)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (o.getClass() != AlternativeStandfirsts.class)) {
            return false;
        }

        final AlternativeStandfirsts that = (AlternativeStandfirsts) o;

        return Objects.equals(this.promotionalStandfirst, that.promotionalStandfirst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(promotionalStandfirst);
    }

    public static class Builder {

        private String promotionalStandfirst;


        public AlternativeStandfirsts.Builder withPromotionalStandfirst(String title) {
            this.promotionalStandfirst = title;
            return this;
        }

        public AlternativeStandfirsts.Builder withValuesFrom(AlternativeStandfirsts alternativeStandfirsts) {
            return withPromotionalStandfirst(alternativeStandfirsts.getPromotionalStandfirst());
        }

        public AlternativeStandfirsts build() {
            return new AlternativeStandfirsts(promotionalStandfirst);
        }
    }
}
