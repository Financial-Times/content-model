package com.ft.content.model;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.UUID;

import com.google.common.collect.ImmutableSortedSet;
import org.junit.Before;
import org.junit.Test;

public class ContentTest {

    private Content content;

    @Before
    public void setUp() throws Exception {
        content = Content.builder()
                .withTitle("a headline")
                .withByline("By someone")
                .withBrands(ImmutableSortedSet.of(new Brand("Brand1"), new Brand("Brand2")))
                .withContentOrigin("OriginatingSystem", "id")
                .withPublishedDate(new Date(300L))
                .withUuid(UUID.randomUUID())
                .withXmlBody("The body")
                .build();
    }

    @Test
    public void cannotEqualNull() {
        assertFalse("an object should not equal null", content.equals(null));
    }

    @Test
    public void cannotEqualOtherClass() {
        assertFalse("an instance of Content should not be equal to an instance of Object", content.equals(new Object()));
    }

    @Test
    public void equalsIsReflexive() {
        assertTrue("equals must be reflexive", content.equals(content));
    }

    @Test
    public void contentWithDifferentUuidsAreNotEqual() {
        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withUuid(UUID.randomUUID())
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentTitlesAreNotEqual() {
        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withTitle("headline 2")
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentBylinesAreNotEqual() {
        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withByline("By someone else")
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentBrandsAreNotEqual() {
        ImmutableSortedSet<Brand> brands = ImmutableSortedSet.of(new Brand("Different Brand"));

        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withBrands(brands)
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentOriginatingSystemsAreNotEqual() {
        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withContentOrigin("different OriginatingSystem", "id")
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentOriginatingIdentifiersAreNotEqual() {
        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withContentOrigin("OriginatingSystem", "different id")
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentPublishDatesAreNotEqual() {
        final Content otherContent = Content.builder()
                .withPublishedDate(new Date(content.getPublishedDate().getTime() + 100))
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentBodiesAreNotEqual() {
        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withXmlBody("a different body")
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentInternalUrlsAreNotEqual() {
        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withInternalDataUrl("http://internal.ft.com/thing/etc")
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithSameFieldsAreEqual() {

        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .build();

        assertThat(content, is(equalTo(otherContent)));
    }

}
