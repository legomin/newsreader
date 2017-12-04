package org.legomin.newsreader.wrapper.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.legomin.newsreader.domain.Concept;
import org.legomin.newsreader.domain.ConceptPosition;
import org.legomin.newsreader.wrapper.FeedsWrapper;
import org.legomin.newsreader.wrapper.impl.exception.IllegalCrawlerOutputException;
import org.legomin.newsreader.wrapper.impl.exception.IllegalExtractorOututException;
import org.legomin.newsreader.wrapper.impl.exception.NoSuchConceptException;

/**
 * Wrapper test
 */
public class DefaultFeedsWrapperImplTest {

  private final FeedsWrapper wrapper = new DefaultFeedsWrapperImpl();

  private final List<ConceptPosition> extractorOutput = new ArrayList<>();

  @Test
  public void testWrapFeedSucceed() throws Exception {
    final String crawlerOutput = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";
    extractorOutput.add(new ConceptPosition(14, 22, Concept.ENTITY));
    extractorOutput.add(new ConceptPosition(0, 5, Concept.ENTITY));
    extractorOutput.add(new ConceptPosition(55, 67, Concept.TWITTER_USERNAME));
    extractorOutput.add(new ConceptPosition(37, 54, Concept.LINK));

    final String expectedOutput = "<strong>Obama</strong> visited <strong>Facebook</strong> headquarters: <a " +
      "href=\"http://bit.ly/xyz\">http://bit.ly/xyz</a> @ <a href=\"http://twitter.com/elversatile\">elversatile</a>";
    final String actualOutput = wrapper.wrapFeed(crawlerOutput, extractorOutput);

    assertEquals("Unexpected output", expectedOutput, actualOutput);
  }

  @Test(expected = NoSuchConceptException.class)
  public void noConceptionFail() throws Exception {
    final String crawlerOutput = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";
    extractorOutput.add(new ConceptPosition(14, 22, Concept.HASHTAG));
    wrapper.wrapFeed(crawlerOutput, extractorOutput);
  }

  @Test(expected = IllegalCrawlerOutputException.class)
  public void illegalCrawlerOutputFail() throws Exception {
    final String crawlerOutput = null;
    extractorOutput.add(new ConceptPosition(0, 5, Concept.ENTITY));
    wrapper.wrapFeed(crawlerOutput, extractorOutput);
  }

  @Test(expected = IllegalExtractorOututException.class)
  public void IndexOutOfBoundFail() throws Exception {
    final String crawlerOutput = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";
    extractorOutput.add(new ConceptPosition(55, 68, Concept.TWITTER_USERNAME));
    wrapper.wrapFeed(crawlerOutput, extractorOutput);
  }

  @Test(expected = IllegalExtractorOututException.class)
  public void WrongIndexesFail() throws Exception {
    final String crawlerOutput = "Obama visited Facebook headquarters: http://bit.ly/xyz @elversatile";
    extractorOutput.add(new ConceptPosition(58, 57, Concept.TWITTER_USERNAME));
    wrapper.wrapFeed(crawlerOutput, extractorOutput);
  }

}
