javac -target 1.6 -source 1.6 com/carrotcreative/shortcake/*.java
jar cf ../shortcake-1.0.0.jar com/carrotcreative/shortcake/*.class
rm com/carrotcreative/shortcake/*.class
