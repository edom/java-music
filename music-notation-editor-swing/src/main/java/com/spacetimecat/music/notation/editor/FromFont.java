package com.spacetimecat.music.notation.editor;

import com.spacetimecat.draw.Drawer;
import com.spacetimecat.draw.AbstractDrawable;
import com.spacetimecat.draw.Rectangle;

class FromFont extends AbstractDrawable
{
    private final String string;

    FromFont (String string)
    {
        this.string = string;
    }

    @Override
    public Rectangle bounds (Drawer g)
    {
        return g.boundsOf(string);
    }

    @Override
    public void draw (Drawer g)
    {
        g.string(string, 0.0, 0.0);
    }
}
