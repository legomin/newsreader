package org.legomin.newsreader.wrapper;

import java.util.List;

import org.legomin.newsreader.domain.ConceptPosition;

/**
 * Challenge 3-d module interface
 */
public interface FeedsWrapper {

  String wrapFeed(String feed, List<ConceptPosition> positions);

}
