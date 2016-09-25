package com.spacetimecat.music.notation.editor;

import com.spacetimecat.draw.Drawable;

public class Note extends FromFont
{
    Note (String string)
    {
        super(string);
    }

    public static Drawable quarter ()
    {
        return new Note("\uE0A4");
    }
}
