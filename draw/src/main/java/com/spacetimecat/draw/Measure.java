package com.spacetimecat.draw;

/**
 * <p>
 *     Something that can measure the bounding {@link Rectangle} of strings?
 * </p>
 */
public interface Measure
{
    /**
     * Compute the bounding rectangle of the string.
     */
    Rectangle boundsOf (String string);
}
