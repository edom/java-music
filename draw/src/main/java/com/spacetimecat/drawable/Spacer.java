package com.spacetimecat.drawable;

import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.geometry.Rectangle;

/**
 * <p>
 *     A {@link Drawable} that is invisible but has size.
 * </p>
 * <p>
 *     This is usually used to give space between two {@link Drawable}s.
 * </p>
 */
public final class Spacer extends AbstractDrawable
{
    private final Rectangle bounds;

    private Spacer (Rectangle bounds)
    {
        this.bounds = bounds;
    }

    public static Spacer create (Rectangle bounds)
    {
        return new Spacer(bounds);
    }

    public static Spacer fromSize (double width, double height)
    {
        return new Spacer(Rectangle.fromSize(width, height));
    }

    @Override
    public Rectangle bounds (Drawer g)
    {
        return bounds;
    }

    @Override
    public void draw (Drawer g)
    {
    }
}
