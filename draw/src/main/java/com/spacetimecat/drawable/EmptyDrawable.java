package com.spacetimecat.drawable;

import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.geometry.Rectangle;

final class EmptyDrawable extends AbstractDrawable
{
    @Override
    public Rectangle bounds (Drawer g)
    {
        return Rectangle.empty();
    }

    @Override
    public void draw (Drawer g)
    {
    }
}
