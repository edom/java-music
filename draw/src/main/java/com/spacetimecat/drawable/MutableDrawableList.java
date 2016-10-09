package com.spacetimecat.drawable;

import java.util.Collection;

/**
 * <p>
 *     A mutable list of {@link Drawable}s.
 * </p>
 */
public interface MutableDrawableList extends DrawableList
{
    void add (Drawable item);

    void addArray (Drawable... items);

    void addAll (Collection<? extends Drawable> items);
}
