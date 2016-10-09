package com.spacetimecat.drawable;

import com.spacetimecat.drawer.Drawer;
import com.spacetimecat.geometry.Rectangle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * <p>
 *     A {@link DrawableList} base class.
 * </p>
 */
public abstract class AbstractMutableDrawableList extends AbstractDrawable implements MutableDrawableList
{
    private final List<Drawable> items = new ArrayList<>(64);

    protected AbstractMutableDrawableList () {}

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
    public final void addArray (Drawable... items)
    {
        for (final Drawable item : items)
        {
            this.items.add(item);
        }
    }

    @Override
    public final void addAll (Collection<? extends Drawable> items)
    {
        this.items.addAll(items);
    }

    @Override
    public int size ()
    {
        return items.size();
    }

    @Override
    public void addTo (List<? super Drawable> target)
    {
        target.addAll(items);
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
