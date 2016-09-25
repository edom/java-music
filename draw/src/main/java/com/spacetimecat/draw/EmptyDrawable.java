package com.spacetimecat.draw;

final class EmptyDrawable extends AbstractDrawable
{
    @Override
    public Rectangle bounds (Drawer g)
    {
        return new EmptyRectangle();
    }

    @Override
    public void draw (Drawer g)
    {
    }
}
