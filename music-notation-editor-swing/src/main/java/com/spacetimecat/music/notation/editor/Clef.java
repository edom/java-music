package com.spacetimecat.music.notation.editor;

import com.spacetimecat.draw.Drawable;

final class Clef extends FromFont
{
    private Clef (String string)
    {
        super(string);
    }

    static Drawable f ()
    {
        return new Clef("\uE062");
    }

    static Drawable g ()
    {
        return new Clef("\uE050");
    }
}
