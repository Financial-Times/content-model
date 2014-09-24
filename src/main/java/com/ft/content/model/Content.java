package com.ft.content.model;

import java.util.Date;
import java.util.SortedSet;
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
    private final SortedSet<Brand> brands;
    private final Date publishedDate;
    private final String xmlBody;
    private final ContentOrigin contentOrigin;
    private final String altText;
    private final String mediaType;
    private final Integer width;
    private final Integer height;
    private final String internalDataUrl;

    public Content(@JsonProperty("uuid") UUID uuid,
                   @JsonProperty("title") String title,
                   @JsonProperty("byline") String byline,
                   @JsonProperty("brands") SortedSet<Brand> brands,
                   @JsonProperty("contentOrigin") ContentOrigin contentOrigin,
                   @JsonProperty("publishedDate") Date publishedDate,
                   @JsonProperty("body") String xmlBody,
                   @JsonProperty("altText") String altText,
                   @JsonProperty("mediaType") String mediaType,
                   @JsonProperty("width") Integer width,
                   @JsonProperty("height") Integer height,
                   @JsonProperty("internalDataUrl") String internalDataUrl) {
        this.xmlBody = xmlBody;
        this.uuid = uuid == null ? null : uuid.toString();
        this.title = title;
        this.byline = byline;
        this.brands = brands;
        this.publishedDate = publishedDate;
        this.contentOrigin = contentOrigin;
        this.altText = altText;
        this.mediaType = mediaType;
        this.width = width;
        this.height = height;
        this.internalDataUrl = internalDataUrl;
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

    public SortedSet<Brand> getBrands() {
		return brands;
	}


    @NotNull
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="UTC")
    public Date getPublishedDate() {
        return publishedDate;
    }

    public String getBody() {
        return xmlBody;
    }

    @NotNull
    public ContentOrigin getContentOrigin() {
        return contentOrigin;
    }

    public String getAltText() {
        return altText;
    }

    public String getMediaType() {
        return mediaType;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getInternalDataUrl() {
        return internalDataUrl;
    }

    @Override
    public String toString() {
        String originatingSystem = (contentOrigin != null) ? contentOrigin.getOriginatingSystem() : null;
        String originatingIdentifier = (contentOrigin != null) ? contentOrigin.getOriginatingIdentifier() : null;
        return Objects.toStringHelper(this.getClass())
                .add("uuid", uuid)
                .add("title", title)
                .add("byline", byline)
                .add("brands", brands)
                .add("originatingSystem", originatingSystem)
                .add("originatingIdentifier", originatingIdentifier)
                .add("publishedDate", publishedDate)
                .add("body", xmlBody)
                .add("altText", altText)
                .add("mediaType", mediaType)
                .add("width", width)
                .add("height", height)
                .add("internalDataUrl", internalDataUrl)
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
                && Objects.equal(this.contentOrigin, that.contentOrigin)
                && Objects.equal(this.xmlBody, that.xmlBody) // TODO maybe this could be better. The strings could be equivalent as xml even though they are different strings
                && Objects.equal(this.publishedDate, that.publishedDate)
                && Objects.equal(this.altText, that.altText)
                && Objects.equal(this.mediaType, that.mediaType)
                && Objects.equal(this.width, that.width)
                && Objects.equal(this.height, that.height)
                && Objects.equal(this.internalDataUrl, that.internalDataUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, byline, brands, contentOrigin, uuid, publishedDate, xmlBody, altText, mediaType, width, height, internalDataUrl);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID uuid;
        private String title;
        private String byline;
        private SortedSet<Brand> brands;
        private Date publishedDate;
        private String xmlBody;
        private ContentOrigin contentOrigin;
        private String altText;
        private String mediaType;
        private Integer width;
        private Integer height;
        private String internalDataUrl;

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

        public Builder withBrands(SortedSet<Brand> brands) {
            this.brands = brands;
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

        public Builder withContentOrigin(String originatingSystem, String originatingIdentifier) {
            this.contentOrigin = new ContentOrigin(originatingSystem, originatingIdentifier);
            return this;
        }

        public Builder withAltText(String altText) {
            this.altText = altText;
            return this;
        }

        public Builder withMediaType(String mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public Builder withWidth(Integer width) {
            this.width = width;
            return this;
        }

        public Builder withHeight(Integer height) {
            this.height = height;
            return this;
        }

        public Builder withInternalDataUrl(String internalDataUrl) {
            this.internalDataUrl = internalDataUrl;
            return this;
        }

        public Builder withValuesFrom(Content content) {
            String originatingSystem = (content.getContentOrigin() != null) ? content.getContentOrigin().getOriginatingSystem() : null;
            String originatingIdentifier = (content.getContentOrigin() != null) ? content.getContentOrigin().getOriginatingIdentifier() : null;

            return withTitle(content.getTitle())
            		.withByline(content.getByline())
            		.withBrands(content.getBrands())
            		.withContentOrigin(originatingSystem, originatingIdentifier)
                    .withUuid(UUID.fromString(content.getUuid()))
                    .withPublishedDate(content.getPublishedDate())
                    .withXmlBody(content.getBody())
                    .withAltText(content.getAltText())
                    .withMediaType(content.getMediaType())
                    .withWidth(content.getWidth())
                    .withHeight(content.getHeight())
                    .withInternalDataUrl(content.getInternalDataUrl());
        }

        public Content build() {
            return new Content(uuid, title, byline, brands, contentOrigin, publishedDate, xmlBody, altText, mediaType, width, height, internalDataUrl);
        }
    }

}
