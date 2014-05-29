Shortcake
=========


### Usage
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

### Caveats

The formatting of the shortcode will have to be following the example mentioned in the usage section.

A few things to look out for
  - Variable names can't be broken by a space
  - You can't use single quotes to hold the variables.

All of these issues can be managed by your own custom preparsing logic.
