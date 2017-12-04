package org.legomin.newsreader.wrapper.impl.exception;

/**
 * Exception-marker class for invalid `Crawler` output
 *
 * now will be thrown only on null value
 */
public class IllegalCrawlerOutputException extends RuntimeException {

  public IllegalCrawlerOutputException(String message) {
    super(message);
  }
}
