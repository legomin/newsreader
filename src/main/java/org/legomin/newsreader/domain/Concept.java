package org.legomin.newsreader.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for concepts those can be handled by `Wrapper`
 */
public enum Concept {
  ENTITY("Entity"),
  LINK("Link"),
  TWITTER_USERNAME("Twitter username"),
  //this is here for test goal only
  HASHTAG("Hashtag");

  private static Map<String, Concept> mapByAlias = mapByAlias();

  private final String alias;

  Concept(String alias) {
    this.alias = alias;
  }

  public String getAlias() {
    return alias;
  }

  public static Concept byAlias(final String alias) {
    return mapByAlias.get(alias);
  }

  private static Map<String, Concept> mapByAlias() {
    final Map<String, Concept> result = new HashMap<>();
    for (Concept value: values()) {
      result.put(value.getAlias(), value);
    }
    return result;
  }

}
