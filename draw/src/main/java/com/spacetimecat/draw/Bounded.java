package com.spacetimecat.draw;

/**
 * <p>
 *     A thing that has a bounding {@link Rectangle}.
 * </p>
 */
public interface Bounded
{
    /**
     * <p>
     *     The bounding rectangle of this thing
     *     in the coordinate system used by {@code g}.
     * </p>
     */
    Rectangle bounds (Drawer g);
}
