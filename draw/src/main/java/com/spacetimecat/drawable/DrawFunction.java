package com.spacetimecat.drawable;

import com.spacetimecat.drawer.Drawer;

/**
 * <p>
 *     This tells {@link Drawer} what to draw;
 *     {@link Drawer} knows how to draw
 *     but does not know what to draw.
 * </p>
 * <p>
 *     This describes a drawing in terms of primitives provided by {@link Drawer}.
 * </p>
 */
@FunctionalInterface
public interface DrawFunction
{
    /**
     * <p>
     *     Translate this thing into drawing commands.
     * </p>
     */
    void draw (Drawer g);

    /**
     * <p>
     *     An empty drawing that does not touch the {@link Drawer}.
     * </p>
     *
     * @return see description
     */
    static DrawFunction empty ()
    {
        return (g) -> {};
    }

    static DrawFunction string (String string)
    {
        return new StringDrawable(string);
    }
}
