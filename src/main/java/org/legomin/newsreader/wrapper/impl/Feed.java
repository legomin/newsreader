package org.legomin.newsreader.wrapper.impl;

import org.legomin.newsreader.wrapper.impl.exception.IllegalCrawlerOutputException;
import org.legomin.newsreader.wrapper.impl.exception.IllegalExtractorOututException;

/**
 * Data structure for module input
 *
 * Initialises as array containing chars as strings from input string
 * During wrapping chars of wrapping part replaced as:
 *  - 1-st char replaced by wrapped string
 *  - others replaced by empty string
 *
 *  F.e. `qwerty` - > String[]{"q", "w", "e", "r", "t", "y"}
 *  wrap "ert" to "<strong>ert</strong>"
 *  the result will be {"q", "w", "<strong>er</strong>", "", "", "y"}
 *
 */
class Feed {

  private final String[] data;
  private final String stringData;

  Feed(final String stringFeed) {
    if (stringFeed == null) {
      throw new IllegalCrawlerOutputException("Have not to be null!");
    }
    this.stringData = stringFeed;
    this.data = new String[stringFeed.length()];
    for (int i = 0; i < stringFeed.length(); i++) {
      data[i] = String.valueOf(stringFeed.charAt(i));
    }
  }

  void wrapChunk(final int beginPos, final int endPos, final String data) {
    if (endPos < beginPos || endPos > stringData.length() || data == null) {
      throw new IllegalExtractorOututException("Illegal data, requested position begin " + beginPos + ", end: "
        + endPos + ", data:" + data + ", input lenght: " + stringData.length());
    }
    checkValue(this.data[beginPos]);
    this.data[beginPos] = data;
    for (int i = beginPos + 1; i < endPos; i++) {
      checkValue(this.data[i]);
      this.data[i] = "";
    }
  }

  String getChunk(final int beginPos, final int endPos) {
    if (endPos < beginPos || endPos > stringData.length()) {
      throw new IllegalExtractorOututException("Illegal data, requested position begin: " + beginPos + ", end: "
        + endPos + ", input lenght: " + stringData.length());
    }
    return stringData.substring(beginPos, endPos);
  }

  String getWrapped() {
    String result = "";
    for (final String s : data) {
      result += s;
    }
    return result;
  }

  private void checkValue(String value) {
    if (value.equals("")) {
      throw new IllegalCrawlerOutputException("Crawler output data intersection");
    }
  }
}
