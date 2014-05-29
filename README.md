Shortcake
=========

If you needed to parse a shortcode that looked like this 

```
[foo="FOO!!" bar="BAR!!!" baz="BAZ!!!!"]
```

You could easily parse out each of the components like this:

```java
HashMap<String, String> shortCodeMap = Shortcake.parse(shortCodeString)
    .addElement("foo")
    .addElement("bar")
    .addElement("baz")
    .toHashMap();

if (shortCodeMap != null) {
    String fooValue = shortCodeMap.get("foo"); // FOO!!
    String barValue = shortCodeMap.get("bar"); // BAR!!!
    String bazValue = shortCodeMap.get("baz"); // BAZ!!!!
}
```