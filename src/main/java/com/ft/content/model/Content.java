package com.ft.content.model;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

public class Content {

    private final String uuid;
    private final String headline;
    private final String byline;
    private final String source;
    private final Date lastPublicationDate;
    private final String xmlBody;

    public Content(@JsonProperty("uuid") UUID uuid,
                   @JsonProperty("headline") String headline,
                   @JsonProperty("byline") String byline,
                   @JsonProperty("source") String source,
                   @JsonProperty("lastPublicationDate") Date lastPublicationDate,
                   @JsonProperty("body") String xmlBody) {
        this.xmlBody = xmlBody;
        this.uuid = uuid == null ? null : uuid.toString();
        this.headline = headline;
        this.byline = byline;
        this.source = source;
        this.lastPublicationDate = lastPublicationDate;
    }

    @NotNull
    public String getUuid() {
        return uuid;
    }

    @NotEmpty
    public String getHeadline() {
        return headline;
    }
    
    public String getByline() {
    	return byline;
    }

    @NotEmpty
    public String getSource() {
        return source;
    }

    @NotNull
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="UTC")
    public Date getLastPublicationDate() {
        return lastPublicationDate;
    }

    public String getBody() {
        return xmlBody;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this.getClass())
                .add("uuid", uuid)
                .add("headline", headline)
                .add("byline", byline)
                .add("source", source)
                .add("lastPublicationDate", lastPublicationDate)
                .add("body", xmlBody)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content that = (Content) o;

        return Objects.equal(this.uuid, that.uuid)
                && Objects.equal(this.headline, that.headline)
                && Objects.equal(this.byline, that.byline)
                && Objects.equal(this.source, that.source)
                && Objects.equal(this.xmlBody, that.xmlBody) // TODO maybe this could be better. The strings could be equivalent as xml even though they are different strings
                && Objects.equal(this.lastPublicationDate, that.lastPublicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(headline, byline, source, uuid, lastPublicationDate, xmlBody);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID uuid;
        private String headline;
        private String byline;
        private String source;
        private Date lastPublicationDate;
        private String xmlBody;

        public Builder withUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder withHeadline(String headline) {
            this.headline = headline;
            return this;
        }

        public Builder withByline(String byline) {
            this.byline = byline;
            return this;
        }

        public Builder withSource(String source) {
            this.source = source;
            return this;
        }

        public Builder withLastPublicationDate(Date lastPublicationDate) {
            this.lastPublicationDate = lastPublicationDate;
            return this;
        }

        public Builder withXmlBody(String xmlBody) {
            this.xmlBody = xmlBody;
            return this;
        }

        public Builder withValuesFrom(Content content) {
            return withHeadline(content.getHeadline())
            		.withByline(content.getByline())
            		.withSource(content.getSource())
                    .withUuid(UUID.fromString(content.getUuid()))
                    .withLastPublicationDate(content.getLastPublicationDate())
                    .withXmlBody(content.getBody());
        }

        public Content build() {
            return new Content(uuid, headline, byline, source, lastPublicationDate, xmlBody);
        }
    }

}
