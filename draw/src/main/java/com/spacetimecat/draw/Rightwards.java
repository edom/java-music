package com.spacetimecat.draw;

/**
 * <p>
 *     A {@link Drawable} that lays out its children
 *     rightwards with the same spacing between children.
 * </p>
 */
public final class Rightwards extends AbstractDrawableList
{
    private Rightwards () {}

    public static DrawableList create ()
    {
        return new Rightwards();
    }

    public static DrawableList of (Drawable... items)
    {
        final DrawableList parent = create();
        parent.addAll(items);
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
                h.translate(bounds.width(), 0);
            }
        );
    }
}
