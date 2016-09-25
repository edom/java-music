package com.spacetimecat.draw;

/**
 * <p>
 *     A {@link Drawable} that lays out its children
 *     downwards with the same spacing between children.
 * </p>
 */
public final class Downwards extends AbstractDrawableList
{
    private Downwards () {}

    public static DrawableList create ()
    {
        return new Downwards();
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
                h.translate(0, bounds.height());
            }
        );
    }
}
