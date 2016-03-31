package com.ft.content.model;

import com.google.common.collect.ImmutableSortedSet;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ContentTest {

    private Content content;

    @Before
    public void setUp() throws Exception {
        content = Content.builder()
                .withTitle("a headline")
                .withByline("By someone")
                .withBrands(ImmutableSortedSet.of(new Brand("Brand1"), new Brand("Brand2")))
                .withIdentifiers(ImmutableSortedSet.of(new Identifier("IdentifierAuthority1", "IdentifierValue1"), new Identifier("IdentifierAuthority2", "IdentifierValue2")))
                .withPublishedDate(new Date(300L))
                .withUuid(UUID.randomUUID())
                .withXmlBody("The body")
                .withMembers(ImmutableSortedSet.of(new Member("member1"), new Member("member2")))
                .withMainImage(UUID.randomUUID().toString())
                .withComments(new Comments(true))
                .withStandout(new Standout(true, true, true))
                .withPublishReference("test")
                .withLastModified(new Date(290L))
                .withExternalBinaryUrl("http://com.ft.imagepublish.prod.s3.amazonaws.com/12a9a540-8124-11e4-896c-00144feabdc0")
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
        SortedSet<Brand> brands = ImmutableSortedSet.of(new Brand("Different Brand"));

        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withBrands(brands)
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentIdentifierAuthoritiesAreNotEqual() {
        SortedSet<Identifier> identifiers = ImmutableSortedSet.of(new Identifier("Different authority", "IdentifierValue1"), new Identifier("IdentifierAuthority2", "IdentifierValue2"));

        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withIdentifiers(identifiers)
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentIdentifierValuesAreNotEqual() {
        SortedSet<Identifier> identifiers = ImmutableSortedSet.of(new Identifier("IdentifierAuthority1", "Different id"), new Identifier("IdentifierAuthority2", "IdentifierValue2"));

        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withIdentifiers(identifiers)
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
    public void contentWithDifferentLastModifiedDatesAreNotEqual() {
        final Content otherContent = Content.builder()
                .withLastModified(new Date(content.getPublishedDate().getTime() + 100))
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
    public void contentWithDifferentInternalBinaryUrlsAreNotEqual() {
        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withInternalBinaryUrl("api.ft.com/thing/etc")
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentExternalBinaryUrlsAreNotEqual() {
        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withExternalBinaryUrl("someExternalBinaryUrl")
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentMembersAreNotEqual() {
        SortedSet<Member> members = ImmutableSortedSet.of(new Member("Different member"));

        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withMembers(members)
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentMainImageAreNotEqual() {
        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withMainImage(UUID.randomUUID().toString())
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

    @Test
    public void contentWithDifferentCommentsAreNotEqual() {
        final Content otherContent = Content.builder()
                .withValuesFrom(content)
                .withComments(new Comments(false))
                .build();

        assertThat(content, is(not(equalTo(otherContent))));
    }

	@Test
	public void contentWithDifferentCopyrightsAreNotEqual() {
		final Content otherContent = Content.builder()
				.withValuesFrom(content)
				.withCopyright(Copyright.noticeOnly("Simon"))
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
    
    @Test
    public void shouldSortTitlesShortestFirst() {
    	String shortest = "zzz";
    	String middle = "aaaaaa";
    	String longest = "mmmmmmmmmmmm";
    	
    	Content content = Content.builder().withTitles(Arrays.asList(middle, longest, shortest)).build();
    	
    	List<String> titles = content.getTitles();
    	
    	assertThat(titles.size(), is(3));
    	assertThat(titles.get(0), is(equalTo(shortest)));
    	assertThat(titles.get(1), is(equalTo(middle)));
    	assertThat(titles.get(2), is(equalTo(longest)));

    }

    @Test
    public void shouldStorePublishReference() {
        assertThat(content.getPublishReference(),is("test"));
    }

    @Test
    public void shouldDifferentiateBasedOnPublishReference() {

        Content clone = Content.builder().withValuesFrom(content).withPublishReference("test2").build();

        assertNotEquals(content,clone);
        assertNotEquals(content.hashCode(),clone.hashCode());
        assertNotEquals(content.toString(), clone.toString());
    }

    @Test
    public void shouldClonePublishReference() {
        Content clone = Content.builder().withValuesFrom(content).build();
        assertThat(clone.getPublishReference(),is("test"));
    }

    @Test
    public void shouldStoreStandoutSection() {
        assertThat(content.getStandout(), is(new Standout(true, true, true)));
    }
}
