package com.spacetimecat.drawable;

import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.geometry.Rectangle;

@Deprecated
public class UnderDrawable extends AbstractDrawable
{
    private final DrawFunction delegate;

    public UnderDrawable (DrawFunction delegate)
    {
        this.delegate = delegate;
    }

    @Override
    public Rectangle bounds (Drawer g)
    {
        throw new UnsupportedOperationException("bounds"); // TODO separate Bounded from Drawable
    }

    @Override
    public void draw (Drawer g)
    {
        delegate.draw(g);
    }
}
