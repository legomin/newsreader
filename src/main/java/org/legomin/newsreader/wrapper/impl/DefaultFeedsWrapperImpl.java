package org.legomin.newsreader.wrapper.impl;

import static org.legomin.newsreader.wrapper.impl.ConceptWrapperSimpleFactory.getWrapper;

import java.util.List;

import org.legomin.newsreader.domain.ConceptPosition;
import org.legomin.newsreader.wrapper.FeedsWrapper;

/**
 * Main `Wrapper` implementation
 */
public class DefaultFeedsWrapperImpl implements FeedsWrapper {

  /**
   * maim wrapping functiom
   *
   * consequently applies wrapping to feed
   * concrete wrapper is got from fabric
   *
   * @param feed - the feed to be wrapped
   * @param positions - list of positions those need to be wrapped
   * @return - wrapped string
   */
  public String wrapFeed(final Feed feed, final List<ConceptPosition> positions) {
    for (final ConceptPosition position : positions) {
      final String wrappedData = getWrapper(position.getConcept())
        .wrap(feed.getChunk(position.getBeginPosition(), position.getEndPosition()));
      feed.wrapChunk(position.getBeginPosition(), position.getEndPosition(), wrappedData);
    }
    return feed.getWrapped();
  }

  public String wrapFeed(String feed, List<ConceptPosition> positions) {
    return wrapFeed(new Feed(feed), positions);
  }

}
