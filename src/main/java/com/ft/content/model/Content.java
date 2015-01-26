package com.ft.content.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import org.hibernate.validator.constraints.NotEmpty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class Content {

    private final String uuid;
    private final String title;
    private final List<String> titles;
    private final String byline;
    private final SortedSet<Brand> brands;
    private final Date publishedDate;
    private final String body;
    private final ContentOrigin contentOrigin;
    private final String description;
    private final String mediaType;
    private final Integer pixelWidth;
    private final Integer pixelHeight;
    private final String internalBinaryUrl;
    private final SortedSet<Member> members;
    private final String associatedContent;

    public Content(@JsonProperty("uuid") UUID uuid,
                   @JsonProperty("title") String title,
                   @JsonProperty("titles") List<String> titles,
                   @JsonProperty("byline") String byline,
                   @JsonProperty("brands") SortedSet<Brand> brands,
                   @JsonProperty("contentOrigin") ContentOrigin contentOrigin,
                   @JsonProperty("publishedDate") Date publishedDate,
                   @JsonProperty("body") String body,
                   @JsonProperty("description") String description,
                   @JsonProperty("mediaType") String mediaType,
                   @JsonProperty("pixelWidth") Integer pixelWidth,
                   @JsonProperty("pixelHeight") Integer pixelHeight,
                   @JsonProperty("internalBinaryUrl") String internalBinaryUrl,
                   @JsonProperty("members") SortedSet<Member> members,
                   @JsonProperty("associatedContent") String associatedContent) {
        this.body = body;
        this.uuid = uuid == null ? null : uuid.toString();
        this.title = title;
        this.titles = titles;
        this.byline = byline;
        this.brands = brands;
        this.publishedDate = publishedDate;
        this.contentOrigin = contentOrigin;
        this.description = description;
        this.mediaType = mediaType;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
        this.internalBinaryUrl = internalBinaryUrl;
        this.members = members;
        this.associatedContent = associatedContent;
    }

    @NotNull
    public String getUuid() {
        return uuid;
    }

    @NotEmpty
    public String getTitle() {
        return title;
    }
    
    public List<String> getTitles() {
    	return titles;
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
        return body;
    }

    @NotNull
    public ContentOrigin getContentOrigin() {
        return contentOrigin;
    }

    public String getDescription() {
        return description;
    }

    public String getMediaType() {
        return mediaType;
    }

    public Integer getPixelWidth() {
        return pixelWidth;
    }

    public Integer getPixelHeight() {
        return pixelHeight;
    }

    public String getInternalBinaryUrl() {
        return internalBinaryUrl;
    }

    public SortedSet<Member> getMembers() {
        return members;
    }

    public String getAssociatedContent() {
        return associatedContent;
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
                .add("body", body)
                .add("description", description)
                .add("mediaType", mediaType)
                .add("pixelWidth", pixelWidth)
                .add("pixelHeight", pixelHeight)
                .add("internalBinaryUrl", internalBinaryUrl)
                .add("members", members)
                .add("associatedContent", associatedContent)
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
                && Objects.equal(this.body, that.body) // TODO maybe this could be better. The strings could be equivalent as xml even though they are different strings
                && Objects.equal(this.publishedDate, that.publishedDate)
                && Objects.equal(this.description, that.description)
                && Objects.equal(this.mediaType, that.mediaType)
                && Objects.equal(this.pixelWidth, that.pixelWidth)
                && Objects.equal(this.pixelHeight, that.pixelHeight)
                && Objects.equal(this.internalBinaryUrl, that.internalBinaryUrl)
                && Objects.equal(this.members, that.members)
                && Objects.equal(this.associatedContent, that.associatedContent);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, byline, brands, contentOrigin, uuid, publishedDate, body, description, mediaType, pixelWidth, pixelHeight, internalBinaryUrl, members, associatedContent);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID uuid;
        private String title;
        private List<String> titles;
        private String byline;
        private SortedSet<Brand> brands;
        private Date publishedDate;
        private String body;
        private ContentOrigin contentOrigin;
        private String description;
        private String mediaType;
        private Integer pixelWidth;
        private Integer pixelHeight;
        private String internalBinaryUrl;
        private SortedSet<Member> members;
        private String associatedContent;

        public Builder withUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withTitles(List<String> titles) {
        	this.titles = titles;
        	if(titles != null) {
        		Collections.sort(titles, new LengthComparator());
        	}
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

        public Builder withXmlBody(String body) {
            this.body = body;
            return this;
        }

        public Builder withContentOrigin(String originatingSystem, String originatingIdentifier) {
            this.contentOrigin = new ContentOrigin(originatingSystem, originatingIdentifier);
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withMediaType(String mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public Builder withPixelWidth(Integer pixelWidth) {
            this.pixelWidth = pixelWidth;
            return this;
        }

        public Builder withPixelHeight(Integer pixelHeight) {
            this.pixelHeight = pixelHeight;
            return this;
        }

        public Builder withInternalBinaryUrl(String internalDataUrl) {
            this.internalBinaryUrl = internalDataUrl;
            return this;
        }

        public Builder withMembers(SortedSet<Member> members) {
            this.members = members;
            return this;
        }

        public Builder withAssociatedContent(String associatedContent) {
            this.associatedContent = associatedContent;
            return this;
        }

        public Builder withValuesFrom(Content content) {
            String originatingSystem = (content.getContentOrigin() != null) ? content.getContentOrigin().getOriginatingSystem() : null;
            String originatingIdentifier = (content.getContentOrigin() != null) ? content.getContentOrigin().getOriginatingIdentifier() : null;

            return withTitle(content.getTitle())
            		.withTitles(content.getTitles())
            		.withByline(content.getByline())
            		.withBrands(content.getBrands())
            		.withContentOrigin(originatingSystem, originatingIdentifier)
                    .withUuid(UUID.fromString(content.getUuid()))
                    .withPublishedDate(content.getPublishedDate())
                    .withXmlBody(content.getBody())
                    .withDescription(content.getDescription())
                    .withMediaType(content.getMediaType())
                    .withPixelWidth(content.getPixelWidth())
                    .withPixelHeight(content.getPixelHeight())
                    .withInternalBinaryUrl(content.getInternalBinaryUrl())
                    .withMembers(content.getMembers())
                    .withAssociatedContent(content.getAssociatedContent());
        }

		public Content build() {
            return new Content(uuid, title, titles, byline, brands, contentOrigin, publishedDate, body, description, mediaType, pixelWidth, pixelHeight, internalBinaryUrl, members, associatedContent);
        }
    }

    private static final class LengthComparator implements Comparator<String>{
		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
    }
    
}
