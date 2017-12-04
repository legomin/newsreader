package org.legomin.newsreader.domain;

import static java.util.Objects.requireNonNull;

/**
 * `Extractor` output class
 */
public class ConceptPosition {
  private final int beginPosition;
  private final int endPosition;
  private final Concept concept;

  public ConceptPosition(final Integer beginPosition, final Integer endPosition, final Concept concept) {
    this.beginPosition = requireNonNull(beginPosition);
    this.endPosition = requireNonNull(endPosition);
    this.concept = concept;
  }

  @Override
  public String toString() {
    return "positions " + beginPosition + " through " + endPosition + " -> " + concept.getAlias();
  }

  public int getBeginPosition() {
    return beginPosition;
  }

  public int getEndPosition() {
    return endPosition;
  }

  public Concept getConcept() {
    return concept;
  }

}
