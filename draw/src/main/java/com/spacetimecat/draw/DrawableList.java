package com.spacetimecat.draw;

/**
 * <p>
 *     A list of {@link Drawable}s.
 * </p>
 */
public interface DrawableList extends Drawable
{
    void add (Drawable item);

    void addAll (Drawable... items);
}
