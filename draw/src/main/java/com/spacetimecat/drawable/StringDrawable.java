package com.spacetimecat.drawable;

import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.geometry.Rectangle;

final class StringDrawable extends AbstractDrawable
{
    private final String string;

    StringDrawable (String string)
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
        g.string(string, 0, 0);
    }

    @SuppressWarnings("DesignForExtension")
    @Override
    public String toString ()
    {
        return string;
    }
}
