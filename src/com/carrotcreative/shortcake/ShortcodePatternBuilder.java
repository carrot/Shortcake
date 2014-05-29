package com.carrotcreative.shortcake;

import java.util.regex.Pattern;

public class ShortcodePatternBuilder {

    public static ShortcodePatternBuilder getInstance()
    {
        return new ShortcodePatternBuilder();
    }

    private String mPatternString;

    private ShortcodePatternBuilder()
    {
        mPatternString = "";
    }

    public ShortcodePatternBuilder addElement(String element)
    {
        mPatternString += ".*" + element + "=\"(.*)\"";
        return this;
    }

    public Pattern build(){
        mPatternString += ".*";
        return Pattern.compile(mPatternString);
    }

}