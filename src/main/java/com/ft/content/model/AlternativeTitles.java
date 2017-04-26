package com.ft.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.Objects;

public class AlternativeTitles {

  private final String promotionalTitle;
  private final String contentPackageTitle;

  public static Builder builder() {
    return new Builder();
  }
  
  private AlternativeTitles(
      @JsonProperty("promotionalTitle") String promotionalTitle,
      @JsonProperty("contentPackageTitle") String contentPackageTitle) {
    this.promotionalTitle = promotionalTitle;
    this.contentPackageTitle = contentPackageTitle;
  }
  
  public String getPromotionalTitle() {
    return promotionalTitle;
  }

  public String getContentPackageTitle() {
    return contentPackageTitle;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("promotionalTitle", promotionalTitle)
        .add("contentPackageTitle", contentPackageTitle)
        .toString();
  }
  
  @Override
  public boolean equals(Object o) {
    if ((o == null) || (o.getClass() != AlternativeTitles.class)) {
      return false;
    }
    
    final AlternativeTitles that = (AlternativeTitles)o;

    return
        Objects.equals(this.promotionalTitle, that.promotionalTitle) &&
        Objects.equals(this.contentPackageTitle, that.contentPackageTitle);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(promotionalTitle, contentPackageTitle);
  }
  
  public static class Builder {

    private String promotionalTitle;

    private String contentPackageTitle;

    public Builder withPromotionalTitle(String title) {
        this.promotionalTitle = title;
        return this;
    }

    public Builder withContentPackageTitle(String title) {
        this.contentPackageTitle = title;
        return this;
    }

    public Builder withValuesFrom(AlternativeTitles titles) {
      return
          withPromotionalTitle(titles.getPromotionalTitle()).
              withContentPackageTitle(titles.getContentPackageTitle());
    }

    public AlternativeTitles build() {
        return new AlternativeTitles(promotionalTitle, contentPackageTitle);
    }
  }
}
