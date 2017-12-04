package org.legomin.newsreader.wrapper.impl.exception;

/**
 * Exception marker class for not implemented concepts
 *
 * will be thrown either there is concept & no it's implementation
 * or concept returned by `Extractor` not exist in `Concept` enum
 */
public class NoSuchConceptException extends RuntimeException {

  public NoSuchConceptException(String message) {
    super(message);
  }
}
