// Copyright 2013 Square, Inc.
package com.squareup.pollexor;

/**
 * Representation of a remote <a href="https://github.com/globocom/thumbor">thumbor</a>
 * installation.
 */
public final class Thumbor {
    /**
     * Create a new instance for the specified host.
     *
     * @see #create(String)
     */
    public static Thumbor create() {
        return new Thumbor(null);
    }

    /**
     * Create a new instance for the specified host and encryption key.
     *
     * @see #create(String)
     */

    public static Thumbor create(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("Key must not be blank.");
        }
        return new Thumbor(key);
    }

    private final String key;

    private Thumbor(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    /**
     * Begin building a url for this host with the specified image.
     */
    public ThumborUrlBuilder buildImage(String image) {
        if (image == null || image.length() == 0 || !image.contains("http")) {
            throw new IllegalArgumentException("Invalid image.");
        }
        if (image.contains("?")) {
            //丢弃所有参数
            image = image.substring(0, image.indexOf("?"));
        }
        return new ThumborUrlBuilder(key, image);
    }
}
