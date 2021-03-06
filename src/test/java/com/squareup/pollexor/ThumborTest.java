package com.squareup.pollexor;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;

public class ThumborTest {
  @Test public void testCannotAddInvalidKey() {
    try {
      Thumbor.create(null);
      fail("Bad key string allowed.");
    } catch (IllegalArgumentException expected) {
    }

    try {
      Thumbor.create("");
      fail("Bad key string allowed.");
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test public void testCannotAddInvalidHost() {
    try {
      Thumbor.create(null);
      fail("Bad host string allowed.");
    } catch (IllegalArgumentException expected) {
    }

    try {
      Thumbor.create("");
      fail("Bad host string allowed.");
    } catch (IllegalArgumentException expected) {
    }
  }

  @Test public void testCannotBuildWithInvalidTarget() {
    Thumbor thumbor = Thumbor.create("http://example.com");

    try {
      thumbor.buildImage(null);
      fail("Bad target image URL allowed.");
    } catch (IllegalArgumentException expected) {
    }

    try {
      thumbor.buildImage("");
      fail("Bad target image URL allowed.");
    } catch (IllegalArgumentException expected) {
    }
  }

}
