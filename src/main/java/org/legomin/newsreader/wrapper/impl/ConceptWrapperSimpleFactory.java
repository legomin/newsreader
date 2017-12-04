package org.legomin.newsreader.wrapper.impl;

import java.util.HashMap;
import java.util.Map;

import org.legomin.newsreader.domain.Concept;
import org.legomin.newsreader.wrapper.impl.exception.NoSuchConceptException;
import org.legomin.newsreader.wrapper.impl.feedsWrapperImpl.EntityConceptWrapperImpl;
import org.legomin.newsreader.wrapper.impl.feedsWrapperImpl.LinkConceptWrapperImpl;
import org.legomin.newsreader.wrapper.impl.feedsWrapperImpl.TwitterUsernameConceptWrapperImpl;

/**
 * Simple fabric class for producing wrappers for existing concepts
 *
 * There no info about is it effective to storage wrappers or create them as it needed, depends on context))
 *
 */
public class ConceptWrapperSimpleFactory {

  private ConceptWrapperSimpleFactory() {
    throw new IllegalStateException();
  }

  private static Map<Concept, ConceptWrapper> wrappers;

  static {
    wrappers = new HashMap<>();
    for (Concept concept : Concept.values()) {
      final ConceptWrapper wrapper;
      switch (concept) {
        case ENTITY:
          wrapper = new EntityConceptWrapperImpl();
          break;

        case LINK:
          wrapper = new LinkConceptWrapperImpl();
          break;

        case TWITTER_USERNAME:
          wrapper = new TwitterUsernameConceptWrapperImpl();
          break;

        default:
          continue;
      }
      wrappers.put(concept, wrapper);
    }
  }

  public static ConceptWrapper getWrapper(final Concept concept) {

    if (concept == null) {
      throw new NoSuchConceptException("Concept is null");
    }
    final ConceptWrapper wrapper = wrappers.get(concept);
    if (wrapper == null) {
      throw new NoSuchConceptException(concept.getAlias());
    }
    return wrapper;
  }

}
