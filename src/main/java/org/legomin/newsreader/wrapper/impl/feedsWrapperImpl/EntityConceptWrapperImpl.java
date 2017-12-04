package org.legomin.newsreader.wrapper.impl.feedsWrapperImpl;

import org.legomin.newsreader.wrapper.impl.ConceptWrapper;

/**
 * Entity wrapping rule
 */
public class EntityConceptWrapperImpl implements ConceptWrapper {

  public String wrap(String input) {
    return "<strong>" + input + "</strong>";
  }
}
