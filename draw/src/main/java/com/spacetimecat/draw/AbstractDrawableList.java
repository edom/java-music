package com.spacetimecat.draw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * <p>
 *     A {@link DrawableList} base class.
 * </p>
 */
public abstract class AbstractDrawableList extends AbstractDrawable implements DrawableList
{
    private final List<Drawable> items = new ArrayList<>(64);

    protected AbstractDrawableList () {}

    protected abstract void doDraw (Drawer h);

    @Override
    public final void draw (Drawer g)
    {
        try (final Drawer h = g.copy())
        {
            doDraw(h);
        }
    }

    @Override
    public final void add (Drawable item)
    {
        items.add(item);
    }

    @Override
    public final void addAll (Drawable... items)
    {
        this.items.addAll(Arrays.asList(items));
    }

    protected final void forEach (Consumer<? super Drawable> action)
    {
        items.forEach(action);
    }

    @Override
    public final Rectangle bounds (Drawer g)
    {
        return items.stream()
            .map(item -> item.bounds(g))
            .reduce(Rectangle::union)
            .orElseGet(Rectangle::empty)
        ;
    }
}
