package org.legomin.newsreader.wrapper.impl.feedsWrapperImpl;

import org.legomin.newsreader.wrapper.impl.ConceptWrapper;

/**
 * Link wrapping rule
 */
public class LinkConceptWrapperImpl implements ConceptWrapper {

  public String wrap(String input) {
    return "<a href=\"" + input + "\">" + input + "</a>";
  }
}
