package com.ft.content.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

public class Content {

    private final String uuid;
    private final String title;
    private final String byline;
    private final List<String> brands;
    private final String originatingSystem;
    private final String originatingIdentifier;
    private final Date publishedDate;
    private final String xmlBody;

    public Content(@JsonProperty("uuid") UUID uuid,
                   @JsonProperty("title") String title,
                   @JsonProperty("byline") String byline,
                   @JsonProperty("brands") List<String> brands,
                   @JsonProperty("originatingSystem") String originatingSystem,
                   @JsonProperty("originatingIdentifier") String originatingIdentifier,
                   @JsonProperty("publishedDate") Date publishedDate,
                   @JsonProperty("body") String xmlBody) {
        this.xmlBody = xmlBody;
        this.uuid = uuid == null ? null : uuid.toString();
        this.title = title;
        this.byline = byline;
        this.brands = brands;
        this.originatingSystem = originatingSystem;
        this.originatingIdentifier = originatingIdentifier;
        this.publishedDate = publishedDate;
    }

    @NotNull
    public String getUuid() {
        return uuid;
    }

    @NotEmpty
    public String getTitle() {
        return title;
    }
    
    public String getByline() {
    	return byline;
    }

    public List<String> getBrands() {
		return brands;
	}

	public String getOriginatingSystem() {
		return originatingSystem;
	}

	public String getOriginatingIdentifier() {
		return originatingIdentifier;
	}

    @NotNull
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="UTC")
    public Date getPublishedDate() {
        return publishedDate;
    }

    public String getBody() {
        return xmlBody;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this.getClass())
                .add("uuid", uuid)
                .add("title", title)
                .add("byline", byline)
                .add("brands", brands)
                .add("originatingSystem", originatingSystem)
                .add("originatingIdentifier", originatingIdentifier)
                .add("publishedDate", publishedDate)
                .add("body", xmlBody)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content that = (Content) o;

        return Objects.equal(this.uuid, that.uuid)
                && Objects.equal(this.title, that.title)
                && Objects.equal(this.byline, that.byline)
                && Objects.equal(this.brands, that.brands)
                && Objects.equal(this.originatingSystem, that.originatingSystem)
                && Objects.equal(this.originatingIdentifier, that.originatingIdentifier)
                && Objects.equal(this.xmlBody, that.xmlBody) // TODO maybe this could be better. The strings could be equivalent as xml even though they are different strings
                && Objects.equal(this.publishedDate, that.publishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, byline, brands, originatingSystem, originatingIdentifier, uuid, publishedDate, xmlBody);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID uuid;
        private String title;
        private String byline;
        private List<String> brands;
        private String originatingSystem;
        private String originatingIdentifier;
        private Date publishedDate;
        private String xmlBody;

        public Builder withUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withByline(String byline) {
            this.byline = byline;
            return this;
        }

        public Builder withBrands(List<String> brands) {
            this.brands = brands;
            return this;
        }

        public Builder withOriginatingSystem(String originatingSystem) {
            this.originatingSystem = originatingSystem;
            return this;
        }

        public Builder withOriginatingIdentifier(String originatingIdentifier) {
            this.originatingIdentifier = originatingIdentifier;
            return this;
        }

        public Builder withPublishedDate(Date publishedDate) {
            this.publishedDate = publishedDate;
            return this;
        }

        public Builder withXmlBody(String xmlBody) {
            this.xmlBody = xmlBody;
            return this;
        }

        public Builder withValuesFrom(Content content) {
            return withTitle(content.getTitle())
            		.withByline(content.getByline())
            		.withBrands(content.getBrands())
            		.withOriginatingSystem(content.getOriginatingSystem())
            		.withOriginatingIdentifier(content.getOriginatingIdentifier())
                    .withUuid(UUID.fromString(content.getUuid()))
                    .withPublishedDate(content.getPublishedDate())
                    .withXmlBody(content.getBody());
        }

        public Content build() {
            return new Content(uuid, title, byline, brands, originatingSystem, originatingIdentifier, publishedDate, xmlBody);
        }
    }

}
