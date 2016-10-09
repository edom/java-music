package com.spacetimecat.drawable;

import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.geometry.Rectangle;

import java.util.Collection;

/**
 * <p>
 *     A {@link Drawable} that lays out its children
 *     rightwards with the same spacing between children.
 * </p>
 */
public final class Rightwards extends AbstractMutableDrawableList
{
    private Rightwards () {}

    public static MutableDrawableList create ()
    {
        return new Rightwards();
    }

    public static MutableDrawableList of (Drawable... items)
    {
        final MutableDrawableList parent = create();
        parent.addArray(items);
        return parent;
    }

    public static MutableDrawableList of (Collection<? extends Drawable> items)
    {
        final MutableDrawableList parent = create();
        parent.addAll(items);
        return parent;
    }

    protected void doDraw (Drawer h)
    {
        forEach
        (
            item ->
            {
                item.draw(h);
                final Rectangle bounds = item.bounds(h);
                h.translate(bounds.width(), 0);
            }
        );
    }
}
