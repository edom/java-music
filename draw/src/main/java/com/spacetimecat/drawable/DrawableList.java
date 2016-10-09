package com.spacetimecat.drawable;

import java.util.List;

/**
 * <p>
 *     A list of {@link Drawable}s.
 * </p>
 */
public interface DrawableList extends Drawable
{
    int size ();

    void addTo (List<? super Drawable> target);
}
