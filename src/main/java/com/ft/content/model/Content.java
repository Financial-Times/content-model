package com.ft.content.model;

import java.net.URI;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;

import org.hibernate.validator.constraints.NotEmpty;

public class Content {

    private final String uuid;
    private final String title;
    private final List<String> titles;
    private final AlternativeTitles alternativeTitles;
    private final String byline;
    private final SortedSet<Brand> brands;
    private final Date publishedDate;
    private final String standfirst;
    private final String body;
    private final SortedSet<Identifier> identifiers;
    private final String description;
    private final String mediaType;
    private final Integer pixelWidth;
    private final Integer pixelHeight;
    private final String internalBinaryUrl;
    private final String externalBinaryUrl;
    private final SortedSet<Member> members;
    private final String mainImage;
    private final Standout standout;
    private final Comments comments;
    private final Copyright copyright;
    private final String publishReference;
    private final Date lastModified;
    private final URI webUrl;

    public Content(@JsonProperty("uuid") UUID uuid,
                   @JsonProperty("title") String title,
                   @JsonProperty("titles") List<String> titles,
                   @JsonProperty("alternativeTitles") AlternativeTitles alternativeTitles,
                   @JsonProperty("byline") String byline,
                   @JsonProperty("brands") SortedSet<Brand> brands,
                   @JsonProperty("identifiers") SortedSet<Identifier> identifiers,
                   @JsonProperty("publishedDate") Date publishedDate,
                   @JsonProperty("standfirst") String standfirst,
                   @JsonProperty("body") String body,
                   @JsonProperty("description") String description,
                   @JsonProperty("mediaType") String mediaType,
                   @JsonProperty("pixelWidth") Integer pixelWidth,
                   @JsonProperty("pixelHeight") Integer pixelHeight,
                   @JsonProperty("internalBinaryUrl") String internalBinaryUrl,
                   @JsonProperty("externalBinaryUrl") String externalBinaryUrl,
                   @JsonProperty("members") SortedSet<Member> members,
                   @JsonProperty("mainImage") String mainImage,
                   @JsonProperty("standout") Standout standout,
                   @JsonProperty("comments") Comments comments,
                   @JsonProperty("copyright") Copyright copyright,
                   @JsonProperty("webUrl") URI webUrl,
                   @JsonProperty("publishReference") String publishReference,
                   @JsonProperty("lastModified") Date lastModified) {
        this.identifiers = identifiers;
        this.body = body;
        this.standout = standout;
        this.comments = comments;
        this.uuid = uuid == null ? null : uuid.toString();
        this.title = title;
        this.titles = titles;
        this.alternativeTitles = alternativeTitles;
        this.byline = byline;
        this.standfirst = standfirst;
        this.brands = brands;
        this.publishedDate = publishedDate;
        this.description = description;
        this.mediaType = mediaType;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
        this.internalBinaryUrl = internalBinaryUrl;
        this.externalBinaryUrl = externalBinaryUrl;
        this.members = members;
        this.mainImage = mainImage;
		this.copyright = copyright;
        this.webUrl = webUrl;
        this.publishReference = publishReference;
        this.lastModified = lastModified;
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
    
    public AlternativeTitles getAlternativeTitles() {
        return alternativeTitles;
    }
    
    public String getByline() {
        return byline;
    }

    public SortedSet<Brand> getBrands() {
        return brands;
    }


    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    public Date getPublishedDate() {
        return publishedDate;
    }
    
    public String getStandfirst() {
        return standfirst;
    }
    
    public String getBody() {
        return body;
    }

    public SortedSet<Identifier> getIdentifiers() {
        return identifiers;
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

    public String getExternalBinaryUrl() {
        return externalBinaryUrl;
    }

    public SortedSet<Member> getMembers() {
        return members;
    }

    public String getMainImage() {
        return mainImage;
    }

    public Comments getComments() {
        return comments;
    }

    public Standout getStandout() {
        return standout;
    }

	public Copyright getCopyright() {
		return copyright;
	}

    public URI getWebUrl() {
        return webUrl;
    }

    public String getPublishReference() {
        return publishReference;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    public Date getLastModified() {
        return lastModified;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("uuid", uuid)
                .add("title", title)
                .add("alternativeTitles", alternativeTitles)
                .add("byline", byline)
                .add("brands", brands)
                .add("identifiers", identifiers)
                .add("publishedDate", publishedDate)
                .add("standfirst", standfirst)
                .add("body", body)
                .add("description", description)
                .add("mediaType", mediaType)
                .add("pixelWidth", pixelWidth)
                .add("pixelHeight", pixelHeight)
                .add("internalBinaryUrl", internalBinaryUrl)
                .add("externalBinaryUrl", externalBinaryUrl)
                .add("members", members)
                .add("mainImage", mainImage)
                .add("comments", comments)
                .add("standout", standout)
                .add("webUrl", webUrl)
                .add("publishReference", publishReference)
                .add("lastModified", lastModified)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content that = (Content) o;

        return Objects.equals(this.uuid, that.uuid)
                && Objects.equals(this.title, that.title)
                && Objects.equals(this.alternativeTitles, that.alternativeTitles)
                && Objects.equals(this.byline, that.byline)
                && Objects.equals(this.brands, that.brands)
                && Objects.equals(this.identifiers, that.identifiers)
                && Objects.equals(this.standfirst,  that.standfirst)
                && Objects.equals(this.body, that.body) // TODO maybe this could be better. The strings could be equivalent as xml even though they are different strings
                && Objects.equals(this.publishedDate, that.publishedDate)
                && Objects.equals(this.description, that.description)
                && Objects.equals(this.mediaType, that.mediaType)
                && Objects.equals(this.pixelWidth, that.pixelWidth)
                && Objects.equals(this.pixelHeight, that.pixelHeight)
                && Objects.equals(this.internalBinaryUrl, that.internalBinaryUrl)
                && Objects.equals(this.externalBinaryUrl, that.externalBinaryUrl)
                && Objects.equals(this.members, that.members)
                && Objects.equals(this.mainImage, that.mainImage)
                && Objects.equals(this.comments, that.comments)
                && Objects.equals(this.standout, that.standout)
                && Objects.equals(this.copyright, that.copyright)
                && Objects.equals(this.publishReference, that.publishReference)
                && Objects.equals(this.lastModified, that.lastModified)
                && Objects.equals(this.webUrl, that.webUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, alternativeTitles, byline, brands, identifiers, uuid, publishedDate, standfirst, body, description, mediaType, pixelWidth, pixelHeight, internalBinaryUrl, externalBinaryUrl, members, mainImage, comments, standout, publishReference, lastModified);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID uuid;
        private String title;
        private List<String> titles;
        private AlternativeTitles alternativeTitles;
        private String byline;
        private SortedSet<Brand> brands;
        private Date publishedDate;
        private String standfirst;
        private String body;
        private SortedSet<Identifier> identifiers;
        private String description;
        private String mediaType;
        private Integer pixelWidth;
        private Integer pixelHeight;
        private String internalBinaryUrl;
        private String externalBinaryUrl;
        private SortedSet<Member> members;
        private String mainImage;
        private Comments comments;
        private Standout standout;
        private Copyright copyright;
        private URI webUrl;
        private String transactionId;
        private Date lastModified;

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
            if (titles != null) {
                Collections.sort(titles, new LengthComparator());
            }
            return this;
        }
        
        public Builder withAlternativeTitles(AlternativeTitles titles) {
          this.alternativeTitles = titles;
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
        
        public Builder withStandfirst(String standfirst) {
            this.standfirst = Strings.emptyToNull(standfirst);
            return this;
        }
        
        public Builder withXmlBody(String body) {
            this.body = body;
            return this;
        }

        public Builder withIdentifiers(SortedSet<Identifier> identifiers) {
            this.identifiers = identifiers;
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

        public Builder withExternalBinaryUrl(String externalBinaryUrl) {
            this.externalBinaryUrl = externalBinaryUrl;
            return this;
        }

        public Builder withMembers(SortedSet<Member> members) {
            this.members = members;
            return this;
        }

        public Builder withMainImage(String mainImage) {
            this.mainImage = mainImage;
            return this;
        }

        public Builder withComments(Comments comments) {
            this.comments = comments;
            return this;
        }

        public Builder withStandout(Standout standout) {
            this.standout = standout;
            return this;
        }

		public Builder withCopyright(Copyright copyright) {
			this.copyright = copyright;
			return this;
		}

        public Builder withPublishReference(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder withWebUrl(URI webUrl){
            this.webUrl = webUrl;
            return this;
        }

        public Builder withLastModified(Date lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        public Builder withValuesFrom(Content content) {
            return withTitle(content.getTitle())
            		.withTitles(content.getTitles())
            		.withAlternativeTitles(content.getAlternativeTitles())
            		.withByline(content.getByline())
            		.withStandfirst(content.getStandfirst())
            		.withBrands(content.getBrands())
                    .withIdentifiers(content.getIdentifiers())
                    .withUuid(UUID.fromString(content.getUuid()))
                    .withPublishedDate(content.getPublishedDate())
                    .withXmlBody(content.getBody())
                    .withDescription(content.getDescription())
                    .withMediaType(content.getMediaType())
                    .withPixelWidth(content.getPixelWidth())
                    .withPixelHeight(content.getPixelHeight())
                    .withInternalBinaryUrl(content.getInternalBinaryUrl())
                    .withExternalBinaryUrl(content.getExternalBinaryUrl())
                    .withMembers(content.getMembers())
                    .withMainImage(content.getMainImage())
                    .withComments(content.getComments())
                    .withStandout(content.getStandout())
                    .withCopyright(content.getCopyright())
                    .withWebUrl(content.getWebUrl())
                    .withPublishReference(content.getPublishReference())
                    .withLastModified(content.getLastModified());
        }

		public Content build() {
		  if (alternativeTitles == null) {
		    alternativeTitles = AlternativeTitles.builder().build();
		  }
		  
          return new Content(uuid,
              title, titles, AlternativeTitles.builder().withValuesFrom(alternativeTitles).build(),
              byline, brands, identifiers, publishedDate,
              standfirst, body, description,
              mediaType,
              pixelWidth, pixelHeight, internalBinaryUrl, externalBinaryUrl,
              members, mainImage,
              standout, comments, copyright, webUrl, transactionId, lastModified);
        }
    }

    private static final class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

}
