package org.legomin.newsreader.extractor;

import java.util.List;

import org.legomin.newsreader.domain.ConceptPosition;

/**
 * Challenge 2-nd module interface
 */
public interface ConceptsExtarctor {

  List<ConceptPosition> extractConcepts(String input);

}
