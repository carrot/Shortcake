package com.carrotcreative.shortcake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shortcake {

    private String mShortcode;
    private ShortcodePatternBuilder mPatternBuilder;
    private ArrayList<String> mElements;

    private Shortcake(String shortcode)
    {
        mShortcode = shortcode;
        mPatternBuilder = ShortcodePatternBuilder.getInstance();
        mElements = new ArrayList<String>();
    }

    public static Shortcake parse(String shortcode)
    {
        Shortcake shortcake = new Shortcake(shortcode);
        return shortcake;
    }

    public Shortcake addElement(String element)
    {
        mPatternBuilder.addElement(element);
        mElements.add(element);
        return this;
    }

    public HashMap<String, String> toHashMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();

        Pattern pattern = mPatternBuilder.build();
        Matcher matcher = pattern.matcher(mShortcode);

        for (int groupNumber = 1; groupNumber <= matcher.groupCount(); groupNumber++)
        {
            int arrayPosition = groupNumber - 1;
            map.put(mElements.get(arrayPosition), matcher.group(groupNumber));
        }

        if(map.keySet().size() > 0)
        {
            return map;
        }
        else
        {
            return null;
        }
    }

}
