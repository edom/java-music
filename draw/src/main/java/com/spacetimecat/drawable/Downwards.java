package com.spacetimecat.drawable;

import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.geometry.Rectangle;

/**
 * <p>
 *     A {@link Drawable} that lays out its children
 *     downwards with the same spacing between children.
 * </p>
 */
public final class Downwards extends AbstractMutableDrawableList
{
    private Downwards () {}

    public static MutableDrawableList create ()
    {
        return new Downwards();
    }

    public static MutableDrawableList of (Drawable... items)
    {
        final MutableDrawableList parent = create();
        parent.addArray(items);
        return parent;
    }

    @Override
    protected void doDraw (Drawer h)
    {
        forEach
        (
            item ->
            {
                item.draw(h);
                final Rectangle bounds = item.bounds(h);
                h.translate(0, bounds.height());
            }
        );
    }
}
