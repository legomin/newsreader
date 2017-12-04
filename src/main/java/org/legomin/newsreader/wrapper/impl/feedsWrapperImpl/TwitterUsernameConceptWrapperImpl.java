package org.legomin.newsreader.wrapper.impl.feedsWrapperImpl;

import org.legomin.newsreader.wrapper.impl.ConceptWrapper;

/**
 * Twitter username wrapping rule
 */
public class TwitterUsernameConceptWrapperImpl implements ConceptWrapper {

  public String wrap(String input) {
    final String stringwithoutDog = input.substring(1);
    return input.charAt(0) + " <a href=\"http://twitter.com/" + stringwithoutDog + "\">" + stringwithoutDog + "</a>";
  }
}
