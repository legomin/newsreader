package org.legomin.newsreader.wrapper.impl.exception;

/**
 * Exception-marker class for `Extractor output`
 *
 * will be thrown when indexes are incorrect (begin > end or end > input.lenght e.t.c.)
 */
public class IllegalExtractorOututException extends RuntimeException {

  public IllegalExtractorOututException(String message) {
    super(message);
  }
}
