Pollexor - Java Thumbor client by Square
========================================

Java client for the [Thumbor image service][1] which allows you to build URIs
in an expressive fashion using a fluent API.

This library is also fully compatible with the Android platform.

Thanks for Square.

I change the url params style, because TimeFace's Thumbor image service change the original params style to  http://the/path/to/the/image.jpg?image=URLEncoder.encode("original/params/whithout/image/path/") .

Examples
--------

```java
// Without encryption:
Thumbor thumbor = Thumbor.create();

// With encryption:
Thumbor thumbor = Thumbor.create("key");
```

```java
thumbor.buildImage("http://example.com/image.png")
    .resize(48, 48)
    .toUrl()
// Produces: http://example.com/image.png?image=URLEncoder.encode("unsafe/48x48/", "UTF-8")

thumbor.buildImage("http://example.com/image.png")
    .crop(10, 10, 90, 90)
    .resize(40, 40)
    .smart()
    .toUrl()
// Produces: http://example.com/image.png?image=URLEncoder.encode("unsafe/10x10:90x90/smart/40x40/", "UTF-8")

thumbor.buildImage("http://example.com/image.png")
    .crop(5, 5, 195, 195)
    .resize(95, 95)
    .align(BOTTOM, RIGHT)
    .toUrl()
// Produces: http://example.com/image.png?image=URLEncoder.encode("unsafe/5x5:195x195/right/bottom/95x95/", "UTF-8")

thumbor.buildImage("http://example.com/background.png")
    .resize(200, 100)
    .filter(
        roundCorner(10),
        watermark(thumbor.buildImage("http://example.com/overlay1.png").resize(200, 100)),
        watermark(thumbor.buildImage("http://example.com/overlay2.png").resize(50, 50), 75, 25),
        quality(85)
    )
    .toUrl()
// Produces: http://example.com/image.png?image=URLEncoder.encode("unsafe/200x100/filters:round_corner(10,255,255,255):watermark(http://example.com/overlay1.png?image=URLEncoder.encode("unsafe/200x100/", "UTF-8"),0,0,0):watermark(http://example.com/overlay2.png?image=URLEncoder.encode("unsafe/50x50/","UTF-8"),75,25,0):quality(85)/", "UTF-8")
```

*Note:* If you are using a version of Thumbor older than 3.0 you must call
`legacy()` to ensure the encryption used will be supported by the server.


 [1]: https://github.com/globocom/thumbor
 [2]: https://search.maven.org/remote_content?g=com.squareup&a=pollexor&v=LATEST
 [3]: http://square.github.io/pollexor/

 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
